package com.party.ijurong.controller.mobile;

import com.party.ijurong.bean.MobileResult;
import com.party.ijurong.common.TokenUtils;
import com.party.ijurong.pojo.Staff;
import com.party.ijurong.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Cloud on 2017/5/27.
 */
@Controller("mobileLogin")
@RequestMapping("mobile")
public class LoginController {
    @Autowired
    private StaffService staffService;

    @RequestMapping("login")
    @ResponseBody
    public MobileResult login(@RequestBody Staff staff) {
        MobileResult result = new MobileResult();
        Staff dbStaff = staffService.queryByEmailOrPhoneNumber(staff.getStaffName());
        if(dbStaff == null
                || !dbStaff.getPassword().equals(staff.getPassword())) {
            result.setMsg("用户名或密码错误");
            result.setCode(300);
            return result;
        }
        result.setCode(200);
        String token = TokenUtils.generateToken(dbStaff);
        result.setData(token);
        return result;
    }

}
