package com.party.ijurong.controller.mobile;

import com.github.pagehelper.PageInfo;
import com.party.ijurong.bean.MobileResult;
import com.party.ijurong.bean.Page;
import com.party.ijurong.bean.SimpleUser;
import com.party.ijurong.dto.ActivityDto;
import com.party.ijurong.pojo.*;
import com.party.ijurong.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Cloud on 2017/5/27.
 */
@Controller
@RequestMapping("mobile/appset")
public class MobileAppSetController {

    @Autowired
    private AppShufflingPicService appShufflingPicService;

    @Autowired
    private AppSkinVersionService appSkinVersionService;

    @Autowired
    private NewsService newsService;

    @Autowired
    private ActivityService activityService;

    @Autowired
    private MobileShiroService shiroService;

    @RequestMapping(value = "getShuffling")
    @ResponseBody
    public MobileResult getShuffling(HttpServletRequest httpServletRequest) {
        MobileResult result = new MobileResult();
        try
        {
            AppShufflingPic appShufflingPic=new AppShufflingPic();
            Page<AppShufflingPic> page = appShufflingPicService.findAppShufflingPicsByAppShufflingPic(appShufflingPic, 1, 3);


            result.setCode(200);
            result.setData(page.getRows());
        }catch (Exception e)
        {
            result.setCode(400);
            result.setMsg("系统异常");
        }
        return  result;
    }


    @RequestMapping(value = "getSkinVersion")
    @ResponseBody
    public MobileResult getSkinVersion(HttpServletRequest httpServletRequest) {
        MobileResult result = new MobileResult();
        try
        {
            Page<AppSkinVersion> page = appSkinVersionService.findAppSkinVersionsByMobile();
            result.setCode(200);
            result.setData(page.getRows());
        }catch (Exception e)
        {
            result.setCode(400);
            result.setMsg("系统异常");
        }
        return  result;
    }

    @RequestMapping(value = "getSearchInfo")
    @ResponseBody
    public MobileResult getSearch(HttpServletRequest httpServletRequest, @RequestParam(defaultValue = "1")int page
            , @RequestParam(defaultValue = "10")int rows,String title) {
        MobileResult result = new MobileResult();
        try
        {
            News news=new News();
            news.setTitle(title);
            Page<News> newsPage = newsService.findNewssByNews(news, page, rows,"create_time DESC");

            Activity activity=new Activity();
            activity.setTitle(title);
            activity.setType(1);
            SimpleUser user = shiroService.getUser();
            activity.setPartyBranchId(user.getPartyBranchId());
            activity.setEndTime(new Date());
            activity.setFlag(0);
            PageInfo<Activity> activityList = activityService.queryByActivity(activity, page, rows);

            activity.setType(2);
            activity.setPartyBranchId(null);
            activity.setEndTime(new Date());
            activity.setFlag(0);
            PageInfo<Activity> volunteerList = activityService.queryByActivity(activity, page, rows);

            activity.setType(3);
            activity.setPartyBranchId(user.getPartyBranchId());
            activity.setEndTime(new Date());
            activity.setFlag(0);
            PageInfo<Activity> specialList = activityService.queryByActivity(activity, page, rows);

            Map<String,Object> map=new HashMap<String,Object>();
            map.put("newsList",newsPage.getRows());
            map.put("activityList",activityList.getList());
            map.put("volunteerList",volunteerList.getList());
            map.put("specialList",specialList.getList());

            result.setCode(200);
            result.setData(map);
        }catch (Exception e)
        {
            result.setCode(400);
            result.setMsg("系统异常");
        }
        return  result;
    }

}
