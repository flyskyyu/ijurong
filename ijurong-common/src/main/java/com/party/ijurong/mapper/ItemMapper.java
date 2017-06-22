package com.party.ijurong.mapper;

import com.party.ijurong.pojo.Item;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface ItemMapper extends Mapper<Item> {
    List<Item> queryHotList();
}