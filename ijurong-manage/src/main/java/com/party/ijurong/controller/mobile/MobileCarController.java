package com.party.ijurong.controller.mobile;

import com.github.pagehelper.PageInfo;
import com.party.ijurong.bean.MobileResult;
import com.party.ijurong.bean.Page;
import com.party.ijurong.bean.SimpleUser;
import com.party.ijurong.pojo.Car;
import com.party.ijurong.service.CarService;
import com.party.ijurong.service.MobileShiroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Cloud on 2017/5/27.
 */
@Controller
@RequestMapping("mobile/car")
public class MobileCarController {
    @Autowired
    private CarService carService;
    @Autowired
    private MobileShiroService shiroService;

    @RequestMapping(value = "list")
    @ResponseBody
    public MobileResult list(Car car, @RequestParam(defaultValue = "1")int page
            , @RequestParam(defaultValue = "20")int rows) {
        if(car.getPartyBranchId() == null) {
            SimpleUser user = shiroService.getUser();
            car.setPartyBranchId(user.getBranchInfos().get(0).getId());
        }
        PageInfo<Car> pageInfo = carService.queryByCar(car, page, rows);
        MobileResult result = new MobileResult();
        result.setCode(200);
        result.setData(pageInfo.getList());
        return  result;
    }
}
