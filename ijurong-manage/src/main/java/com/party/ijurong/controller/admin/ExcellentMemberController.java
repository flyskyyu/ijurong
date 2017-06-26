package com.party.ijurong.controller.admin;

import com.github.pagehelper.PageInfo;
import com.party.ijurong.bean.Page;
import com.party.ijurong.dto.ExcellentMemberDto;
import com.party.ijurong.pojo.ExcellentMember;
import com.party.ijurong.service.ExcellentMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2017/5/22 0022.
 */
@Controller
@RequestMapping("admin/excellentMember")
public class ExcellentMemberController {
    @Autowired
    private ExcellentMemberService excellentMemberService;

    @RequestMapping(value = "list")
    @ResponseBody
    public Page<ExcellentMemberDto> list(ExcellentMemberDto dto, @RequestParam(defaultValue = "1")int page
            , @RequestParam(defaultValue = "20")int rows) {
        PageInfo<ExcellentMemberDto> pageInfo = excellentMemberService.queryExcellentMemberDtoList(dto, page, rows);
        return  new Page(pageInfo);
    }

    @RequestMapping(value = "update")
    @ResponseBody
    public String update(ExcellentMember serve) {
        excellentMemberService.updateSelective(serve);
        return "success";
    }

    @RequestMapping(value = "add")
    @ResponseBody
    public String add(ExcellentMember member) {
        member.setId(null);

        excellentMemberService.save(member);
        return "success";
    }

    @RequestMapping(value = "delete")
    @ResponseBody
    public String delete(Integer id) {
        excellentMemberService.deleteById(id);
        return "success";
    }
}
