package com.party.ijurong.controller.mobile.authc;

import com.party.ijurong.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Cloud on 2017/5/27.
 */
@Controller("mobileCar")
@RequestMapping("mobile/car")
public class CarController {
    @Autowired
    private CarService carService;


}
