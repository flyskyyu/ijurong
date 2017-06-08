package com.party.ijurong.controller.mobile;

import com.github.pagehelper.PageInfo;
import com.party.ijurong.bean.MobileResult;
import com.party.ijurong.bean.SimpleUser;
import com.party.ijurong.pojo.Activity;
import com.party.ijurong.pojo.ActivityMember;
import com.party.ijurong.service.ActivityMemberService;
import com.party.ijurong.service.ActivityService;
import com.party.ijurong.service.MobileShiroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Cloud on 2017/6/8.
 */
@Controller
@RequestMapping("mobile/activity")
public class MobileActivityController {
    @Autowired
    private MobileShiroService shiroService;
    @Autowired
    private ActivityService activityService;
    @Autowired
    private ActivityMemberService activityMemberService;

    @RequestMapping("activityList")
    @ResponseBody
    public MobileResult activityList(Activity activity, @RequestParam(defaultValue = "1") int page
            , @RequestParam(defaultValue = "20") int rows) {
        activity.setType(1);
        SimpleUser user = shiroService.getUser();
        activity.setPartyBranchId(user.getPartyBranchId());
        PageInfo info = activityService.queryByActivity(activity, page, rows);
        MobileResult result = new MobileResult();
        result.setCode(200);
        result.setData(info.getList());
        return result;
    }

    @RequestMapping("volunteerList")
    @ResponseBody
    public MobileResult volunteerList(Activity activity, @RequestParam(defaultValue = "1") int page
            , @RequestParam(defaultValue = "20") int rows) {
        activity.setType(2);
        activity.setPartyBranchId(null);
        PageInfo info = activityService.queryByActivity(activity, page, rows);
        MobileResult result = new MobileResult();
        result.setCode(200);
        result.setData(info.getList());
        return result;
    }

    @RequestMapping("specialList")
    @ResponseBody
    public MobileResult specialList(Activity activity, @RequestParam(defaultValue = "1") int page
            , @RequestParam(defaultValue = "20") int rows) {
        activity.setType(2);
        SimpleUser user = shiroService.getUser();
        activity.setPartyBranchId(user.getPartyBranchId());
        PageInfo info = activityService.queryByActivity(activity, page, rows);
        MobileResult result = new MobileResult();
        result.setCode(200);
        result.setData(info.getList());
        return result;
    }

    @RequestMapping("join")
    @ResponseBody
    public MobileResult join(Integer id) {
        MobileResult result = new MobileResult();
        SimpleUser user = shiroService.getUser();
        ActivityMember activityMember = new ActivityMember();
        activityMember.setActivityId(id);
        activityMember.setStaffId(user.getUserId());
        if (activityMemberService.queryListByWhere(activityMember).size() > 0) {
            result.setCode(300);
            result.setMsg("已经参与该活动");
            return result;
        }
        activityMember.setStaffName(user.getUserName());
        activityMemberService.save(activityMember);
        result.setCode(200);
        return result;
    }
}
