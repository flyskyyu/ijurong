package com.party.ijurong.service;

import com.party.ijurong.bean.Page;
import com.party.ijurong.pojo.EnterpriseInfo;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

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
    public Page<EnterpriseInfo> findCompanysByCompany(EnterpriseInfo enterpriseInfo, int page, int rows) {
        RowBounds rowBounds=new RowBounds((page - 1) * rows,page*rows);
        List<EnterpriseInfo> list = mapper.selectByRowBounds(enterpriseInfo, rowBounds);
        long count = mapper.selectByRowBounds(enterpriseInfo,new RowBounds()).size();
        return new Page<EnterpriseInfo>(count, list);
    }

    /**
     * 根据名称查询企业
     * @param name
     * @return
     */
    public long findCompanysByName(String name)
    {
        EnterpriseInfo enterpriseInfo=new EnterpriseInfo();
        enterpriseInfo.setName(name);
        return mapper.selectCount(enterpriseInfo);
    }

    /**
     * 添加企业
     * @param enterpriseInfo
     */
    public void insertCompany(EnterpriseInfo enterpriseInfo)
    {
        mapper.insert(enterpriseInfo);
    }

    /**
     * 更新企业
     * @param enterpriseInfo
     */
    public void updateCompany(EnterpriseInfo enterpriseInfo)
    {
        mapper.updateByPrimaryKeySelective(enterpriseInfo);
    }

    /**
     * 删除企业
     * @param id
     */
    public void deleteCompany(int id)
    {
        EnterpriseInfo enterpriseInfo=new EnterpriseInfo();
        enterpriseInfo.setId(id);
        mapper.delete(enterpriseInfo);
    }

}
