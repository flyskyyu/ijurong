package com.party.ijurong.controller.mobile;

import com.github.pagehelper.PageInfo;
import com.party.ijurong.bean.MobileResult;
import com.party.ijurong.bean.SimpleUser;
import com.party.ijurong.pojo.Donation;
import com.party.ijurong.service.DonationService;
import com.party.ijurong.service.MobileShiroService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * Created by Administrator on 2017/6/6 0006.
 */
@Controller
@RequestMapping("mobile/donation")
public class MobileDonationController {
    @Autowired
    private DonationService donationService;
    @Autowired
    private MobileShiroService shiroService;

    @RequestMapping(value = "list")
    @ResponseBody
    public MobileResult list(@RequestParam(defaultValue = "1")int page
            , @RequestParam(defaultValue = "20")int rows) {
        SimpleUser user = shiroService.getUser();
        Donation donation = new Donation();
        donation.setStaffId(user.getUserId());
        PageInfo<Donation> pageInfo = donationService.queryByDonation(donation, page, rows);
        MobileResult result = new MobileResult();
        result.setCode(200);
        result.setData(pageInfo.getList());
        return  result;
    }

    @RequestMapping(value = "branchList")
    @ResponseBody
    public MobileResult branchList(@RequestParam(defaultValue = "1")int page
            , @RequestParam(defaultValue = "20")int rows) {
        SimpleUser user = shiroService.getUser();
        Donation donation = new Donation();
        donation.setStaffId(user.getPartyBranchId());
        PageInfo<Donation> pageInfo = donationService.queryByDonation(donation, page, rows);
        MobileResult result = new MobileResult();
        result.setCode(200);
        result.setData(pageInfo.getList());
        return  result;
    }

    @RequestMapping(value = "add")
    @ResponseBody
    public MobileResult add(Donation donation, @RequestParam(defaultValue = "1")int page
            , @RequestParam(defaultValue = "20")int rows) {
        SimpleUser user = shiroService.getUser();
        donation.setId(null);
        donation.setDonationTime(new Date());
        donation.setStaffId(user.getUserId());
        donation.setPartyBranchId(user.getPartyBranchId());
        donation.setStaffName(user.getUserName());
        if(StringUtils.isEmpty(donation.getPhone())) {
            donation.setPhone(user.getPhone());
        }
        donationService.save(donation);
        MobileResult result = new MobileResult();
        result.setCode(200);
        return  result;
    }

    @RequestMapping(value = "update")
    @ResponseBody
    public MobileResult update(Donation donation, @RequestParam(defaultValue = "1")int page
            , @RequestParam(defaultValue = "20")int rows) {
        SimpleUser user = shiroService.getUser();
        donation.setStaffId(user.getUserId());
        donation.setPartyBranchId(user.getPartyBranchId());
        donation.setStaffName(user.getUserName());
        if(StringUtils.isEmpty(donation.getPhone())) {
            donation.setPhone(user.getPhone());
        }
        donationService.updateSelective(donation);
        MobileResult result = new MobileResult();
        result.setCode(200);
        return  result;
    }
}
