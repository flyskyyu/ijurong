package com.party.ijurong.service;

import com.party.ijurong.bean.Page;
import com.party.ijurong.pojo.NewsSpecial;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Created by yu on 2017/5/19.
 */
@Service
public class NewsSpecialService extends BaseService<NewsSpecial>{

    /**
     * 查询所有专题
     * @param newsSpecial
     * @param page
     * @param rows
     * @return
     */
    public Page<NewsSpecial> findNewsSpecialsByNewsSpecial(NewsSpecial newsSpecial, int page, int rows) {
        RowBounds rowBounds=new RowBounds((page - 1) * rows,page*rows);
        Example example = new Example(NewsSpecial.class);
        if(newsSpecial.getName()!=null&&newsSpecial.getName()!="") {
            example.createCriteria().andLike("name", "%" + newsSpecial.getName() + "%");
        }
        example.setOrderByClause("create_time DESC");
        List<NewsSpecial> list =mapper.selectByExampleAndRowBounds(example,rowBounds);
        long count = mapper.selectCountByExample(example);
        return new Page<NewsSpecial>(count, list);
    }

    public NewsSpecial findNewsSpecialById(int id) {
        NewsSpecial newsSpecial=new NewsSpecial();
        newsSpecial.setId(id);
        return  mapper.selectOne(newsSpecial);
    }


    /**
     * 根据名称查询专题
     * @param name
     * @return
     */
    public long findNewsSpecialsByName(String name)
    {
        NewsSpecial newsSpecial=new NewsSpecial();
        newsSpecial.setName(name);
        return mapper.selectCount(newsSpecial);
    }

    /**
     * 添加专题
     * @param newsSpecial
     */
    public void insertNewsSpecial(NewsSpecial newsSpecial)
    {
        mapper.insert(newsSpecial);
    }

    /**
     * 更新专题
     * @param newsSpecial
     */
    public void updateNewsSpecial(NewsSpecial newsSpecial)
    {
        mapper.updateByPrimaryKeySelective(newsSpecial);
    }

    /**
     * 删除专题
     * @param id
     */
    public void deleteNewsSpecial(int id)
    {
        NewsSpecial newsSpecial=new NewsSpecial();
        newsSpecial.setId(id);
        mapper.delete(newsSpecial);
    }




}
