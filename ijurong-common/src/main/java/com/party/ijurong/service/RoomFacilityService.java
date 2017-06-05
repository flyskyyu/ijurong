package com.party.ijurong.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.party.ijurong.mapper.RoomFacilityMapper;
import com.party.ijurong.pojo.Item;
import com.party.ijurong.pojo.RoomFacility;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Created by Administrator on 2017/6/4 0004.
 */
@Service
public class RoomFacilityService extends BaseService<RoomFacility> {
    @Autowired
    private RoomFacilityMapper facilityMapper;

    public PageInfo<RoomFacility> queryByFacility(RoomFacility facility, int page, int rows) {
        Example example = new Example(RoomFacility.class);
        Example.Criteria criteria = example.createCriteria();
        String name = facility.getName();
        if(name != null && StringUtils.isNotEmpty(name.trim())) {
            criteria.andLike("name", "%" + name+ "%");
        }
        if(facility.getPartyBranchId() != null) {
            criteria.andEqualTo("partyBranchId", facility.getPartyBranchId());
        }
        example.orderBy("id").desc();
        PageHelper.startPage(page, rows);
        List<RoomFacility> list = facilityMapper.selectByExample(example);
        return new PageInfo<>(list);
    }
}
