package com.party.ijurong.controller.admin;

import com.github.pagehelper.PageInfo;
import com.party.ijurong.bean.Page;
import com.party.ijurong.dto.MemberServeDto;
import com.party.ijurong.pojo.MemberServe;
import com.party.ijurong.pojo.PartyMember;
import com.party.ijurong.pojo.Staff;
import com.party.ijurong.service.MemberServeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2017/5/21 0021.
 */
@Controller
@RequestMapping("/admin/memberServe")
public class MemberServeController {
    @Autowired
    private MemberServeService serveService;

    @RequestMapping(value = "list")
    @ResponseBody
    public Page<Staff> list(MemberServeDto dto, @RequestParam(defaultValue = "1")int page
            , @RequestParam(defaultValue = "20")int rows) {
        PageInfo<MemberServeDto> pageInfo = serveService.queryServeDtoList(dto, page, rows);
        return  new Page(pageInfo);
    }

    @RequestMapping(value = "update")
    @ResponseBody
    public String update(MemberServe serve) {
        serveService.updateSelective(serve);
        return "success";
    }

    @RequestMapping(value = "add")
    @ResponseBody
    public String add(MemberServe serve) {
        serve.setId(null);
        serve.setServicedUserId(8);
        serveService.save(serve);
        return "success";
    }
}
