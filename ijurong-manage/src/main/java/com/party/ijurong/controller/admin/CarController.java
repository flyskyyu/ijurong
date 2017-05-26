package com.party.ijurong.controller.admin;

import com.github.pagehelper.PageInfo;
import com.party.ijurong.bean.Page;
import com.party.ijurong.bean.SimpleUser;
import com.party.ijurong.dto.ExcellentMemberDto;
import com.party.ijurong.pojo.Car;
import com.party.ijurong.service.CarService;
import com.party.ijurong.service.ShiroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Cloud on 2017/5/25.
 */
@Controller
@RequestMapping("admin/car")
public class CarController {
    @Autowired
    private CarService carService;
    @Autowired
    private ShiroService shiroService;

    @RequestMapping(value = "list")
    @ResponseBody
    public Page<ExcellentMemberDto> list(Car car, @RequestParam(defaultValue = "1")int page
            , @RequestParam(defaultValue = "20")int rows) {
        if(car.getPartyBranchId() == null) {
            SimpleUser user = shiroService.getUser();
            car.setPartyBranchId(user.getBranchInfos().get(0).getId());
        }
        PageInfo<Car> pageInfo = carService.queryByCar(car, page, rows);
        return  new Page(pageInfo);
    }

    @RequestMapping(value = "listByQ")
    @ResponseBody
    public Page<ExcellentMemberDto> listByQ(String q, @RequestParam(defaultValue = "1")int page
            , @RequestParam(defaultValue = "20")int rows) {
        Car car = new Car();
        car.setCarNum(q);
        SimpleUser user = shiroService.getUser();
        car.setPartyBranchId(user.getBranchInfos().get(0).getId());
        PageInfo<Car> pageInfo = carService.queryByCar(car, page, rows);
        return  new Page(pageInfo);
    }

    @RequestMapping(value = "update")
    @ResponseBody
    public String update(Car obj) {
        carService.updateSelective(obj);
        return "success";
    }

    @RequestMapping(value = "add")
    @ResponseBody
    public String add(Car obj) {
        obj.setId(null);
        carService.save(obj);
        return "success";
    }

    @RequestMapping(value = "delete")
    @ResponseBody
    public String delete(Integer id) {
        carService.deleteById(id);
        return "success";
    }
}
