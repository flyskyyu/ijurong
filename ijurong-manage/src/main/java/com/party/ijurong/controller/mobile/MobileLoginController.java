package com.party.ijurong.controller.mobile;

import com.party.ijurong.bean.MobileResult;
import com.party.ijurong.pojo.Staff;
import com.party.ijurong.service.StaffService;
import com.party.ijurong.service.StaffTokenService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Cloud on 2017/5/27.
 */
@Controller
@RequestMapping("mobile")
public class MobileLoginController {
    @Autowired
    private StaffService staffService;
    @Autowired
    private StaffTokenService tokenService;

    @RequestMapping("login")
    @ResponseBody
    public MobileResult login(String username, String password, String deviceNumber, HttpServletRequest request) {
        MobileResult result = new MobileResult();
        Staff dbStaff = staffService.queryByEmailOrPhoneNumber(username);
        if(StringUtils.isEmpty(deviceNumber)) {
            result.setMsg("没有设备号");
            result.setCode(400);
            return result;
        }
        if(dbStaff == null
                || !dbStaff.getPassword().equals(password)) {
            result.setMsg("用户名或密码错误");
            result.setCode(300);
            return result;
        }
        String token = tokenService.saveStaffToken(dbStaff, deviceNumber, request.getRemoteAddr());
        if(token == null) {
            result.setCode(301);
            result.setMsg("设备更换，需要验证手机号");
            return result;
        }

        result.setCode(200);
        result.setData(token);
        return result;
    }

}
