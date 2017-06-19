package com.party.ijurong.controller.mobile;

import com.party.ijurong.bean.MobileResult;
import com.party.ijurong.bean.SimpleUser;
import com.party.ijurong.pojo.Staff;
import com.party.ijurong.pojo.UserSign;
import com.party.ijurong.service.MobileShiroService;
import com.party.ijurong.service.StaffService;
import com.party.ijurong.service.SysManageService;
import com.party.ijurong.service.UserSignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    private UserSignService userSignService;

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
