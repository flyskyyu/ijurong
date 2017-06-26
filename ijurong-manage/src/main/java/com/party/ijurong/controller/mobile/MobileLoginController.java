package com.party.ijurong.controller.mobile;

import com.party.ijurong.bean.MobileResult;
import com.party.ijurong.bean.SimpleUser;
import com.party.ijurong.pojo.PartyMember;
import com.party.ijurong.pojo.PartyPosition;
import com.party.ijurong.pojo.Staff;
import com.party.ijurong.service.*;
import com.party.ijurong.utils.RandomUtils;
import com.party.ijurong.websocket.MyWSHandler;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Cloud on 2017/5/27.
 */
@Controller
@RequestMapping("mobile")
public class MobileLoginController {
    @Autowired
    private StaffService staffService;
    @Autowired
    private PartyMemberService partyMemberService;
    @Autowired
    private StaffTokenService tokenService;
    @Autowired
    private RedisService redisService;
    @Autowired
    private SmsService smsService;
    @Autowired
    private PartyPositionService partyPositionService;
    @Autowired
    private MyWSHandler myWSHandler;
    @Autowired
    private MobileShiroService shiroService;
    private String prefixValid = "ValidCode:";

    @RequestMapping("login")
    @ResponseBody
    public MobileResult login(String username, String password, String deviceNumber, HttpServletRequest request) {
        MobileResult result = new MobileResult();
        if(StringUtils.isEmpty(username) || StringUtils.isEmpty(password) || StringUtils.isEmpty(deviceNumber)) {
            result.setMsg("参数不完整");
            result.setCode(300);
            return result;
        }
        Staff dbStaff = staffService.queryByEmailOrPhoneNumber(username);
        if(StringUtils.isEmpty(deviceNumber)) {
            result.setMsg("没有设备号");
            result.setCode(400);
            return result;
        }
        String md5Password = DigestUtils.md5Hex(password);
        if(dbStaff == null
                || !dbStaff.getPassword().equals(md5Password)) {
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

    @RequestMapping("register")
    @ResponseBody
    public MobileResult register(Staff staff, String partyPosition, String validCode) {
        MobileResult result = new MobileResult();
        if(StringUtils.isEmpty(staff.getPhoneNumber()) || StringUtils.isEmpty(staff.getPassword())
            || staff.getPartyBranchId() == null || StringUtils.isEmpty(validCode)) {
            result.setCode(300);
            result.setMsg("参数不完整");
            return result;
        }
        String key = prefixValid + staff.getPhoneNumber();
        if(!validCode.equals(redisService.get(key))) {
            result.setCode(300);
            result.setMsg("验证码不正确");
            return result;
        }
        Staff temp = staffService.queryByEmailOrPhoneNumber(staff.getPhoneNumber());
        if(temp != null) {
            result.setCode(300);
            result.setMsg("此手机已注册，请直接登录");
            return result;
        }
        staff.setPoliticalStatus(4);
        PartyMember partyMember = new PartyMember();
        partyMember.setPartyPosition(partyPosition);
        partyMemberService.saveMember(staff, partyMember);
        result.setCode(200);
        return result;
    }

    @RequestMapping("validCode")
    @ResponseBody
    public MobileResult validCode(String phoneNumber) {
        MobileResult result = new MobileResult();
        String validCode = RandomUtils.generateValidCode();
        try {
            smsService.sendValidCode(phoneNumber, validCode);
        } catch (Exception e) {
            e.printStackTrace();
            result.setCode(300);
            result.setMsg("短信发送失败");
            return result;
        }
        String key = prefixValid + phoneNumber;
        redisService.set(key, validCode);
        redisService.expire(key, 10 * 60);
        result.setCode(200);
        return result;
    }

    @RequestMapping("changePassword")
    @ResponseBody
    public MobileResult changePassword(String phoneNumber, String password, String validCode) {
        MobileResult result = new MobileResult();
        if(StringUtils.isEmpty(phoneNumber) || StringUtils.isEmpty(password)
                || StringUtils.isEmpty(validCode)) {
            result.setCode(300);
            result.setMsg("参数不完整");
            return result;
        }
        String key = prefixValid + phoneNumber;
        if(!validCode.equals(redisService.get(key))) {
            result.setCode(300);
            result.setMsg("验证码不正确");
            return result;
        }
        Staff staff = staffService.queryByEmailOrPhoneNumber(phoneNumber);
        if(staff == null) {
            result.setCode(300);
            result.setMsg("用户不存在");
            return result;
        }
        String md5Password = DigestUtils.md5Hex(password);
        staff.setPassword(md5Password);
        staffService.updateSelective(staff);
        result.setCode(200);
        return result;
    }

    @RequestMapping("listPartyPosition")
    @ResponseBody
    public MobileResult listPartyPosition() {
        MobileResult result = new MobileResult();
        List<PartyPosition> list = partyPositionService.queryAll();
        result.setCode(200);
        result.setData(list);
        return result;
    }

    @RequestMapping("qrcodeLogin")
    @ResponseBody
    public MobileResult qrcodeLogin(String token) {
        MobileResult result = new MobileResult();
        SimpleUser simpleUser = shiroService.getUser();
        Staff staff = staffService.queryById(simpleUser.getUserId());
        myWSHandler.sendLoginMessage(token, staff);
        result.setCode(200);
        return result;
    }
}
