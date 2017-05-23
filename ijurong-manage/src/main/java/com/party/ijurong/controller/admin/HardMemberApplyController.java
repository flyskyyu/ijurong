package com.party.ijurong.controller.admin;

import com.github.pagehelper.PageInfo;
import com.party.ijurong.bean.Page;
import com.party.ijurong.dto.ExcellentMemberDto;
import com.party.ijurong.dto.HardMemberApplyDto;
import com.party.ijurong.pojo.HardMemberApply;
import com.party.ijurong.service.HardMemberApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * Created by Cloud on 2017/5/23.
 */
@Controller
@RequestMapping("admin/hardMemberApply")
public class HardMemberApplyController {
    @Autowired
    private HardMemberApplyService applyService;

    @RequestMapping(value = "list")
    @ResponseBody
    public Page<ExcellentMemberDto> list(HardMemberApplyDto dto, @RequestParam(defaultValue = "1")int page
            , @RequestParam(defaultValue = "20")int rows) {
        PageInfo<HardMemberApplyDto> pageInfo = applyService.queryApplyDtoList(dto, page, rows);
        return  new Page(pageInfo);
    }

    @RequestMapping(value = "update")
    @ResponseBody
    public String update(HardMemberApply obj) {
        applyService.updateSelective(obj);
        return "success";
    }

    @RequestMapping(value = "add")
    @ResponseBody
    public String add(HardMemberApply obj) {
        obj.setId(null);
        obj.setApplyTime(new Date());
        applyService.save(obj);
        return "success";
    }

    @RequestMapping(value = "delete")
    @ResponseBody
    public String delete(Integer id) {
        applyService.deleteById(id);
        return "success";
    }

    @RequestMapping(value = "reply")
    @ResponseBody
    public String reply(HardMemberApply apply) {
        applyService.apply(apply);
        return "success";
    }
}
