package com.party.ijurong.controller.mobile;

import com.github.pagehelper.PageInfo;
import com.party.ijurong.bean.MobileResult;
import com.party.ijurong.bean.Page;
import com.party.ijurong.bean.SimpleUser;
import com.party.ijurong.pojo.*;
import com.party.ijurong.service.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @Autowired
    private StaffService staffService;
    @Autowired
    private AppShufflingPicService appShufflingPicService;

    @RequestMapping(value = "list")
    @ResponseBody
    public MobileResult list(Item item, @RequestParam(defaultValue = "1")int page
            , @RequestParam(defaultValue = "20")int rows) {
        if(item.getBelong() == null) {
            item.setBelong(1);
        }
        PageInfo<Item> pageInfo = itemService.queryByItem(item, page, rows);
        MobileResult result = new MobileResult();
        result.setCode(200);
        result.setData(pageInfo.getList());
        return  result;
    }

    @RequestMapping(value = "integralMall")
    @ResponseBody
    public MobileResult integralMall() {
        Map map = new HashMap();
        SimpleUser user = shiroService.getUser();
        Staff staff = staffService.queryById(user.getUserId());
        map.put("integral", staff.getIntegral());
        List<Item> list = itemService.queryHotList();
        map.put("hotList", list);
        AppShufflingPic appShufflingPic=new AppShufflingPic();
        appShufflingPic.setFlag(1);
        Page<AppShufflingPic> page = appShufflingPicService.findAppShufflingPicsByAppShufflingPic(appShufflingPic, 1, 3);
        map.put("picList", page.getRows());
        MobileResult result = new MobileResult();
        result.setCode(200);
        result.setData(map);
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
