package com.party.ijurong.mapper;

import com.party.ijurong.dto.UserAnswerDto;
import com.party.ijurong.pojo.UserAnswer;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface UserAnswerMapper extends Mapper<UserAnswer> {
    List<UserAnswerDto> getCorrectAnswer(int researchExamId);
}