package com.party.ijurong.controller.admin;

import com.github.pagehelper.PageInfo;
import com.party.ijurong.bean.Page;
import com.party.ijurong.pojo.Item;
import com.party.ijurong.pojo.Staff;
import com.party.ijurong.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2017/5/23 0023.
 */
@Controller
@RequestMapping("admin/item")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @RequestMapping(value = "list")
    @ResponseBody
    public Page<Staff> list(Item item, @RequestParam(defaultValue = "1")int page
            , @RequestParam(defaultValue = "20")int rows) {
        PageInfo<Item> pageInfo = itemService.queryByItem(item, page, rows);
        return  new Page(pageInfo);
    }

    @RequestMapping(value = "update")
    @ResponseBody
    public String update(Item obj) {
        itemService.updateSelective(obj);
        return "success";
    }

    @RequestMapping(value = "add")
    @ResponseBody
    public String add(Item obj) {
        obj.setId(null);
        itemService.save(obj);
        return "success";
    }

    @RequestMapping(value = "delete")
    @ResponseBody
    public String delete(Integer id) {
        itemService.deleteById(id);
        return "success";
    }
}
