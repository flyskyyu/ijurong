package com.party.ijurong.service;

import com.party.ijurong.bean.Page;
import com.party.ijurong.dto.UserAnswerDto;
import com.party.ijurong.mapper.UserAnswerMapper;
import com.party.ijurong.pojo.UserAnswer;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by yu on 2017/5/19.
 */
@Service
public class UserAnswerService extends BaseService<UserAnswer>{

    @Autowired
    private UserAnswerMapper userAnswerMapper;
    /**
     * 查询所有
     * @param page
     * @param rows
     * @return
     */
    public Page<UserAnswer> findUserAnswersByUserAnswer(UserAnswer userAnswer,int page, int rows) {
        RowBounds rowBounds=new RowBounds((page - 1) * rows,page*rows);
        List<UserAnswer> list =mapper.selectByRowBounds(userAnswer, rowBounds);
        long count = mapper.selectCount(userAnswer);
        return new Page<UserAnswer>(count, list);
    }


    /**
     *
     * @param researchId 问卷id
     * @param userId 用户id
     * @return
     */
    public List<UserAnswer> findUserAnswersByUserAnswer(int researchId,int userId) {
        UserAnswer userAnswer=new UserAnswer();
        userAnswer.setResearchId(researchId);
        userAnswer.setUserId(userId);
        List<UserAnswer> list =mapper.select(userAnswer);
        return list;
    }

    public List<UserAnswerDto> getCorrectAnswer(int researchExamId)
    {
        List<UserAnswerDto> list=userAnswerMapper.getCorrectAnswer(researchExamId);
        return list;
    }


    /**
     * 添加
     * @param userAnswer
     */
    public void insertUserAnswer(UserAnswer userAnswer)
    {
        mapper.insert(userAnswer);
    }

    /**
     * 更新
     * @param userAnswer
     */
    public void updateUserAnswer(UserAnswer userAnswer)
    {
        mapper.updateByPrimaryKeySelective(userAnswer);
    }

    /**
     * 删除
     * @param id
     */
    public void deleteUserAnswer(int id)
    {
        UserAnswer userAnswer=new UserAnswer();
        userAnswer.setId(id);
        mapper.delete(userAnswer);
    }

}
