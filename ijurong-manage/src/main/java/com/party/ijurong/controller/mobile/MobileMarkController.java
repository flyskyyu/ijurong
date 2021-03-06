package com.party.ijurong.controller.mobile;

import com.github.pagehelper.PageInfo;
import com.party.ijurong.bean.MobileResult;
import com.party.ijurong.bean.SimpleUser;
import com.party.ijurong.constants.ConstantOrigin;
import com.party.ijurong.pojo.Mark;
import com.party.ijurong.service.MarkService;
import com.party.ijurong.service.MobileShiroService;
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
@RequestMapping("mobile/mark")
public class MobileMarkController {
    @Autowired
    private MobileShiroService shiroService;
    @Autowired
    private MarkService markService;

    @RequestMapping("mark")
    @ResponseBody
    public MobileResult mark(Mark mark) {
        MobileResult result = new MobileResult();
        SimpleUser user = shiroService.getUser();
        mark.setStaffId(user.getUserId());
        if(markService.queryCount(mark) > 0) {
            result.setCode(300);
            result.setMsg("已收藏");
            return result;
        }
        mark.setMarkedTime(new Date());
        markService.save(mark);
        result.setCode(200);
        return result;
    }

    @RequestMapping("myList")
    @ResponseBody
    public MobileResult mark(@RequestParam(defaultValue = "1")int page
            , @RequestParam(defaultValue = "20")int rows) {
        MobileResult result = new MobileResult();
        Mark mark = new Mark();
        SimpleUser user = shiroService.getUser();
        mark.setStaffId(user.getUserId());
        PageInfo<Mark> pageInfo = markService.queryByMark(mark, page, rows);
        result.setCode(200);
        result.setData(pageInfo.getList());
        return result;
    }

    @RequestMapping("unmark")
    @ResponseBody
    public MobileResult unmark(Mark mark) {
        MobileResult result = new MobileResult();
        SimpleUser user = shiroService.getUser();
        mark.setStaffId(user.getUserId());
        markService.deleteByWhere(mark);
        result.setCode(200);
        return result;
    }
}
