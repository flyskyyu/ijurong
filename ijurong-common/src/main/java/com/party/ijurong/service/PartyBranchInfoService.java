package com.party.ijurong.service;

import com.party.ijurong.bean.Page;
import com.party.ijurong.pojo.EnterpriseInfo;
import com.party.ijurong.pojo.PartyBranchInfo;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Created by yu on 2017/5/19.
 */
@Service
public class PartyBranchInfoService extends BaseService<PartyBranchInfo>{

    /**
     * 查询所有支部
     * @param partyBranchInfo
     * @param page
     * @param rows
     * @return
     */
    public Page<PartyBranchInfo> findPartyBranchInfosByPartyBranchInfo(PartyBranchInfo partyBranchInfo, int page, int rows) {
        RowBounds rowBounds=new RowBounds((page - 1) * rows,page*rows);
        Example example = new Example(PartyBranchInfo.class);
        if(partyBranchInfo.getOrganizationName()!=null&&partyBranchInfo.getOrganizationName()!="") {
            example.createCriteria().andLike("organizationName", "%" + partyBranchInfo.getOrganizationName() + "%");
        }
        List<PartyBranchInfo> list =mapper.selectByExampleAndRowBounds(example,rowBounds);
        long count = mapper.selectCountByExample(example);
        return new Page<PartyBranchInfo>(count, list);
    }

    /**
     * 根据名称查询支部
     * @param name
     * @return
     */
    public long findPartyBranchInfosByName(String name)
    {
        PartyBranchInfo partyBranchInfo=new PartyBranchInfo();
        partyBranchInfo.setOrganizationName(name);
        return mapper.selectCount(partyBranchInfo);
    }

    /**
     * 添加支部
     * @param partyBranchInfo
     */
    public void insertPartyBranchInfo(PartyBranchInfo partyBranchInfo)
    {
        mapper.insert(partyBranchInfo);
    }

    /**
     * 更新支部
     * @param partyBranchInfo
     */
    public void updatePartyBranchInfo(PartyBranchInfo partyBranchInfo)
    {
        mapper.updateByPrimaryKeySelective(partyBranchInfo);
    }

    /**
     * 删除支部
     * @param id
     */
    public void deletePartyBranchInfo(int id)
    {
        PartyBranchInfo partyBranchInfo=new PartyBranchInfo();
        partyBranchInfo.setId(id);
        mapper.delete(partyBranchInfo);
    }


}
