package com.party.ijurong.service;

import com.party.ijurong.bean.Page;
import com.party.ijurong.dto.ExamPaperDto;
import com.party.ijurong.dto.ResearchDto;
import com.party.ijurong.mapper.ResearchExamMapper;
import com.party.ijurong.pojo.ResearchExam;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Created by yu on 2017/5/19.
 */
@Service
public class ResearchExamService extends BaseService<ResearchExam>{

    @Autowired
    private ResearchExamMapper researchExamMapper;
    /**
     * 查询所有问卷题目
     * @param researchExam
     * @param page
     * @param rows
     * @return
     */
    public Page<ResearchExam> findResearchExamsByResearchExam(ResearchExam researchExam, int page, int rows) {
        RowBounds rowBounds=new RowBounds((page - 1) * rows,page*rows);
        Example example = new Example(ResearchExam.class);
        if(researchExam.getResearchId()!=null) {
            example.createCriteria().andEqualTo("researchId", researchExam.getResearchId());
        }
        example.setOrderByClause("question_sort ASC");
        List<ResearchExam> list =mapper.selectByExampleAndRowBounds(example,rowBounds);
        long count = mapper.selectCountByExample(example);
        return new Page<ResearchExam>(count, list);
    }



    public List<ResearchExam> findResearchExamsByResearchId(int researchId) {
        Example example = new Example(ResearchExam.class);
        example.createCriteria().andEqualTo("researchId", researchId);
        example.setOrderByClause("question_sort ASC");
        List<ResearchExam> list =mapper.selectByExample(example);
        return list;
    }


    public ResearchExam findResearchExamById(int id) {
        ResearchExam researchExam=new ResearchExam();
        researchExam.setId(id);
        return  mapper.selectOne(researchExam);
    }

    /**
     * 添加问卷题目
     * @param researchId
     * @param list
     */
    public void insertResearchExam(int researchId,List<ResearchExam> list)
    {
        //insert
        for(int i=0;i<list.size();i++)
        {
            ResearchExam researchExam=list.get(i);
            researchExam.setResearchId(researchId);
            mapper.insert(researchExam);
        }

    }

    public void updateResearchExam(int researchId,List<ResearchExam> list)
    {
        //先删除
        ResearchExam researchExam1=new ResearchExam();
        researchExam1.setResearchId(researchId);
        mapper.delete(researchExam1);
        //insert
        for(int i=0;i<list.size();i++)
        {
            ResearchExam researchExam=list.get(i);
            researchExam.setResearchId(researchId);
            mapper.insert(researchExam);
        }
    }

    public void deleteResearchExam(int researchId)
    {
        ResearchExam researchExam1=new ResearchExam();
        researchExam1.setResearchId(researchId);
        mapper.delete(researchExam1);
    }

    public List<ResearchDto> getResearchByResearchId(int researchId)
    {
        return researchExamMapper.getResearchByResearchId(researchId);
    }

    public List<ExamPaperDto> getExamPaperByResearchId(int researchId)
    {
        return researchExamMapper.getExamPaperByResearchId(researchId);
    }



}
