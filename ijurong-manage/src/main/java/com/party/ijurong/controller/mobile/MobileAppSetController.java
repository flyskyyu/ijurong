package com.party.ijurong.controller.mobile;

import com.github.pagehelper.PageInfo;
import com.party.ijurong.bean.MobileResult;
import com.party.ijurong.bean.Page;
import com.party.ijurong.bean.SimpleUser;
import com.party.ijurong.pojo.AppShufflingPic;
import com.party.ijurong.pojo.AppSkinVersion;
import com.party.ijurong.pojo.Car;
import com.party.ijurong.service.AppShufflingPicService;
import com.party.ijurong.service.AppSkinVersionService;
import com.party.ijurong.service.CarService;
import com.party.ijurong.service.MobileShiroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

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

    @RequestMapping(value = "getShuffling")
    @ResponseBody
    public MobileResult getShuffling(HttpServletRequest httpServletRequest) {
        AppShufflingPic appShufflingPic=new AppShufflingPic();
        Page<AppShufflingPic> page = appShufflingPicService.findAppShufflingPicsByAppShufflingPic(appShufflingPic, 1, 3);

        MobileResult result = new MobileResult();
        result.setCode(200);
        result.setData(page.getRows());
        return  result;
    }


    @RequestMapping(value = "getSkinVersion")
    @ResponseBody
    public MobileResult getSkinVersion(HttpServletRequest httpServletRequest) {
        Page<AppSkinVersion> page = appSkinVersionService.findAppSkinVersionsByMobile();
        MobileResult result = new MobileResult();
        result.setCode(200);
        result.setData(page.getRows());
        return  result;
    }
}
