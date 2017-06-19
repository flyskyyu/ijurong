package com.party.ijurong.controller.admin;

import com.github.pagehelper.PageInfo;
import com.party.ijurong.bean.Page;
import com.party.ijurong.pojo.PartyPosition;
import com.party.ijurong.service.PartyPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2017/6/19 0019.
 */
@Controller
@RequestMapping("admin/partyPosition")
public class PartyPositionController {
    @Autowired
    private PartyPositionService partyPositionService;

    @RequestMapping(value = "list")
    @ResponseBody
    public Page list(@RequestParam(defaultValue = "1")int page
            , @RequestParam(defaultValue = "20")int rows) {
        PageInfo<PartyPosition> pageInfo = partyPositionService.queryPageList(page, rows);
        return  new Page(pageInfo);
    }

    @RequestMapping(value = "update")
    @ResponseBody
    public String update(PartyPosition obj) {
        partyPositionService.updateSelective(obj);
        return "success";
    }

    @RequestMapping(value = "add")
    @ResponseBody
    public String add(PartyPosition obj) {
        obj.setId(null);
        partyPositionService.save(obj);
        return "success";
    }

    @RequestMapping(value = "delete")
    @ResponseBody
    public String delete(Integer id) {
        partyPositionService.deleteById(id);
        return "success";
    }
}
