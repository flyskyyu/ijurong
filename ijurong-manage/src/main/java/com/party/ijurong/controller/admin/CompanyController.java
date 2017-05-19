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
public class CompanyController {


    @Autowired
    private EnterpriseInfoService enterpriseInfoService;

    @RequestMapping(value = "/findCompanys", method = { RequestMethod.POST, RequestMethod.GET })
    @ResponseBody
    public Page<EnterpriseInfo> findCompanys(HttpServletRequest httpServletRequest,
                               @ModelAttribute EnterpriseInfo hospitalUser, @RequestParam int page, @RequestParam int rows) {
        Page<EnterpriseInfo> result = enterpriseInfoService.findCompanysByCompany(hospitalUser, page, rows);
        return result;
    }




    @RequestMapping(value = "addCompany", method =
            { RequestMethod.POST, RequestMethod.GET })
    @ResponseBody
    public String addCompany(HttpServletRequest httpServletRequest, @ModelAttribute EnterpriseInfo enterpriseInfo)
    {
        long companyCount=enterpriseInfoService.findCompanysByName(enterpriseInfo.getName());
        if (companyCount==0)
        {
            enterpriseInfoService.insertCompany(enterpriseInfo);
            return "success";
        }
        else if(companyCount>0)
        {
            return "had";
        }
        else
        {
            return "fail";
        }
    }

    @RequestMapping(value = "updateCompany", method =
            { RequestMethod.POST, RequestMethod.GET })
    @ResponseBody
    public String updateCompany(HttpServletRequest httpServletRequest, @ModelAttribute EnterpriseInfo enterpriseInfo)
    {
        enterpriseInfoService.updateCompany(enterpriseInfo);
        return "success";
    }

    @RequestMapping(value = "delectCompany/{id}", method =
            { RequestMethod.POST, RequestMethod.GET })
    @ResponseBody
    public String delectHospitalUser(HttpServletRequest httpServletRequest, @PathVariable int id)
    {
        enterpriseInfoService.deleteCompany(id);
        return "success";
    }


}
