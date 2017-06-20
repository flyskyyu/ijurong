package com.party.ijurong.controller.mobile;

import com.github.pagehelper.PageInfo;
import com.party.ijurong.bean.MobileResult;
import com.party.ijurong.bean.SimpleUser;
import com.party.ijurong.pojo.Car;
import com.party.ijurong.pojo.Item;
import com.party.ijurong.pojo.ItemReceive;
import com.party.ijurong.service.ItemReceiveService;
import com.party.ijurong.service.ItemService;
import com.party.ijurong.service.MobileShiroService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Cloud on 2017/6/20.
 */
@Controller
@RequestMapping("mobile/item")
public class MobileItemController {
    @Autowired
    private ItemService itemService;
    @Autowired
    private ItemReceiveService itemReceiveService;
    @Autowired
    private MobileShiroService shiroService;

    @RequestMapping(value = "list")
    @ResponseBody
    public MobileResult list(Item item, @RequestParam(defaultValue = "1")int page
            , @RequestParam(defaultValue = "20")int rows) {
        PageInfo<Item> pageInfo = itemService.queryByItem(item, page, rows);
        MobileResult result = new MobileResult();
        result.setCode(200);
        result.setData(pageInfo.getList());
        return  result;
    }

    @RequestMapping(value = "myList")
    @ResponseBody
    public MobileResult myList(@RequestParam(defaultValue = "1")int page
            , @RequestParam(defaultValue = "20")int rows) {
        SimpleUser user = shiroService.getUser();
        ItemReceive receive = new ItemReceive();
        receive.setUserId(user.getUserId());
        PageInfo<ItemReceive> pageInfo = itemReceiveService.queryByItemReceive(receive, page, rows);
        MobileResult result = new MobileResult();
        result.setCode(200);
        result.setData(pageInfo.getList());
        return  result;
    }

    @RequestMapping(value = "buy")
    @ResponseBody
    public MobileResult buy(ItemReceive obj) {
        MobileResult mobileResult = new MobileResult();
        SimpleUser user = shiroService.getUser();
        obj.setUserId(user.getUserId());
        if(StringUtils.isEmpty(obj.getName())) {
            obj.setName(user.getUserName());
        }
        if(StringUtils.isEmpty(obj.getPhone())) {
            obj.setPhone(user.getPhone());
        }
        int result = itemReceiveService.apply(obj);
        if(result == 2) {
            mobileResult.setCode(300);
            mobileResult.setMsg("商品数量不足");
            return mobileResult;
        } else if(result == 3) {
            mobileResult.setCode(300);
            mobileResult.setMsg("积分不足");
            return mobileResult;
        }
        mobileResult.setCode(200);
        return  mobileResult;
    }
}
