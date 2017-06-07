package com.party.ijurong.service;

import com.party.ijurong.bean.Page;
import com.party.ijurong.pojo.Research;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Created by yu on 2017/5/19.
 */
@Service
public class ResearchService extends BaseService<Research>{

    /**
     * 查询所有问卷
     * @param research
     * @param page
     * @param rows
     * @return
     */
    public Page<Research> findResearchsByResearch(Research research, int page, int rows) {
        RowBounds rowBounds=new RowBounds((page - 1) * rows,page*rows);
        Example example = new Example(Research.class);
        if(research.getResearchName()!=null&&research.getResearchName()!="") {
            example.createCriteria().andLike("researchName", "%" + research.getResearchName() + "%");
        }
        example.setOrderByClause("create_time DESC");
        List<Research> list =mapper.selectByExampleAndRowBounds(example,rowBounds);
        long count = mapper.selectCountByExample(example);
        return new Page<Research>(count, list);
    }

    public Research findResearchById(int id) {
        Research research=new Research();
        research.setId(id);
        return  mapper.selectOne(research);
    }


    /**
     * 根据名称查询问卷
     * @param name
     * @return
     */
    public long findResearchsByName(String name)
    {
        Research research=new Research();
        research.setResearchName(name);
        return mapper.selectCount(research);
    }

    /**
     * 添加问卷
     * @param research
     */
    public void insertResearch(Research research)
    {
        mapper.insert(research);
    }

    /**
     * 更新问卷
     * @param research
     */
    public void updateResearch(Research research)
    {
        mapper.updateByPrimaryKeySelective(research);
    }

    /**
     * 删除问卷
     * @param id
     */
    public void deleteResearch(int id)
    {

        Research research=new Research();
        research.setId(id);
        mapper.delete(research);
    }

}
