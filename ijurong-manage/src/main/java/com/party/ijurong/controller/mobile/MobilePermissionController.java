package com.party.ijurong.controller.mobile;

import com.party.ijurong.bean.MobileResult;
import com.party.ijurong.bean.SimpleUser;
import com.party.ijurong.pojo.Permission;
import com.party.ijurong.service.MobileShiroService;
import com.party.ijurong.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Administrator on 2017/6/6 0006.
 */
@Controller
@RequestMapping("mobile/permission")
public class MobilePermissionController {
    @Autowired
    private PermissionService permissionService;
    @Autowired
    private MobileShiroService shiroService;

    @RequestMapping("list")
    @ResponseBody
    public MobileResult list() {
        MobileResult result = new MobileResult();
        SimpleUser user = shiroService.getUser();
        List<Permission> list = permissionService.queryAllPermissions(user.getUserId());
        result.setCode(200);
        result.setData(list);
        return result;
    }
}
