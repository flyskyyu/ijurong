package com.party.ijurong.service;

import com.party.ijurong.bean.Page;
import com.party.ijurong.pojo.ExamQuestion;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Created by yu on 2017/5/19.
 */
@Service
public class ExamQuestionService extends BaseService<ExamQuestion>{

    /**
     * 查询所有题干
     * @param examQuestion
     * @param page
     * @param rows
     * @return
     */
    public Page<ExamQuestion> findExamQuestionsByExamQuestion(ExamQuestion examQuestion, int page, int rows) {
        RowBounds rowBounds=new RowBounds((page - 1) * rows,page*rows);
        Example example = new Example(ExamQuestion.class);
        if(examQuestion.getQuestionContent()!=null&&examQuestion.getQuestionContent()!="") {
            example.createCriteria().andLike("questionContent", "%" + examQuestion.getQuestionContent() + "%");
        }
        example.setOrderByClause("id DESC");
        List<ExamQuestion> list =mapper.selectByExampleAndRowBounds(example,rowBounds);
        long count = mapper.selectCountByExample(example);
        return new Page<ExamQuestion>(count, list);
    }

    public ExamQuestion findExamQuestionById(int id) {
        ExamQuestion examQuestion=new ExamQuestion();
        examQuestion.setId(id);
        return  mapper.selectOne(examQuestion);
    }


    /**
     * 根据名称查询题干
     * @param name
     * @return
     */
    public long findExamQuestionsByName(String name)
    {
        ExamQuestion examQuestion=new ExamQuestion();
        examQuestion.setQuestionContent(name);
        return mapper.selectCount(examQuestion);
    }

    /**
     * 添加题干
     * @param examQuestion
     */
    public void insertExamQuestion(ExamQuestion examQuestion)
    {
        mapper.insert(examQuestion);
    }

    /**
     * 更新题干
     * @param examQuestion
     */
    public void updateExamQuestion(ExamQuestion examQuestion)
    {
        mapper.updateByPrimaryKeySelective(examQuestion);
    }

    /**
     * 删除题干
     * @param id
     */
    public void deleteExamQuestion(int id)
    {
        ExamQuestion examQuestion=new ExamQuestion();
        examQuestion.setId(id);
        mapper.delete(examQuestion);
    }

}
