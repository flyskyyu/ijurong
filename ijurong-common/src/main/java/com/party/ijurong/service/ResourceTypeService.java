package com.party.ijurong.service;

import com.party.ijurong.bean.Page;
import com.party.ijurong.pojo.ResourceType;
import com.party.ijurong.pojo.Volunteer;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Created by yu on 2017/5/19.
 */
@Service
public class ResourceTypeService extends BaseService<ResourceType>{

    /**
     * 查询所有资源类型
     * @param resourceType
     * @param page
     * @param rows
     * @return
     */
    public Page<ResourceType> findResourceTypesByResourceType(ResourceType resourceType, int page, int rows) {
        RowBounds rowBounds=new RowBounds((page - 1) * rows,page*rows);
        Example example = new Example(ResourceType.class);
        if(resourceType.getType()!=null&&resourceType.getType()!="") {
            example.createCriteria().andLike("type", "%" + resourceType.getType() + "%");
        }
        List<ResourceType> list =mapper.selectByExampleAndRowBounds(example,rowBounds);
        long count = mapper.selectCountByExample(example);
        return new Page<ResourceType>(count, list);
    }

    public ResourceType findResourceTypeById(int id) {
        ResourceType resourceType=new ResourceType();
        resourceType.setId(id);
        return  mapper.selectOne(resourceType);
    }


    /**
     * 根据名称查询资源类型
     * @param name
     * @return
     */
    public long findResourceTypesByName(String name)
    {
        ResourceType resourceType=new ResourceType();
        resourceType.setType(name);
        return mapper.selectCount(resourceType);
    }

    /**
     * 添加资源类型
     * @param resourceType
     */
    public void insertResourceType(ResourceType resourceType)
    {
        mapper.insert(resourceType);
    }

    /**
     * 更新资源类型
     * @param resourceType
     */
    public void updateResourceType(ResourceType resourceType)
    {
        mapper.updateByPrimaryKeySelective(resourceType);
    }

    /**
     * 删除资源类型
     * @param id
     */
    public void deleteResourceType(int id)
    {
        ResourceType resourceType=new ResourceType();
        resourceType.setId(id);
        mapper.delete(resourceType);
    }

}
