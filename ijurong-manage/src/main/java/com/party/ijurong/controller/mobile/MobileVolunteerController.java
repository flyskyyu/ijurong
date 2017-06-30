package com.party.ijurong.controller.mobile;

import com.party.ijurong.bean.MobileResult;
import com.party.ijurong.bean.SimpleUser;
import com.party.ijurong.pojo.Volunteer;
import com.party.ijurong.service.MobileShiroService;
import com.party.ijurong.service.VolunteerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Cloud on 2017/6/30.
 */
@Controller
@RequestMapping("mobile/volunteer")
public class MobileVolunteerController {
    @Autowired
    private VolunteerService volunteerService;
    @Autowired
    private MobileShiroService shiroService;

    @RequestMapping("apply")
    @ResponseBody
    public MobileResult apply(Volunteer volunteer) {
        MobileResult result = new MobileResult();
        SimpleUser user = shiroService.getUser();
        volunteer.setUserId(user.getUserId());
        volunteerService.saveSelective(volunteer);
        result.setCode(200);
        return result;
    }
}
