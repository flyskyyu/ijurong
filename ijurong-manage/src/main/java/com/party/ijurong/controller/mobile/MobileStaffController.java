package com.party.ijurong.controller.mobile;

import com.party.ijurong.bean.MobileResult;
import com.party.ijurong.bean.SimpleUser;
import com.party.ijurong.pojo.Staff;
import com.party.ijurong.service.MobileShiroService;
import com.party.ijurong.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2017/5/28 0028.
 */
@Controller
@RequestMapping("mobile/staff")
public class MobileStaffController {
    @Autowired
    private StaffService staffService;
    @Autowired
    private MobileShiroService shiroService;

    @RequestMapping("get")
    @ResponseBody
    public MobileResult get() {
        SimpleUser user = shiroService.getUser();
        Staff staff = staffService.queryById(user.getUserId());
        MobileResult  result = new MobileResult();
        result.setCode(200);
        result.setData(staff);
        return result;
    }
}
