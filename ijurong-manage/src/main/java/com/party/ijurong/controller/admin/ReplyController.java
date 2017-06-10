package com.party.ijurong.controller.admin;

import com.github.pagehelper.PageInfo;
import com.party.ijurong.bean.Page;
import com.party.ijurong.pojo.Reply;
import com.party.ijurong.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2017/6/9 0009.
 */
@Controller
@RequestMapping("admin/reply")
public class ReplyController {
    @Autowired
    private ReplyService replyService;

    @RequestMapping(value = "list")
    @ResponseBody
    public Page list(Reply reply, @RequestParam(defaultValue = "1")int page
            , @RequestParam(defaultValue = "20")int rows) {
        PageInfo<Reply> pageInfo = replyService.queryByReply(reply, page, rows);
        return  new Page(pageInfo);
    }

    @RequestMapping(value = "delete")
    @ResponseBody
    public String delete(Integer id) {
        replyService.deleteById(id);
        return "success";
    }
}
