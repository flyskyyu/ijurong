package com.party.ijurong.controller.admin;

import com.github.pagehelper.PageInfo;
import com.party.ijurong.bean.Page;
import com.party.ijurong.bean.SimpleUser;
import com.party.ijurong.pojo.Activity;
import com.party.ijurong.pojo.ActivityMember;
import com.party.ijurong.pojo.Car;
import com.party.ijurong.service.ActivityMemberService;
import com.party.ijurong.service.ActivityService;
import com.party.ijurong.service.ShiroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

/**
 * Created by Cloud on 2017/6/7.
 */
@Controller
@RequestMapping("admin/activity")
public class ActivityController {
    @Autowired
    private ShiroService shiroService;
    @Autowired
    private ActivityService activityService;
    @Autowired
    private ActivityMemberService memberService;

    @RequestMapping(value = "list")
    @ResponseBody
    public Page<Activity> list(Activity activity, @RequestParam(defaultValue = "1")int page
            , @RequestParam(defaultValue = "20")int rows) {
        if(activity.getPartyBranchId() == null) {
            SimpleUser user = shiroService.getUser();
            activity.setPartyBranchId(user.getPartyBranchId());
        }
        PageInfo<Activity> pageInfo = activityService.queryByActivity(activity, page, rows);
        return  new Page(pageInfo);
    }

    @RequestMapping(value = "update")
    @ResponseBody
    public String update(Activity obj, String addStaffs, String deleteStaffs) {
        activityService.update(obj, addStaffs, deleteStaffs);
        return "success";
    }

    @RequestMapping(value = "add")
    @ResponseBody
    public String add(Activity obj, String addStaffs) {
        SimpleUser user = shiroService.getUser();
        obj.setId(null);
        obj.setPartyBranchId(user.getPartyBranchId());
        obj.setPartyBranchName(user.getPartyBranchName());
        obj.setPublishTime(new Date());
        activityService.add(obj, addStaffs);
        return "success";
    }

    @RequestMapping(value = "delete")
    @ResponseBody
    public String delete(Integer id) {
        activityService.delete(id);
        return "success";
    }

    @RequestMapping(value = "listMember")
    @ResponseBody
    public List<ActivityMember> listMember(Integer id) {
        ActivityMember member = new ActivityMember();
        member.setActivityId(id);
        List<ActivityMember> members = memberService.queryListByWhere(member);
        return members;
    }

    @RequestMapping(value = "finish")
    @ResponseBody
    public String finish(Integer id) {
        activityService.finish(id);
        return "success";
    }
}
