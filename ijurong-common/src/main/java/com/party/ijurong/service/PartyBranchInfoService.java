package com.party.ijurong.service;

import com.party.ijurong.bean.CombotreeResult;
import com.party.ijurong.bean.Page;
import com.party.ijurong.pojo.EnterpriseInfo;
import com.party.ijurong.pojo.PartyBranchInfo;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yu on 2017/5/19.
 */
@Service
public class PartyBranchInfoService extends BaseService<PartyBranchInfo> {

    /**
     * 查询所有支部
     *
     * @param partyBranchInfo
     * @param page
     * @param rows
     * @return
     */
    public Page<PartyBranchInfo> findPartyBranchInfosByPartyBranchInfo(PartyBranchInfo partyBranchInfo, int page, int rows) {
        RowBounds rowBounds = new RowBounds((page - 1) * rows, page * rows);
        Example example = new Example(PartyBranchInfo.class);
        if (partyBranchInfo.getOrganizationName() != null && partyBranchInfo.getOrganizationName() != "") {
            example.createCriteria().andLike("organizationName", "%" + partyBranchInfo.getOrganizationName() + "%");
        }
        List<PartyBranchInfo> list = mapper.selectByExampleAndRowBounds(example, rowBounds);
        long count = mapper.selectCountByExample(example);
        return new Page<PartyBranchInfo>(count, list);
    }

    /**
     * 根据名称查询支部
     *
     * @param name
     * @return
     */
    public long findPartyBranchInfosByName(String name) {
        PartyBranchInfo partyBranchInfo = new PartyBranchInfo();
        partyBranchInfo.setOrganizationName(name);
        return mapper.selectCount(partyBranchInfo);
    }

    public PartyBranchInfo findPartyBranchInfoById(int id) {
        PartyBranchInfo partyBranchInfo = new PartyBranchInfo();
        partyBranchInfo.setId(id);
        return mapper.selectOne(partyBranchInfo);
    }

    /**
     * 添加支部
     *
     * @param partyBranchInfo
     */
    public void insertPartyBranchInfo(PartyBranchInfo partyBranchInfo) {
        mapper.insert(partyBranchInfo);
    }

    /**
     * 更新支部
     *
     * @param partyBranchInfo
     */
    public void updatePartyBranchInfo(PartyBranchInfo partyBranchInfo) {
        mapper.updateByPrimaryKeySelective(partyBranchInfo);
    }

    /**
     * 删除支部
     *
     * @param id
     */
    public void deletePartyBranchInfo(int id) {
        PartyBranchInfo partyBranchInfo = new PartyBranchInfo();
        partyBranchInfo.setId(id);
        mapper.delete(partyBranchInfo);
    }

    /**
     * @param id
     * @return
     */
    public List<PartyBranchInfo> findSelfAndChildren(Integer id) {
        List<PartyBranchInfo> results = new ArrayList<>();
        PartyBranchInfo branchInfo = mapper.selectByPrimaryKey(id);
        results.add(branchInfo);
        //findAllChildren(id, results);
        return results;
    }

    private List<PartyBranchInfo> findAllChildren(Integer id, List<PartyBranchInfo> results) {
        PartyBranchInfo partyBranchInfo = new PartyBranchInfo();
        //partyBranchInfo.setParentId(id);
        List<PartyBranchInfo> infos = mapper.select(partyBranchInfo);
        if (infos != null && infos.size() > 0) {
            results.addAll(infos);
            for (PartyBranchInfo info : infos) {
                findAllChildren(info.getId(), results);
            }
        }
        return results;
    }

    public List<CombotreeResult> findAllTreeMenuList() {
        List<PartyBranchInfo> list = mapper.selectAll();
        List<CombotreeResult> results = new ArrayList<CombotreeResult>();
        if (list.size() > 0) {
            for (PartyBranchInfo partyBranchInfo : list) {
                CombotreeResult combotreeResult = new CombotreeResult();
                combotreeResult.setId(partyBranchInfo.getId());
                combotreeResult.setText(partyBranchInfo.getOrganizationName());
                combotreeResult.setFatherId(partyBranchInfo.getFatherId());
                results.add(combotreeResult);
            }
            return treeMenuList(results, 0);
        } else {
            return null;
        }
    }

    public List<CombotreeResult> findTreeMenuListById(int id) {
        List<PartyBranchInfo> list = mapper.selectAll();
        List<CombotreeResult> results = new ArrayList<CombotreeResult>();
        if (list.size() > 0) {
            for (PartyBranchInfo partyBranchInfo : list) {
                if(id==partyBranchInfo.getId()) {
                    CombotreeResult combotreeResult = new CombotreeResult();
                    combotreeResult.setId(partyBranchInfo.getId());
                    combotreeResult.setText(partyBranchInfo.getOrganizationName());
                    combotreeResult.setFatherId(partyBranchInfo.getFatherId());
                    results.add(combotreeResult);
                }
            }
            return treeMenuList(results, 0);
        } else {
            return null;
        }
    }

    public List<CombotreeResult> treeMenuList(List<CombotreeResult> menuList, int parentId) {
        List<CombotreeResult> childMenu = new ArrayList<CombotreeResult>();
        for (CombotreeResult combotreeResult : menuList) {
            int id = combotreeResult.getId();
            int p_id = combotreeResult.getFatherId();
            if (parentId == p_id) {
                List<CombotreeResult> c_node = treeMenuList(menuList, id);
                combotreeResult.setChildren(c_node);
                childMenu.add(combotreeResult);
            }
        }
        return childMenu;
    }


}
