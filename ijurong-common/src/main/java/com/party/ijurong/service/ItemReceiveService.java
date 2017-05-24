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

import java.util.List;

/**
 * Created by Cloud on 2017/5/24.
 */
@Service
public class ItemReceiveService extends BaseService<ItemReceive> {
    public final static int OK = 1;
    public final static int NUM_LACK = 2;
    @Autowired
    private ItemReceiveMapper receiveMapper;
    @Autowired
    private ItemMapper itemMapper;
    @Autowired
    private StaffMapper staffMapper;

    public PageInfo<ItemReceiveDto> queryByItemReceive(ItemReceiveDto dto, int page, int rows) {
        PageHelper.startPage(page, rows);
        List<ItemReceiveDto> dtos = receiveMapper.queryReceiveDtoList(dto);
        return new PageInfo<>(dtos);
    }

    public int reply(ItemReceive itemReceive) {
        ItemReceive dbReceive = receiveMapper.selectByPrimaryKey(itemReceive.getId());
        if(itemReceive.getIsAgree() == 1) {
            Item item = itemMapper.selectByPrimaryKey(dbReceive.getItemId());
            if(item.getNum() < dbReceive.getNum()) {
                return NUM_LACK;
            }
            item.setNum(item.getNum() - dbReceive.getNum());
            itemMapper.updateByPrimaryKey(item);
            dbReceive.setIsReceive((byte)0); //设置状态为未领取
        } else {
            if(dbReceive.getIntegral() > 0) {
                Staff staff = staffMapper.selectByPrimaryKey(dbReceive.getUserId());
                staff.setIntegral(staff.getIntegral() + dbReceive.getIntegral());
                staffMapper.updateByPrimaryKey(staff);
            }
        }
        dbReceive.setIsAgree(itemReceive.getIsAgree());
        dbReceive.setReply(itemReceive.getReply());
        receiveMapper.updateByPrimaryKeySelective(dbReceive);
        return OK;
    }
}
