package com.party.ijurong.controller.mobile;

import com.github.pagehelper.PageInfo;
import com.party.ijurong.bean.CombotreeResult;
import com.party.ijurong.bean.MobileResult;
import com.party.ijurong.bean.SimpleUser;
import com.party.ijurong.dto.ActivityDto;
import com.party.ijurong.pojo.Activity;
import com.party.ijurong.pojo.ActivityMember;
import com.party.ijurong.service.ActivityMemberService;
import com.party.ijurong.service.ActivityService;
import com.party.ijurong.service.MobileShiroService;
import com.party.ijurong.service.PartyBranchInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

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
    @Autowired
    private PartyBranchInfoService branchInfoService;
    private long newCount = 12 * 60 * 60 * 1000;
    private int clickCount = 500;

    @RequestMapping("activityList")
    @ResponseBody
    public MobileResult activityList(ActivityDto activity, @RequestParam(defaultValue = "1") int page
            , @RequestParam(defaultValue = "20") int rows) {
        activity.setType(1);
        SimpleUser user = shiroService.getUser();
        List<CombotreeResult> results = branchInfoService.findTreeMenuListById(user.getPartyBranchId());
        List<Integer> ids = branchInfoService.getBranchIds(results);
        activity.setBranchInfoIds(ids);
        activity.setStaffId(user.getUserId());
        activity.setEndTime(new Date());
        activity.setFlag(0);
        PageInfo<ActivityDto> info = activityService.queryByDto(activity, page, rows);
        MobileResult result = new MobileResult();
        result.setCode(200);
        result.setData(arrange(info.getList()));
        return result;
    }

    private List arrange(List<ActivityDto> list) {
        long now = new Date().getTime();
        for(ActivityDto activity : list) {
            if(now - activity.getPublishTime().getTime() < newCount) {
                activity.setIsNew(1);
            } else {
                activity.setIsNew(0);
            }
            if(activity.getClickAmount() >= clickCount) {
                activity.setIsHot(1);
            } else {
                activity.setIsHot(0);
            }
        }
        return list;
    }

    @RequestMapping("volunteerList")
    @ResponseBody
    public MobileResult volunteerList(ActivityDto activity, @RequestParam(defaultValue = "1") int page
            , @RequestParam(defaultValue = "20") int rows) {
        activity.setType(2);
        SimpleUser user = shiroService.getUser();
        List<CombotreeResult> results = branchInfoService.findTreeMenuListById(user.getPartyBranchId());
        List<Integer> ids = branchInfoService.getBranchIds(results);
        activity.setBranchInfoIds(ids);
        activity.setStaffId(user.getUserId());
        activity.setEndTime(new Date());
        activity.setFlag(0);
        PageInfo info = activityService.queryByDto(activity, page, rows);
        MobileResult result = new MobileResult();
        result.setCode(200);
        result.setData(arrange(info.getList()));
        return result;
    }

    @RequestMapping("specialList")
    @ResponseBody
    public MobileResult specialList(ActivityDto activity, @RequestParam(defaultValue = "1") int page
            , @RequestParam(defaultValue = "20") int rows) {
        activity.setType(3);
        SimpleUser user = shiroService.getUser();
        List<CombotreeResult> results = branchInfoService.findTreeMenuListById(user.getPartyBranchId());
        List<Integer> ids = branchInfoService.getBranchIds(results);
        activity.setBranchInfoIds(ids);
        activity.setStaffId(user.getUserId());
        activity.setEndTime(new Date());
        activity.setFlag(0);
        PageInfo info = activityService.queryByDto(activity, page, rows);
        MobileResult result = new MobileResult();
        result.setCode(200);
        result.setData(arrange(info.getList()));
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

    @RequestMapping("click")
    @ResponseBody
    public MobileResult click(Integer id) {
        MobileResult result = new MobileResult();
        activityService.increaseClickAmount(id);
        result.setCode(200);
        return result;
    }
}
