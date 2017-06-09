package com.party.ijurong.controller.mobile;

import com.party.ijurong.bean.MobileResult;
import com.party.ijurong.bean.Page;
import com.party.ijurong.bean.SimpleUser;
import com.party.ijurong.pojo.PanelDiscussion;
import com.party.ijurong.pojo.Staff;
import com.party.ijurong.pojo.UserSign;
import com.party.ijurong.service.MobileShiroService;
import com.party.ijurong.service.PanelDiscussionService;
import com.party.ijurong.service.StaffService;
import com.party.ijurong.service.UserSignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * Created by Administrator on 2017/5/28 0028.
 */
@Controller
@RequestMapping("mobile/discussion")
public class MobilePanelDiscussionController {
    @Autowired
    private PanelDiscussionService panelDiscussionService;
    @Autowired
    private MobileShiroService shiroService;

    @RequestMapping("addDiscussion")
    @ResponseBody
    public MobileResult addDiscussion(String title,int isShadow) {
        MobileResult result = new MobileResult();
        try {

            SimpleUser user = shiroService.getUser();
            PanelDiscussion panelDiscussion=new PanelDiscussion();
            panelDiscussion.setUserId(user.getUserId());
            panelDiscussion.setCreateTime(new Date());
            panelDiscussion.setTitle(title);
            panelDiscussion.setIsShadow(isShadow);
            panelDiscussionService.insertPanelDiscussion(panelDiscussion);
            result.setCode(200);
            result.setMsg("发布成功！");

        }
        catch (Exception e)
        {
            e.printStackTrace();
            result.setCode(404);
            result.setMsg("系统异常！");
        }
        return result;
    }

    @RequestMapping("getList")
    @ResponseBody
    public MobileResult getList(HttpServletRequest httpServletRequest,int isShadow, @RequestParam(defaultValue = "1")int page
            , @RequestParam(defaultValue = "20")int rows) {
        MobileResult result = new MobileResult();
        try {

            SimpleUser user = shiroService.getUser();
            PanelDiscussion panelDiscussion=new PanelDiscussion();
            panelDiscussion.setIsShadow(isShadow);
            Page<PanelDiscussion> p= panelDiscussionService.findPanelDiscussionsByPanelDiscussion(panelDiscussion, page, rows);
            result.setCode(200);
            result.setData(p.getRows());
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