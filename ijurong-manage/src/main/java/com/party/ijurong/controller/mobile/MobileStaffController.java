package com.party.ijurong.controller.mobile;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.party.ijurong.bean.MobileResult;
import com.party.ijurong.bean.SimpleUser;
import com.party.ijurong.pojo.PartyMember;
import com.party.ijurong.pojo.Staff;
import com.party.ijurong.pojo.UserSign;
import com.party.ijurong.service.*;
import com.party.ijurong.utils.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

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
    @Autowired
    private SysManageService sysManageService;
    @Autowired
    private FileUploadService fileUploadService;

    @Autowired
    private UserSignService userSignService;
    @Autowired
    private PartyMemberService memberService;

    @RequestMapping("get")
    @ResponseBody
    public MobileResult get() {
        MobileResult  result = new MobileResult();
        result.setCode(200);
        try {
            SimpleUser user = shiroService.getUser();
            Staff staff = staffService.queryById(user.getUserId());
            staff.setPassword(null);
            PartyMember member = memberService.queryById(staff.getStaffId());
            JSONObject jsonObject= (JSONObject)JSON.toJSON(staff);
            jsonObject.put("isHardMember", member.getIsHardMember());
            jsonObject.put("isOldMember", member.getIsOldMember());
            result.setData(jsonObject);
        } catch (Exception e) {
            e.printStackTrace();
            result.setCode(500);
            result.setMsg("服务器异常");
        }
        return result;
    }

    @RequestMapping("getIntegral")
    @ResponseBody
    public MobileResult getIntegral() {
        MobileResult  result = new MobileResult();
        result.setCode(200);
        try {
            SimpleUser user = shiroService.getUser();
            Staff staff = staffService.queryById(user.getUserId());
            result.setData(staff.getIntegral());
        } catch (Exception e) {
            e.printStackTrace();
            result.setCode(500);
            result.setMsg("服务器异常");
        }
        return result;
    }

    @RequestMapping("uploadAvatar")
    @ResponseBody
    public MobileResult uploadAvatar(MultipartFile file) {
        MobileResult mobileResult = new MobileResult();
        mobileResult.setCode(200);
        SimpleUser user = shiroService.getUser();
        try {
            String url = fileUploadService.upload(file.getInputStream(), FileUtils.getRandomFilename(file.getOriginalFilename()));
            Staff staff = new Staff();
            staff.setStaffId(user.getUserId());
            staff.setAvatar(url);
            staffService.updateSelective(staff);
            mobileResult.setData(url);
        } catch (Exception e) {
            e.printStackTrace();
            mobileResult.setCode(500);
            mobileResult.setMsg("服务器异常");
        }
        return mobileResult;
    }

    @RequestMapping("userSign")
    @ResponseBody
    public MobileResult userSign() {
        MobileResult result = new MobileResult();
        try {

            SimpleUser user = shiroService.getUser();
            if (userSignService.findUserSignByUserIdAndDate(user.getUserId()).size() > 0) {
                result.setCode(402);
                result.setMsg("今天您已经签到过了！");
            }
            else
            {
                int integral=1;//默认签到得一个积分
                try
                {
                   integral=Integer.parseInt(sysManageService.findSysManageBySysName("sign_integral").getSysValue());
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
                UserSign userSign=new UserSign();
                userSign.setUserId(user.getUserId());
                userSign.setIntegral(integral);
                userSign.setCreateTime(new Date());
                userSignService.insertUserSign(userSign);
                staffService.updateIntegralByUserId(user.getUserId(),integral);
                result.setCode(200);
                result.setMsg("签到成功！");
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            result.setCode(404);
            result.setMsg("系统异常！");
        }
        return result;
    }
}
