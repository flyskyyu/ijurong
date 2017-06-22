package com.party.ijurong.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.party.ijurong.bean.Page;
import com.party.ijurong.mapper.ItemMapper;
import com.party.ijurong.pojo.Item;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Created by Administrator on 2017/5/23 0023.
 */
@Service
public class ItemService extends BaseService<Item> {
    @Autowired
    private ItemMapper itemMapper;

    public PageInfo<Item> queryByItem(Item item, int page, int rows) {
        Example example = new Example(Item.class);
        Example.Criteria criteria = example.createCriteria();
        String itemName = item.getItemName();
        if(itemName != null && StringUtils.isNotEmpty(itemName.trim())) {
            criteria.andLike("itemName", "%" + itemName+ "%");
        }
        if(item.getBelong() != null) {
            criteria.andEqualTo("belong", item.getBelong());
        }
        example.orderBy("id").desc();
        PageHelper.startPage(page, rows);
        List<Item> items = itemMapper.selectByExample(example);
        return new PageInfo<>(items);
    }

    public List<Item> queryHotList() {
        PageHelper.startPage(1, 4);
        List<Item> list = itemMapper.queryHotList();
        return list;
    }
}
