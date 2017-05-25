package com.party.ijurong.controller.admin;

import com.github.pagehelper.PageInfo;
import com.party.ijurong.bean.Page;
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
        car.setPartyBranchId(shiroService.getUser().getPartyBranchId());
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
        obj.setPartyBranchId(shiroService.getUser().getPartyBranchId());
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
