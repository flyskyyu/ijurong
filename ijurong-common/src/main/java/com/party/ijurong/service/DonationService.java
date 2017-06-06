package com.party.ijurong.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.party.ijurong.mapper.DonationMapper;
import com.party.ijurong.pojo.Donation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Created by Administrator on 2017/6/6 0006.
 */
@Service
public class DonationService extends BaseService<Donation> {
    @Autowired
    private DonationMapper donationMapper;

    public PageInfo<Donation> queryByDonation(Donation donation, int page, int rows) {
        Example example = new Example(Donation.class);
        Example.Criteria criteria = example.createCriteria();
        if (donation.getStaffId() != null) {
            criteria.andEqualTo("staffId", donation.getStaffId());
        }
        if (donation.getPartyBranchId() != null) {
            criteria.andEqualTo("partyBranchId", donation.getPartyBranchId());
        }
        example.orderBy("id").desc();
        PageHelper.startPage(page, rows);
        List<Donation> donations = donationMapper.selectByExample(example);
        return new PageInfo<>(donations);
    }
}
