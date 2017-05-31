package com.party.ijurong.service;

import com.party.ijurong.bean.Page;
import com.party.ijurong.pojo.AppSkins;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Created by yu on 2017/5/19.
 */
@Service
public class AppSkinsService extends BaseService<AppSkins>{

    /**
     * 查询所有按钮图
     * @param appSkins
     * @param page
     * @param rows
     * @return
     */
    public Page<AppSkins> findAppSkinssByAppSkins(AppSkins appSkins, int page, int rows) {
        RowBounds rowBounds=new RowBounds((page - 1) * rows,page*rows);
        Example example = new Example(AppSkins.class);
        if(appSkins.getName()!=null&&appSkins.getName()!="") {
            example.createCriteria().andLike("name", "%" + appSkins.getName() + "%");
        }
        example.setOrderByClause("create_time DESC");
        List<AppSkins> list =mapper.selectByExampleAndRowBounds(example,rowBounds);
        long count = mapper.selectCountByExample(example);
        return new Page<AppSkins>(count, list);
    }

    public AppSkins findAppSkinsById(int id) {
        AppSkins appSkins=new AppSkins();
        appSkins.setId(id);
        return  mapper.selectOne(appSkins);
    }


    /**
     * 根据名称查询按钮图
     * @param name
     * @return
     */
    public long findAppSkinssByName(String name)
    {
        AppSkins appSkins=new AppSkins();
        appSkins.setName(name);
        return mapper.selectCount(appSkins);
    }

    /**
     * 添加按钮图
     * @param appSkins
     */
    public void insertAppSkins(AppSkins appSkins)
    {
        mapper.insert(appSkins);
    }

    /**
     * 更新按钮图
     * @param appSkins
     */
    public void updateAppSkins(AppSkins appSkins)
    {
        mapper.updateByPrimaryKeySelective(appSkins);
    }

    /**
     * 删除按钮图
     * @param id
     */
    public void deleteAppSkins(int id)
    {
        AppSkins appSkins=new AppSkins();
        appSkins.setId(id);
        mapper.delete(appSkins);
    }

}
