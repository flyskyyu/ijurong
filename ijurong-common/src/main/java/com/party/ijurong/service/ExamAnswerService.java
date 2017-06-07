package com.party.ijurong.service;

import com.party.ijurong.bean.Page;
import com.party.ijurong.pojo.ExamAnswer;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Created by yu on 2017/5/19.
 */
@Service
public class ExamAnswerService extends BaseService<ExamAnswer>{

    /**
     * 查询所有选项
     * @param examAnswer
     * @param page
     * @param rows
     * @return
     */
    public Page<ExamAnswer> findExamAnswersByExamAnswer(ExamAnswer examAnswer, int page, int rows) {
        RowBounds rowBounds=new RowBounds((page - 1) * rows,page*rows);
        Example example = new Example(ExamAnswer.class);
        if(examAnswer.getQuestionId()!=null) {
            example.createCriteria().andEqualTo("questionId", examAnswer.getQuestionId());
        }
        example.setOrderByClause("option_num ASC");
        List<ExamAnswer> list =mapper.selectByExampleAndRowBounds(example,rowBounds);
        long count = mapper.selectCountByExample(example);
        return new Page<ExamAnswer>(count, list);
    }



    public List<ExamAnswer> findExamAnswersByQuestionId(int questionId) {
        Example example = new Example(ExamAnswer.class);
        example.createCriteria().andEqualTo("questionId", questionId);
        example.setOrderByClause("option_num ASC");
        List<ExamAnswer> list =mapper.selectByExample(example);
        return list;
    }


    public ExamAnswer findExamAnswerById(int id) {
        ExamAnswer examAnswer=new ExamAnswer();
        examAnswer.setId(id);
        return  mapper.selectOne(examAnswer);
    }

    /**
     * 添加选项
     * @param questionId
     * @param list
     */
    public void insertExamAnswer(int questionId,List<ExamAnswer> list)
    {
        //insert
        for(int i=0;i<list.size();i++)
        {
            ExamAnswer examAnswer=list.get(i);
            examAnswer.setQuestionId(questionId);
            mapper.insert(examAnswer);
        }

    }

    public void updateExamAnswer(int questionId,List<ExamAnswer> list)
    {
            //先删除
        ExamAnswer examAnswer1=new ExamAnswer();
        examAnswer1.setQuestionId(questionId);
        mapper.delete(examAnswer1);
        //insert
        for(int i=0;i<list.size();i++)
        {
            ExamAnswer examAnswer=list.get(i);
            examAnswer.setQuestionId(questionId);
            mapper.insert(examAnswer);
        }
    }

    public void deleteExamAnswer(int questionId)
    {
        ExamAnswer examAnswer1=new ExamAnswer();
        examAnswer1.setQuestionId(questionId);
        mapper.delete(examAnswer1);
    }


//    public void insertExamAnswer(ExamAnswer examAnswer)
//    {
//        mapper.insert(examAnswer);
//    }
//
//    /**
//     * 更新选项
//     * @param examAnswer
//     */
//    public void updateExamAnswer(ExamAnswer examAnswer)
//    {
//        mapper.updateByPrimaryKeySelective(examAnswer);
//    }

//    /**
//     * 删除选项
//     * @param id
//     */
//    public void deleteExamAnswer(int id)
//    {
//        ExamAnswer examAnswer=new ExamAnswer();
//        examAnswer.setId(id);
//        mapper.delete(examAnswer);
//    }

}
