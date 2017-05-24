package com.party.ijurong.controller.admin;

import com.github.pagehelper.PageInfo;
import com.party.ijurong.bean.Page;
import com.party.ijurong.dto.ItemReceiveDto;
import com.party.ijurong.pojo.ItemReceive;
import com.party.ijurong.service.ItemReceiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * Created by Cloud on 2017/5/24.
 */
@Controller
@RequestMapping("admin/itemReceive")
public class ItemReceiveController {
    @Autowired
    private ItemReceiveService itemReceiveService;

    @RequestMapping(value = "list")
    @ResponseBody
    public Page<ItemReceive> list(ItemReceiveDto dto, @RequestParam(defaultValue = "1")int page
            , @RequestParam(defaultValue = "20")int rows) {
        PageInfo<ItemReceiveDto> pageInfo = itemReceiveService.queryByItemReceive(dto, page, rows);
        return  new Page(pageInfo);
    }

    @RequestMapping(value = "update")
    @ResponseBody
    public String update(ItemReceive obj) {
        itemReceiveService.updateSelective(obj);
        return "success";
    }

    @RequestMapping(value = "add")
    @ResponseBody
    public String add(ItemReceive obj) {
        obj.setId(null);
        itemReceiveService.save(obj);
        return "success";
    }

    @RequestMapping(value = "delete")
    @ResponseBody
    public String delete(Integer id) {
        itemReceiveService.deleteById(id);
        return "success";
    }

    @RequestMapping(value = "reply")
    @ResponseBody
    public String reply(ItemReceive itemReceive) {
        int result = itemReceiveService.reply(itemReceive);
        if(result == ItemReceiveService.OK) {
            return "success";
        } else {
            return "lack";
        }
    }

    @RequestMapping(value = "receive")
    @ResponseBody
    public String receive(ItemReceive itemReceive) {
        ItemReceive dbReceive = new ItemReceive();
        dbReceive.setId(itemReceive.getId());
        dbReceive.setIsReceive((byte)1);
        dbReceive.setReceiveTime(new Date());
        itemReceiveService.updateSelective(dbReceive);
        return "success";
    }
}
