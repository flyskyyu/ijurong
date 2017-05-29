package com.party.ijurong.controller.mobile;

import com.github.pagehelper.PageInfo;
import com.party.ijurong.bean.MobileResult;
import com.party.ijurong.bean.Page;
import com.party.ijurong.bean.SimpleUser;
import com.party.ijurong.dto.CarOrderDto;
import com.party.ijurong.pojo.CarOrder;
import com.party.ijurong.service.CarOrderService;
import com.party.ijurong.service.MobileShiroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2017/5/29 0029.
 */
@Controller
@RequestMapping("mobile/carOrder")
public class MobileCarOrderController {
    @Autowired
    private CarOrderService carOrderService;
    @Autowired
    private MobileShiroService shiroService;

    @RequestMapping(value = "apply")
    @ResponseBody
    public MobileResult apply(CarOrder obj) {
        MobileResult result = new MobileResult();
        if(obj.getCarId() == null || obj.getStartTime() == null
                || obj.getEndTime() == null) {
            result.setData(400);
            result.setMsg("参数不完整");
            return  result;
        }
        SimpleUser user = shiroService.getUser();
        obj.setId(null);
        obj.setIsAgree(null);
        obj.setReply(null);
        obj.setStaffId(user.getUserId());
        carOrderService.save(obj);
        result.setCode(200);
        return result;
    }

    @RequestMapping(value = "myApply")
    @ResponseBody
    public MobileResult myApply(CarOrderDto dto, @RequestParam(defaultValue = "1")int page
            , @RequestParam(defaultValue = "20")int rows) {
        MobileResult result = new MobileResult();
        SimpleUser user = shiroService.getUser();
        dto.setStaffId(user.getUserId());
        PageInfo<CarOrderDto> pageInfo = carOrderService.queryCarOrderDtoList(dto, page, rows);
        result.setCode(200);
        result.setData(new Page<>(pageInfo));
        return result;
    }
}
