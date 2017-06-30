package com.party.ijurong.controller.mobile;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.party.ijurong.bean.MobileResult;
import com.party.ijurong.bean.SimpleUser;
import com.party.ijurong.constants.ConstantOrigin;
import com.party.ijurong.dto.ReplyDto;
import com.party.ijurong.pojo.*;
import com.party.ijurong.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/6/9 0009.
 */
@Controller
@RequestMapping("mobile/reply")
public class MobileReplyController {
    @Autowired
    private MobileShiroService shiroService;
    @Autowired
    private ReplyService replyService;
    @Autowired
    private PraiseService praiseService;
    @Autowired
    private MarkService markService;
    @Autowired
    private StaffService staffService;
    @Autowired
    private NewsService newsService;
    @Autowired
    private MessageService messageService;
    @Autowired
    private ActivityService activityService;
    @Autowired
    private PanelDiscussionService panelDiscussionService;
    @Autowired
    private ExcellentMemberService excellentMemberService;

    @RequestMapping(value = "myList")
    @ResponseBody
    public MobileResult myList(@RequestParam(defaultValue = "1") int page
            , @RequestParam(defaultValue = "20") int rows) {
        SimpleUser user = shiroService.getUser();
        ReplyDto dto = new ReplyDto();
        dto.setStaffId(user.getUserId());
        dto.setShowMyReply(true);
        PageInfo<ReplyDto> pageInfo = replyService.queryByReplyDto(dto, page, rows);
        MobileResult result = new MobileResult();
        result.setCode(200);
        result.setData(pageInfo.getList());
        return result;
    }

    @RequestMapping(value = "followDetail")
    @ResponseBody
    public MobileResult followDetail(int id, int type) {
        JSONObject jsonObject = new JSONObject();
        try {
            if(type == 20) {
                Reply reply = replyService.queryById(id);
                jsonObject = getFollow(reply.getArticleId(), reply.getArticleType());
            } else {
                jsonObject = getFollow(id, type);
            }
        } catch (Exception e) {
            jsonObject.put("title", "");
            jsonObject.put("detail", "");
        }
        MobileResult result = new MobileResult();
        result.setCode(200);
        result.setData(jsonObject);
        return result;
    }

    private JSONObject getFollow(int id, int type) {
        JSONObject jsonObject = new JSONObject();
        String title = "";
        String detail = "";
        if(type == ConstantOrigin.C1_NEWS) {
            News news = newsService.queryById(id);
            title = news.getTitle();
            detail = news.getNewsContent();

        } else if(type == ConstantOrigin.C2_MESSAGE) {
            Message message = messageService.queryById(id);
            title = message.getTitle();
            detail = message.getNewsContent();
        } else if(type == ConstantOrigin.C7_ACTIVITIES) {
            Activity activity = activityService.queryById(id);
            title = activity.getTitle();
            detail = activity.getDetail();
        } else if(type == ConstantOrigin.C9_DISCUSSION) {
            PanelDiscussion panelDiscussion = panelDiscussionService.queryById(id);
            title = panelDiscussion.getTitle();
            detail = panelDiscussion.getContent();
        } else if(type == ConstantOrigin.C10_GOODPARTYER) {
            ExcellentMember member = excellentMemberService.queryById(id);
            title = member.getTitle();
            detail = member.getMeritoriousDeeds();
        }
        jsonObject.put("title", title);
        jsonObject.put("detail", detail);
        return jsonObject;
    }


    @RequestMapping(value = "reply")
    @ResponseBody
    public MobileResult reply(Reply reply) {
        SimpleUser user = shiroService.getUser();
        reply.setStaffId(user.getUserId());
        reply.setPublishTime(new Date());
        replyService.reply(reply);
        Reply record = new Reply();
        record.setArticleId(reply.getArticleId());
        record.setArticleType(reply.getArticleType());
        int count = replyService.queryCount(record);
        MobileResult result = new MobileResult();
        result.setCode(200);
        result.setData(count);
        return result;
    }

    @RequestMapping(value = "replyList")
    @ResponseBody
    public MobileResult replyList(ReplyDto dto, @RequestParam(defaultValue = "1") int page
            , @RequestParam(defaultValue = "20") int rows) {
        SimpleUser user = shiroService.getUser();
        dto.setStaffId(user.getUserId());
        dto.setShowMyReply(false);
        PageInfo<ReplyDto> dtos = replyService.queryByReplyDto(dto, page, rows);
        MobileResult result = new MobileResult();
        result.setCode(200);
        result.setData(dtos.getList());
        return result;
    }

    @RequestMapping(value = "replyLikeAndMark")
    @ResponseBody
    public MobileResult replyLikeAndMark(Integer id, int type) {
        SimpleUser user = shiroService.getUser();
        Map map = new HashMap();
        map.put("replyNum", replyService.replyCount(id, type));
        map.put("likeNum", praiseService.likeCount(id, type));
        map.put("isLiked", praiseService.isLiked(user.getUserId(), id, type));
        map.put("markNum", markService.markCount(id, type));
        map.put("isMarked", markService.isMarked(user.getUserId(), id, type));
        MobileResult result = new MobileResult();
        result.setCode(200);
        result.setData(map);
        return result;
    }
}
