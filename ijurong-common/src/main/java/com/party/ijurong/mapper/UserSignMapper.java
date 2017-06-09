package com.party.ijurong.mapper;

import com.party.ijurong.pojo.UserSign;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface UserSignMapper extends Mapper<UserSign> {
    List<UserSign> findUserSignByUserIdAndDate(int userId);
}