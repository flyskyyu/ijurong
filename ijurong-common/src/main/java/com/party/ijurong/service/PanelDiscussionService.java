package com.party.ijurong.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.party.ijurong.bean.Page;
import com.party.ijurong.dto.PanelDiscussionDto;
import com.party.ijurong.mapper.PanelDiscussionMapper;
import com.party.ijurong.pojo.PanelDiscussion;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Created by yu on 2017/5/19.
 */
@Service
public class PanelDiscussionService extends BaseService<PanelDiscussion>{

    @Autowired
    private PanelDiscussionMapper panelDiscussionMapper;

    public PageInfo<PanelDiscussionDto> findPanelDiscussionsByIsShadow(int isShadow, int page, int rows)
    {
        PageHelper.startPage(page, rows);
        List<PanelDiscussionDto> dtos = panelDiscussionMapper.findPanelDiscussionsByIsShadow(isShadow);
        return new PageInfo<>(dtos);
    }
    /**
     * 查询所有讨论
     * @param panelDiscussion
     * @param page
     * @param rows
     * @return
     */
    public Page<PanelDiscussion> findPanelDiscussionsByPanelDiscussion(PanelDiscussion panelDiscussion, int page, int rows) {
        RowBounds rowBounds=new RowBounds((page - 1) * rows,page*rows);
        Example example = new Example(PanelDiscussion.class);
        if(panelDiscussion.getTitle()!=null&&panelDiscussion.getTitle()!="") {
            example.createCriteria().andLike("title", "%" + panelDiscussion.getTitle() + "%");
        }
        if(panelDiscussion.getIsShadow()!=null) {
            example.createCriteria().andEqualTo("isShadow", panelDiscussion.getIsShadow());
        }
        example.createCriteria().andNotEqualTo("isShadow",2);
        example.setOrderByClause("create_time DESC");
        List<PanelDiscussion> list =mapper.selectByExampleAndRowBounds(example,rowBounds);
        long count = mapper.selectCountByExample(example);
        return new Page<PanelDiscussion>(count, list);
    }

    /**
     * 查询所有互动咨询
     * @param panelDiscussion
     * @param page
     * @param rows
     * @return
     */
    public Page<PanelDiscussion> findAdvisorys(PanelDiscussion panelDiscussion, int page, int rows) {
        RowBounds rowBounds=new RowBounds((page - 1) * rows,page*rows);
        Example example = new Example(PanelDiscussion.class);
        if(panelDiscussion.getTitle()!=null&&panelDiscussion.getTitle()!="") {
            example.createCriteria().andLike("title", "%" + panelDiscussion.getTitle() + "%");
        }
        example.createCriteria().andEqualTo("isShadow",2);
        example.setOrderByClause("create_time DESC");
        List<PanelDiscussion> list =mapper.selectByExampleAndRowBounds(example,rowBounds);
        long count = mapper.selectCountByExample(example);
        return new Page<PanelDiscussion>(count, list);
    }

    public PanelDiscussion findPanelDiscussionById(int id) {
        PanelDiscussion panelDiscussion=new PanelDiscussion();
        panelDiscussion.setId(id);
        return  mapper.selectOne(panelDiscussion);
    }


    /**
     * 根据名称查询讨论
     * @param name
     * @return
     */
    public long findPanelDiscussionsByName(String name)
    {
        PanelDiscussion panelDiscussion=new PanelDiscussion();
        panelDiscussion.setTitle(name);
        return mapper.selectCount(panelDiscussion);
    }

    /**
     * 添加讨论
     * @param panelDiscussion
     */
    public void insertPanelDiscussion(PanelDiscussion panelDiscussion)
    {
        mapper.insert(panelDiscussion);
    }

    /**
     * 更新讨论
     * @param panelDiscussion
     */
    public void updatePanelDiscussion(PanelDiscussion panelDiscussion)
    {
        mapper.updateByPrimaryKeySelective(panelDiscussion);
    }

    /**
     * 删除讨论
     * @param id
     */
    public void deletePanelDiscussion(int id)
    {
        PanelDiscussion panelDiscussion=new PanelDiscussion();
        panelDiscussion.setId(id);
        mapper.delete(panelDiscussion);
    }

}
