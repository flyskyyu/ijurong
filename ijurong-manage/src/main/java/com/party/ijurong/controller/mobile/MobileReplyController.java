package com.party.ijurong.controller.mobile;

import com.github.pagehelper.PageInfo;
import com.party.ijurong.bean.MobileResult;
import com.party.ijurong.bean.SimpleUser;
import com.party.ijurong.constants.ConstantOrigin;
import com.party.ijurong.dto.ReplyDto;
import com.party.ijurong.pojo.Mark;
import com.party.ijurong.pojo.Praise;
import com.party.ijurong.pojo.Reply;
import com.party.ijurong.service.MarkService;
import com.party.ijurong.service.MobileShiroService;
import com.party.ijurong.service.PraiseService;
import com.party.ijurong.service.ReplyService;
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

    @RequestMapping(value = "myList")
    @ResponseBody
    public MobileResult myList(@RequestParam(defaultValue = "1") int page
            , @RequestParam(defaultValue = "20") int rows) {
        SimpleUser user = shiroService.getUser();
        Reply reply = new Reply();
        reply.setStaffId(user.getUserId());
        PageInfo<Reply> pageInfo = replyService.queryByReply(reply, page, rows);
        MobileResult result = new MobileResult();
        result.setCode(200);
        result.setData(pageInfo.getList());
        return result;
    }

    @RequestMapping(value = "reply")
    @ResponseBody
    public MobileResult reply(Reply reply) {
        SimpleUser user = shiroService.getUser();
        reply.setStaffId(user.getUserId());
        reply.setPublishTime(new Date());
        replyService.reply(reply);
        MobileResult result = new MobileResult();
        result.setCode(200);
        return result;
    }

    @RequestMapping(value = "replyList")
    @ResponseBody
    public MobileResult replyList(ReplyDto dto, @RequestParam(defaultValue = "1") int page
            , @RequestParam(defaultValue = "20") int rows) {
        SimpleUser user = shiroService.getUser();
        dto.setStaffId(user.getUserId());
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
