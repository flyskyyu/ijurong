package com.party.ijurong.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.party.ijurong.mapper.FacilityMapper;
import com.party.ijurong.pojo.Facility;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Created by Administrator on 2017/6/4 0004.
 */
@Service
public class FacilityService extends BaseService<Facility> {
    @Autowired
    private FacilityMapper facilityMapper;

    public PageInfo<Facility> queryByFacility(Facility facility, int page, int rows) {
        Example example = new Example(Facility.class);
        Example.Criteria criteria = example.createCriteria();
        String name = facility.getName();
        if(name != null && StringUtils.isNotEmpty(name.trim())) {
            criteria.andLike("name", "%" + name+ "%");
        }
        if(facility.getPartyBranchId() != null) {
            criteria.andEqualTo("partyBranchId", facility.getPartyBranchId());
        }
        if(facility.getType() != null) {
            criteria.andEqualTo("type", facility.getType());
        }
        example.orderBy("id").desc();
        PageHelper.startPage(page, rows);
        List<Facility> list = facilityMapper.selectByExample(example);
        return new PageInfo<>(list);
    }
}
