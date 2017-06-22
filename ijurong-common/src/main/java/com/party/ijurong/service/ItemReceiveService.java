package com.party.ijurong.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.party.ijurong.dto.ItemReceiveDto;
import com.party.ijurong.mapper.ItemMapper;
import com.party.ijurong.mapper.ItemReceiveMapper;
import com.party.ijurong.mapper.StaffMapper;
import com.party.ijurong.pojo.Item;
import com.party.ijurong.pojo.ItemReceive;
import com.party.ijurong.pojo.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

/**
 * Created by Cloud on 2017/5/24.
 */
@Service
public class ItemReceiveService extends BaseService<ItemReceive> {
    public final static int OK = 1;
    public final static int NUM_LACK = 2;
    public final static int INTEGRAL_LACK = 3;
    @Autowired
    private ItemReceiveMapper receiveMapper;
    @Autowired
    private ItemMapper itemMapper;
    @Autowired
    private StaffMapper staffMapper;

    public PageInfo<ItemReceiveDto> queryByItemReceiveDto(ItemReceiveDto dto, int page, int rows) {
        PageHelper.startPage(page, rows);
        List<ItemReceiveDto> dtos = receiveMapper.queryReceiveDtoList(dto);
        return new PageInfo<>(dtos);
    }

    public PageInfo<ItemReceive> queryByItemReceive(ItemReceive itemReceive, int page, int rows) {
        Example example = new Example(ItemReceive.class);
        Example.Criteria criteria = example.createCriteria();
        if(itemReceive.getUserId() != null) {
            criteria.andEqualTo("userId", itemReceive.getUserId());
        }
        example.orderBy("id").desc();
        PageHelper.startPage(page, rows);
        List<ItemReceive> list = receiveMapper.selectByExample(example);
        return new PageInfo<>(list);
    }

    public int apply(ItemReceive itemReceive) {
        itemReceive.setId(null);
        itemReceive.setApplyTime(new Date());
        itemReceive.setIsAgree(null);
        Item item = itemMapper.selectByPrimaryKey(itemReceive.getItemId());
        Staff staff = staffMapper.selectByPrimaryKey(itemReceive.getUserId());
        int integral = item.getIntegral() * itemReceive.getNum();
        if(staff.getIntegral() < integral) {
            return INTEGRAL_LACK;
        }
        if(item.getNum() < itemReceive.getNum()) {
            return NUM_LACK;
        }
        itemReceive.setItemName(item.getItemName());
        itemReceive.setIntegral(integral);
        receiveMapper.insertSelective(itemReceive);
        staff.setIntegral(staff.getIntegral() - integral);
        staffMapper.updateByPrimaryKeySelective(staff);
        item.setNum(item.getNum() - itemReceive.getNum());
        itemMapper.updateByPrimaryKeySelective(item);
        return 1;
    }

    public int reply(ItemReceive itemReceive) {
        ItemReceive dbReceive = receiveMapper.selectByPrimaryKey(itemReceive.getId());
        if(itemReceive.getIsAgree() == 1) {
            dbReceive.setIsReceive((byte)0); //设置状态为未领取
        } else {
            if(dbReceive.getIntegral() > 0) {
                Staff staff = staffMapper.selectByPrimaryKey(dbReceive.getUserId());
                staff.setIntegral(staff.getIntegral() + dbReceive.getIntegral());
                staffMapper.updateByPrimaryKey(staff);
            }
            Item item = itemMapper.selectByPrimaryKey(dbReceive.getItemId());
            item.setNum(item.getNum() + dbReceive.getNum());
            itemMapper.updateByPrimaryKey(item);
        }
        dbReceive.setIsAgree(itemReceive.getIsAgree());
        dbReceive.setReply(itemReceive.getReply());
        receiveMapper.updateByPrimaryKeySelective(dbReceive);
        return OK;
    }
}
