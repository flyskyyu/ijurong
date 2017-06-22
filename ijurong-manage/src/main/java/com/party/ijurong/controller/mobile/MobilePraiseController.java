package com.party.ijurong.controller.mobile;

import com.github.pagehelper.PageInfo;
import com.party.ijurong.bean.MobileResult;
import com.party.ijurong.bean.SimpleUser;
import com.party.ijurong.constants.ConstantOrigin;
import com.party.ijurong.pojo.Praise;
import com.party.ijurong.service.MobileShiroService;
import com.party.ijurong.service.PraiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * Created by Administrator on 2017/6/10 0010.
 */
@Controller
@RequestMapping("mobile/like")
public class MobilePraiseController {
    @Autowired
    private MobileShiroService shiroService;
    @Autowired
    private PraiseService praiseService;

    @RequestMapping("like")
    @ResponseBody
    public MobileResult like(Praise praise) {
        SimpleUser user = shiroService.getUser();
        praise.setStaffId(user.getUserId());
        praise.setPraisedTime(new Date());
        MobileResult result = new MobileResult();
        if(praiseService.add(praise) == 2) {
            result.setCode(300);
            result.setMsg("已经赞过");
            return result;
        }
        result.setCode(200);
        return result;
    }

    @RequestMapping("myList")
    @ResponseBody
    public MobileResult myList(@RequestParam(defaultValue = "1")int page
            , @RequestParam(defaultValue = "20")int rows) {
        Praise praise = new Praise();
        SimpleUser user = shiroService.getUser();
        praise.setStaffId(user.getUserId());
        PageInfo<Praise> pageInfo = praiseService.queryByPraise(praise, page, rows);
        MobileResult result = new MobileResult();
        result.setData(pageInfo.getList());
        result.setCode(200);
        return result;
    }

    @RequestMapping("unlike")
    @ResponseBody
    public MobileResult unlike(Praise praise) {
        MobileResult result = new MobileResult();
        if(praise.getPraisedId() == null || praise.getType() == null) {
            result.setCode(300);
            result.setMsg("参数不完整");
            return result;
        }
        SimpleUser user = shiroService.getUser();
        praise.setStaffId(user.getUserId());
        praiseService.deleteByWhere(praise);
        result.setCode(200);
        return result;
    }
}
