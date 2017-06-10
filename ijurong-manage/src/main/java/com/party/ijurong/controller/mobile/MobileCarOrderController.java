package com.party.ijurong.controller.mobile;

import com.github.pagehelper.PageInfo;
import com.party.ijurong.bean.MobileResult;
import com.party.ijurong.bean.SimpleUser;
import com.party.ijurong.dto.CarOrderDto;
import com.party.ijurong.pojo.CarOrder;
import com.party.ijurong.service.CarOrderService;
import com.party.ijurong.service.MobileShiroService;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

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
        if(dto.getStartTime() == null) {
            dto.setStartTime(DateUtils.truncate(new Date(), Calendar.DATE));
        }
        dto.setOrderType(2);
        PageInfo<CarOrderDto> pageInfo = carOrderService.queryCarOrderDtoList(dto, page, rows);
        result.setCode(200);
        result.setData(arrangeList(pageInfo.getList()));
        return result;
    }

    @RequestMapping(value = "allApply")
    @ResponseBody
    public MobileResult allApply(CarOrderDto dto, @RequestParam(defaultValue = "1")int page
            , @RequestParam(defaultValue = "20")int rows) {
        MobileResult result = new MobileResult();
        if(dto.getStartTime() == null) {
            dto.setStartTime(new Date());
        }
        if(dto.getTypeFilter() == 0) {
            dto.setTypeFilter(5);
        }
        dto.setOrderType(2);
        PageInfo<CarOrderDto> pageInfo = carOrderService.queryCarOrderDtoList(dto, page, rows);
        result.setCode(200);
        result.setData(arrangeList(pageInfo.getList()));
        return result;
    }

    private Map<String, List<CarOrderDto>> arrangeList(List<CarOrderDto> dtos) {
        Map<String, List<CarOrderDto>> map = new LinkedHashMap<>();
        for(CarOrderDto dto : dtos) {
            String key = DateFormatUtils.format(dto.getStartTime(), "yyyy-MM-dd");
            List list = map.get(key);
            if(list == null) {
                list = new ArrayList();
            }
            list.add(dto);
            map.put(key, list);
        }
        return map;
    }
}
