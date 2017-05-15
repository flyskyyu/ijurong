package com.party.ijurong.common;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.ids.DeleteByIdsMapper;
import tk.mybatis.mapper.common.ids.SelectByIdsMapper;

/**
 * Created by Cloud on 2017/2/14.
 */
public interface BaseMapper<T> extends Mapper<T>, DeleteByIdsMapper<T>, SelectByIdsMapper<T> {
}
