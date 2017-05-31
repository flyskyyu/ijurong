package com.party.ijurong.service;

import com.party.ijurong.bean.Page;
import com.party.ijurong.pojo.AppSkinVersion;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Created by yu on 2017/5/19.
 */
@Service
public class AppSkinVersionService extends BaseService<AppSkinVersion>{

    /**
     * 查询所有版本图
     * @param appSkinVersion
     * @param page
     * @param rows
     * @return
     */
    public Page<AppSkinVersion> findAppSkinVersionsByAppSkinVersion(AppSkinVersion appSkinVersion, int page, int rows) {
        RowBounds rowBounds=new RowBounds((page - 1) * rows,page*rows);
        Example example = new Example(AppSkinVersion.class);
        if(appSkinVersion.getVersion()!=null&&appSkinVersion.getVersion()!="") {
            example.createCriteria().andLike("name", "%" + appSkinVersion.getVersion() + "%");
        }
        example.setOrderByClause("create_time DESC");
        List<AppSkinVersion> list =mapper.selectByExampleAndRowBounds(example,rowBounds);
        long count = mapper.selectCountByExample(example);
        return new Page<AppSkinVersion>(count, list);
    }

    public AppSkinVersion findAppSkinVersionById(int id) {
        AppSkinVersion appSkinVersion=new AppSkinVersion();
        appSkinVersion.setId(id);
        return  mapper.selectOne(appSkinVersion);
    }


    /**
     * 根据名称查询版本图
     * @param name
     * @return
     */
    public long findAppSkinVersionsByName(String name)
    {
        AppSkinVersion appSkinVersion=new AppSkinVersion();
        appSkinVersion.setVersion(name);
        return mapper.selectCount(appSkinVersion);
    }

    /**
     * 添加版本图
     * @param appSkinVersion
     */
    public void insertAppSkinVersion(AppSkinVersion appSkinVersion)
    {
        mapper.insert(appSkinVersion);
    }

    /**
     * 更新版本图
     * @param appSkinVersion
     */
    public void updateAppSkinVersion(AppSkinVersion appSkinVersion)
    {
        mapper.updateByPrimaryKeySelective(appSkinVersion);
    }

    /**
     * 删除版本图
     * @param id
     */
    public void deleteAppSkinVersion(int id)
    {
        AppSkinVersion appSkinVersion=new AppSkinVersion();
        appSkinVersion.setId(id);
        mapper.delete(appSkinVersion);
    }






}
