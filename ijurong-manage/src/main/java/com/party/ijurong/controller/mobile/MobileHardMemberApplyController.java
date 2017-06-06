package com.party.ijurong.controller.mobile;

import com.github.pagehelper.PageInfo;
import com.party.ijurong.bean.MobileResult;
import com.party.ijurong.bean.SimpleUser;
import com.party.ijurong.dto.HardMemberApplyDto;
import com.party.ijurong.pojo.HardMemberApply;
import com.party.ijurong.service.HardMemberApplyService;
import com.party.ijurong.service.MobileShiroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * Created by Cloud on 2017/6/6.
 */
@Controller
@RequestMapping("mobile/hardMemberApply")
public class MobileHardMemberApplyController {
    @Autowired
    private HardMemberApplyService applyService;
    @Autowired
    private MobileShiroService shiroService;

    @RequestMapping(value = "add")
    @ResponseBody
    public String add(HardMemberApply obj) {
        SimpleUser user = shiroService.getUser();
        obj.setId(null);
        obj.setStaffId(user.getUserId());
        obj.setApplyTime(new Date());
        obj.setIsAgree(null);
        applyService.save(obj);
        return "success";
    }

    @RequestMapping(value = "myApply")
    @ResponseBody
    public MobileResult myApply(@RequestParam(defaultValue = "1")int page
            , @RequestParam(defaultValue = "20")int rows) {
        SimpleUser user = shiroService.getUser();
        HardMemberApply apply = new HardMemberApply();
        apply.setStaffId(user.getUserId());
        PageInfo<HardMemberApply> info = applyService.queryApplyList(apply, page, rows);
        MobileResult result = new MobileResult();
        result.setCode(200);
        result.setData(info.getList());
        return result;
    }
}
