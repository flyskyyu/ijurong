package com.party.ijurong.service;

import com.party.ijurong.bean.Page;
import com.party.ijurong.pojo.News;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Created by yu on 2017/5/19.
 */
@Service
public class NewsService extends BaseService<News>{

    /**
     * 查询所有新闻
     * @param news
     * @param page
     * @param rows
     * @return
     */
    public Page<News> findNewssByNews(News news, int page, int rows) {
        RowBounds rowBounds=new RowBounds((page - 1) * rows,page*rows);
        Example example = new Example(News.class);
        if(news.getTitle()!=null&&news.getTitle()!="") {
            example.createCriteria().andLike("title", "%" + news.getTitle() + "%");
        }
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

}
