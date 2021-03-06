package com.party.ijurong.service;

import com.party.ijurong.bean.Page;
import com.party.ijurong.mapper.NewsMapper;
import com.party.ijurong.pojo.News;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Created by yu on 2017/5/19.
 */
@Service
public class NewsService extends BaseService<News>{

    @Autowired
    private NewsMapper newsMapper;
    /**
     * 查询所有新闻
     * @param news
     * @param page
     * @param rows
     * @return
     */
    public Page<News> findNewssByNews(News news, int page, int rows,String order) {
        RowBounds rowBounds=new RowBounds((page - 1) * rows,page*rows);
        Example example = new Example(News.class);
        Example.Criteria criteria = example.createCriteria();
        if(news.getTitle()!=null&&news.getTitle()!="") {
            criteria.andLike("title", "%" + news.getTitle() + "%");
        }
        if(news.getProgramaId()!=null) {
            criteria.andEqualTo("programaId", news.getProgramaId());
        }
        if(news.getStatus() != null) {
            criteria.andEqualTo("status", news.getStatus());
        }
        example.setOrderByClause(order);
        List<News> list =mapper.selectByExampleAndRowBounds(example,rowBounds);
        long count = mapper.selectCountByExample(example);
        return new Page<News>(count, list);
    }

    public News findNewsById(int id) {
        Example example = new Example(News.class);
        example.createCriteria().andEqualTo("id", id);
        return  mapper.selectByExample(example).get(0);
    }

    /**
     * 添加新闻
     * @param news
     */
    public void insertNews(News news)
    {
        mapper.insert(news);
    }

    /**
     * 更新新闻
     * @param news
     */
    public void updateNews(News news)
    {
        mapper.updateByPrimaryKeySelective(news);
    }

    /**
     * 删除新闻
     * @param id
     */
    public void deleteNews(int id)
    {
        News news=new News();
        news.setId(id);
        mapper.delete(news);
    }

    /**
     * 新闻点击数+1
     * @param id
     */
    public void updateCheckNum(int id)
    {
        newsMapper.updateCheckNum(id);
    }
}
