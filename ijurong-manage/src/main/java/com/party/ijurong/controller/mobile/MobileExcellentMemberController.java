package com.party.ijurong.controller.mobile;

import com.github.pagehelper.PageInfo;
import com.party.ijurong.bean.MobileResult;
import com.party.ijurong.pojo.ExcellentMember;
import com.party.ijurong.service.ExcellentMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Cloud on 2017/6/7.
 */
@Controller
@RequestMapping("mobile/excellentMember")
public class MobileExcellentMemberController {
    @Autowired
    private ExcellentMemberService memberService;

    @RequestMapping(value = "list")
    @ResponseBody
    public MobileResult list(@RequestParam(defaultValue = "1")int page
            , @RequestParam(defaultValue = "20")int rows) {
        PageInfo<ExcellentMember> pageInfo = memberService.queryByMember(null, page, rows);
        MobileResult result = new MobileResult();
        result.setCode(200);
        result.setData(pageInfo.getList());
        return  result;
    }
}
