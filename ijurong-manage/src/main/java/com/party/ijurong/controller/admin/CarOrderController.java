package com.party.ijurong.controller.admin;

import com.github.pagehelper.PageInfo;
import com.party.ijurong.bean.Page;
import com.party.ijurong.dto.CarOrderDto;
import com.party.ijurong.dto.ExcellentMemberDto;
import com.party.ijurong.service.CarOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Cloud on 2017/5/26.
 */
@Controller
@RequestMapping("admin/carOrder")
public class CarOrderController {
    @Autowired
    private CarOrderService carOrderService;

    @RequestMapping(value = "list")
    @ResponseBody
    public Page<ExcellentMemberDto> list(CarOrderDto dto, @RequestParam(defaultValue = "1")int page
            , @RequestParam(defaultValue = "20")int rows) {
        PageInfo<CarOrderDto> pageInfo = carOrderService.queryCarOrderDtoList(dto, page, rows);
        return  new Page(pageInfo);
    }

    @RequestMapping(value = "update")
    @ResponseBody
    public String update(CarOrderDto obj) {
        carOrderService.updateSelective(obj);
        return "success";
    }

    @RequestMapping(value = "add")
    @ResponseBody
    public String add(CarOrderDto obj) {
        obj.setId(null);
        carOrderService.save(obj);
        return "success";
    }

    @RequestMapping(value = "delete")
    @ResponseBody
    public String delete(Integer id) {
        carOrderService.deleteById(id);
        return "success";
    }

    @RequestMapping(value = "reply")
    @ResponseBody
    public String reply(CarOrderDto apply) {
        carOrderService.apply(apply);
        return "success";
    }
}
