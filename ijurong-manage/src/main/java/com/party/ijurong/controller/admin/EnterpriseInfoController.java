package com.party.ijurong.controller.admin;

import com.party.ijurong.bean.Page;
import com.party.ijurong.pojo.EnterpriseInfo;
import com.party.ijurong.service.EnterpriseInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Copyright ©, 2016-2056
 * FileName:  AdminController
 *
 * @author CS-711701-00027
 * @version 1.0
 * @Date: 2017/5/16
 * Description:
 * Function List:
 * 1. -------
 * History:
 * maurice 16/02/12 1.0 build this moudle
 */
@RequestMapping("admin/company")
@Controller
public class EnterpriseInfoController {


    @Autowired
    private EnterpriseInfoService enterpriseInfoService;

    @RequestMapping(value = "/findEnterpriseInfos", method = { RequestMethod.POST, RequestMethod.GET })
    @ResponseBody
    public Page<EnterpriseInfo> findEnterpriseInfos(HttpServletRequest httpServletRequest,
                               @ModelAttribute EnterpriseInfo enterpriseInfo, @RequestParam int page, @RequestParam int rows) {
        Page<EnterpriseInfo> result = enterpriseInfoService.findEnterpriseInfosByEnterpriseInfo(enterpriseInfo, page, rows);
        return result;
    }




    @RequestMapping(value = "addEnterpriseInfo", method =
            { RequestMethod.POST, RequestMethod.GET })
    @ResponseBody
    public String addEnterpriseInfo(HttpServletRequest httpServletRequest, @ModelAttribute EnterpriseInfo enterpriseInfo)
    {
        long enterpriseInfoCount=enterpriseInfoService.findEnterpriseInfosByName(enterpriseInfo.getName());
        if (enterpriseInfoCount==0)
        {
            enterpriseInfoService.insertEnterpriseInfo(enterpriseInfo);
            return "success";
        }
        else if(enterpriseInfoCount>0)
        {
            return "had";
        }
        else
        {
            return "fail";
        }
    }

    @RequestMapping(value = "updateEnterpriseInfo", method =
            { RequestMethod.POST, RequestMethod.GET })
    @ResponseBody
    public String updateEnterpriseInfo(HttpServletRequest httpServletRequest, @ModelAttribute EnterpriseInfo enterpriseInfo)
    {
        enterpriseInfoService.updateEnterpriseInfo(enterpriseInfo);
        return "success";
    }

    @RequestMapping(value = "delectEnterpriseInfo/{id}", method =
            { RequestMethod.POST, RequestMethod.GET })
    @ResponseBody
    public String delectHospitalUser(HttpServletRequest httpServletRequest, @PathVariable int id)
    {
        enterpriseInfoService.deleteEnterpriseInfo(id);
        return "success";
    }


}
