package com.party.ijurong.controller.admin;

import com.party.ijurong.bean.Page;
import com.party.ijurong.pojo.DiscussionReply;
import com.party.ijurong.pojo.PanelDiscussion;
import com.party.ijurong.service.DiscussionReplyService;
import com.party.ijurong.service.PanelDiscussionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * Created by yu on 2017/6/1.
 */
@RequestMapping("admin/interactive")
@Controller
public class PanelDiscussionController {

    @Autowired
    private PanelDiscussionService panelDiscussionService;

    @Autowired
    private DiscussionReplyService discussionReplyService;

    @RequestMapping(value = "/findPanelDiscussions", method = { RequestMethod.POST, RequestMethod.GET })
    @ResponseBody
    public Page<PanelDiscussion> findPanelDiscussions(HttpServletRequest httpServletRequest,
                                                      @ModelAttribute PanelDiscussion panelDiscussion, @RequestParam int page, @RequestParam int rows) {
        Page<PanelDiscussion> result = panelDiscussionService.findPanelDiscussionsByPanelDiscussion(panelDiscussion, page, rows);
        return result;
    }


    @RequestMapping(value = "updatePanelDiscussion", method =
            { RequestMethod.POST, RequestMethod.GET })
    @ResponseBody
    public String updatePanelDiscussion(HttpServletRequest httpServletRequest, @ModelAttribute PanelDiscussion panelDiscussion)
    {
        panelDiscussionService.updatePanelDiscussion(panelDiscussion);
        return "success";
    }

    @RequestMapping(value = "delectPanelDiscussion/{id}", method =
            { RequestMethod.POST, RequestMethod.GET })
    @ResponseBody
    public String delectPanelDiscussion(HttpServletRequest httpServletRequest, @PathVariable int id)
    {
        panelDiscussionService.deletePanelDiscussion(id);
        return "success";
    }


    @RequestMapping(value = "/findDiscussionReplysByDiscussionId", method = { RequestMethod.POST, RequestMethod.GET })
    @ResponseBody
    public Page<DiscussionReply> findDiscussionReplysByDiscussionId(HttpServletRequest httpServletRequest,
                                                      @ModelAttribute DiscussionReply discussionReply, @RequestParam int page, @RequestParam int rows) {
        Page<DiscussionReply> result = discussionReplyService.findDiscussionReplysByDiscussionReply(discussionReply, page, rows);
        return result;
    }



    @RequestMapping(value = "delectDiscussionReply/{id}", method =
            { RequestMethod.POST, RequestMethod.GET })
    @ResponseBody
    public String delectDiscussionReply(HttpServletRequest httpServletRequest, @PathVariable int id)
    {
        discussionReplyService.deleteDiscussionReply(id);
        return "success";
    }


}
