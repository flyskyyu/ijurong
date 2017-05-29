package com.party.ijurong.controller.mobile;

import com.google.gson.JsonObject;
import com.party.ijurong.bean.MobileResult;
import com.party.ijurong.bean.SimpleUser;
import com.party.ijurong.pojo.StaffToken;
import com.party.ijurong.service.MobileShiroService;
import com.party.ijurong.service.StaffTokenService;
import com.party.ijurong.utils.TokenUtils;
import com.party.ijurong.pojo.Staff;
import com.party.ijurong.service.StaffService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;

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
    @Autowired
    private MobileShiroService shiroService;

    @RequestMapping("login")
    @ResponseBody
    public MobileResult login(String username, String password, HttpServletRequest request) {
        MobileResult result = new MobileResult();
        Staff dbStaff = staffService.queryByEmailOrPhoneNumber(username);
        if(dbStaff == null
                || !dbStaff.getPassword().equals(password)) {
            result.setMsg("用户名或密码错误");
            result.setCode(300);
            return result;
        }
        result.setCode(200);
        String token = TokenUtils.generateToken(dbStaff);
        StaffToken staffToken = new StaffToken();
        staffToken.setToken(token);
        staffToken.setStaffId(dbStaff.getStaffId());
        staffToken.setLoginTime(new Date());
        staffToken.setIp(request.getRemoteAddr());
        tokenService.save(staffToken);
        SimpleUser simpleUser = new SimpleUser(dbStaff);
        simpleUser.setToken(token);
        shiroService.saveUserInSession(simpleUser);
        result.setData(token);
        return result;
    }

}
