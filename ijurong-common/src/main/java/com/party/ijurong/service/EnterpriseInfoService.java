package com.party.ijurong.service;

import com.party.ijurong.bean.Page;
import com.party.ijurong.pojo.EnterpriseInfo;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Created by yu on 2017/5/19.
 */
@Service
public class EnterpriseInfoService  extends BaseService<EnterpriseInfo>{

    /**
     * 查询所有企业
     * @param enterpriseInfo
     * @param page
     * @param rows
     * @return
     */
    public Page<EnterpriseInfo> findEnterpriseInfosByEnterpriseInfo(EnterpriseInfo enterpriseInfo, int page, int rows) {
        RowBounds rowBounds=new RowBounds((page - 1) * rows,page*rows);
        Example example = new Example(EnterpriseInfo.class);
        //id > 100 && id <= 150
        //example.createCriteria().andGreaterThan("id", 100).andLessThanOrEqualTo("id", 150);
        //查询总数
        //int count = example.countByExample(example);
        //Assert.assertEquals(50, count);
        if(enterpriseInfo.getName()!=null&&enterpriseInfo.getName()!="") {
            example.createCriteria().andLike("name", "%" + enterpriseInfo.getName() + "%");
        }
        List<EnterpriseInfo> list =mapper.selectByExampleAndRowBounds(example,rowBounds); // mapper.selectByRowBounds(enterpriseInfo, rowBounds);//like 需要重写
        long count = mapper.selectCountByExample(example);//mapper.selectByRowBounds(enterpriseInfo,new RowBounds()).size();
        return new Page<EnterpriseInfo>(count, list);
    }

    /**
     * 根据名称查询企业
     * @param name
     * @return
     */
    public long findEnterpriseInfosByName(String name)
    {
        EnterpriseInfo enterpriseInfo=new EnterpriseInfo();
        enterpriseInfo.setName(name);
        return mapper.selectCount(enterpriseInfo);
    }

    /**
     * 添加企业
     * @param enterpriseInfo
     */
    public void insertEnterpriseInfo(EnterpriseInfo enterpriseInfo)
    {
        mapper.insert(enterpriseInfo);
    }

    /**
     * 更新企业
     * @param enterpriseInfo
     */
    public void updateEnterpriseInfo(EnterpriseInfo enterpriseInfo)
    {
        mapper.updateByPrimaryKeySelective(enterpriseInfo);
    }

    /**
     * 删除企业
     * @param id
     */
    public void deleteEnterpriseInfo(int id)
    {
        EnterpriseInfo enterpriseInfo=new EnterpriseInfo();
        enterpriseInfo.setId(id);
        mapper.delete(enterpriseInfo);
    }

}
