package com.party.ijurong.service;

import com.party.ijurong.bean.Page;
import com.party.ijurong.pojo.AppShufflingPic;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Created by yu on 2017/5/19.
 */
@Service
public class AppShufflingPicService extends BaseService<AppShufflingPic>{

    /**
     * 查询所有轮播图
     * @param appShufflingPic
     * @param page
     * @param rows
     * @return
     */
    public Page<AppShufflingPic> findAppShufflingPicsByAppShufflingPic(AppShufflingPic appShufflingPic, int page, int rows) {
        RowBounds rowBounds=new RowBounds((page - 1) * rows,page*rows);
        Example example = new Example(AppShufflingPic.class);
        if(appShufflingPic.getName()!=null&&appShufflingPic.getName()!="") {
            example.createCriteria().andLike("name", "%" + appShufflingPic.getName() + "%");
        }
//        example.setOrderByClause("create_time DESC");
        List<AppShufflingPic> list =mapper.selectByExampleAndRowBounds(example,rowBounds);
        long count = mapper.selectCountByExample(example);
        return new Page<AppShufflingPic>(count, list);
    }

    public AppShufflingPic findAppShufflingPicById(int id) {
        AppShufflingPic appShufflingPic=new AppShufflingPic();
        appShufflingPic.setId(id);
        return  mapper.selectOne(appShufflingPic);
    }


    /**
     * 根据名称查询轮播图
     * @param name
     * @return
     */
    public long findAppShufflingPicsByName(String name)
    {
        AppShufflingPic appShufflingPic=new AppShufflingPic();
        appShufflingPic.setName(name);
        return mapper.selectCount(appShufflingPic);
    }

    /**
     * 添加轮播图
     * @param appShufflingPic
     */
    public void insertAppShufflingPic(AppShufflingPic appShufflingPic)
    {
        mapper.insert(appShufflingPic);
    }

    /**
     * 更新轮播图
     * @param appShufflingPic
     */
    public void updateAppShufflingPic(AppShufflingPic appShufflingPic)
    {
        mapper.updateByPrimaryKeySelective(appShufflingPic);
    }

    /**
     * 删除轮播图
     * @param id
     */
    public void deleteAppShufflingPic(int id)
    {
        AppShufflingPic appShufflingPic=new AppShufflingPic();
        appShufflingPic.setId(id);
        mapper.delete(appShufflingPic);
    }

}
