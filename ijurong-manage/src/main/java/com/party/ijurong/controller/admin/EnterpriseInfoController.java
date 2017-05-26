package com.party.ijurong.controller.admin;

import com.party.ijurong.bean.Page;
import com.party.ijurong.pojo.EnterpriseInfo;
import com.party.ijurong.pojo.PartyBranchInfo;
import com.party.ijurong.pojo.ResourceType;
import com.party.ijurong.pojo.Volunteer;
import com.party.ijurong.service.EnterpriseInfoService;
import com.party.ijurong.service.PartyBranchInfoService;
import com.party.ijurong.service.ResourceTypeService;
import com.party.ijurong.service.VolunteerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.util.StringUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

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

    @Autowired
    private PartyBranchInfoService partyBranchInfoService;


    @Autowired
    private VolunteerService volunteerService;

    @Autowired
    private ResourceTypeService resourceTypeService;


    @RequestMapping(value = "/findEnterpriseInfos", method = { RequestMethod.POST, RequestMethod.GET })
    @ResponseBody
    public Page<EnterpriseInfo> findEnterpriseInfos(HttpServletRequest httpServletRequest,
                               @ModelAttribute EnterpriseInfo enterpriseInfo, @RequestParam int page, @RequestParam int rows) {
        Page<EnterpriseInfo> result = enterpriseInfoService.findEnterpriseInfosByEnterpriseInfo(enterpriseInfo, page, rows);
        return result;
    }

    @RequestMapping(value = "/findEnterpriseInfoByName", method = { RequestMethod.POST, RequestMethod.GET })
    @ResponseBody
    public Page<EnterpriseInfo> findEnterpriseInfoByName(HttpServletRequest httpServletRequest,@RequestParam(required=false) String q,
                                                    @ModelAttribute EnterpriseInfo enterpriseInfo, @RequestParam int page, @RequestParam int rows) {
        if(StringUtil.isEmpty(enterpriseInfo.getName()))
        {
            if(q!=null&&!q.equals("")) {
                enterpriseInfo.setName(q);
            }
        }
        Page<EnterpriseInfo> result = enterpriseInfoService.findEnterpriseInfosByEnterpriseInfo(enterpriseInfo, page, rows);
        return result;
    }

    @RequestMapping(value = "/findEnterpriseInfoById/{id}", method = { RequestMethod.POST, RequestMethod.GET })
    @ResponseBody
    public EnterpriseInfo findEnterpriseInfoById(HttpServletRequest httpServletRequest,@PathVariable int id) {
        EnterpriseInfo result = enterpriseInfoService.findEnterpriseInfoById(id);
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
    public String delectEnterpriseInfo(HttpServletRequest httpServletRequest, @PathVariable int id)
    {
        enterpriseInfoService.deleteEnterpriseInfo(id);
        return "success";
    }



    @RequestMapping(value = "/findPartyBranchInfos", method = { RequestMethod.POST, RequestMethod.GET })
    @ResponseBody
    public Page<PartyBranchInfo> findPartyBranchInfos(HttpServletRequest httpServletRequest,
                                                      @ModelAttribute PartyBranchInfo partyBranchInfo, @RequestParam int page, @RequestParam int rows) {
        Page<PartyBranchInfo> result = partyBranchInfoService.findPartyBranchInfosByPartyBranchInfo(partyBranchInfo, page, rows);
        return result;
    }

    @RequestMapping(value = "/findPartyBranchInfoByName", method = { RequestMethod.POST, RequestMethod.GET })
    @ResponseBody
    public Page<PartyBranchInfo> findPartyBranchInfoByName(HttpServletRequest httpServletRequest,@RequestParam(required=false) String q,
                                                         @ModelAttribute PartyBranchInfo partyBranchInfo, @RequestParam int page, @RequestParam int rows) {
        if(StringUtil.isEmpty(partyBranchInfo.getOrganizationName()))
        {
            if(q!=null&&!q.equals("")) {
                partyBranchInfo.setOrganizationName(q);
            }
        }
        Page<PartyBranchInfo> result = partyBranchInfoService.findPartyBranchInfosByPartyBranchInfo(partyBranchInfo, page, rows);
        return result;
    }

    @RequestMapping(value = "/findPartyBranchInfoById/{id}", method = { RequestMethod.POST, RequestMethod.GET })
    @ResponseBody
    public PartyBranchInfo findPartyBranchInfoById(HttpServletRequest httpServletRequest,@PathVariable int id) {
        PartyBranchInfo result = partyBranchInfoService.findPartyBranchInfoById(id);
        return result;
    }

    @RequestMapping(value = "addPartyBranchInfo", method =
            { RequestMethod.POST, RequestMethod.GET })
    @ResponseBody
    public String addPartyBranchInfo(HttpServletRequest httpServletRequest, @ModelAttribute PartyBranchInfo partyBranchInfo)
    {
        long partyBranchInfoCount=partyBranchInfoService.findPartyBranchInfosByName(partyBranchInfo.getOrganizationName());
        if (partyBranchInfoCount==0)
        {
            partyBranchInfo.setId(0);
            partyBranchInfoService.insertPartyBranchInfo(partyBranchInfo);
            return "success";
        }
        else if(partyBranchInfoCount>0)
        {
            return "had";
        }
        else
        {
            return "fail";
        }
    }

    @RequestMapping(value = "updatePartyBranchInfo", method =
            { RequestMethod.POST, RequestMethod.GET })
    @ResponseBody
    public String updatePartyBranchInfo(HttpServletRequest httpServletRequest, @ModelAttribute PartyBranchInfo partyBranchInfo)
    {
        partyBranchInfoService.updatePartyBranchInfo(partyBranchInfo);
        return "success";
    }

    @RequestMapping(value = "delectPartyBranchInfo/{id}", method =
            { RequestMethod.POST, RequestMethod.GET })
    @ResponseBody
    public String delectPartyBranchInfo(HttpServletRequest httpServletRequest, @PathVariable int id)
    {
        partyBranchInfoService.deletePartyBranchInfo(id);
        return "success";
    }

    

    @RequestMapping(value = "/findVolunteers", method = { RequestMethod.POST, RequestMethod.GET })
    @ResponseBody
    public Page<Volunteer> findVolunteers(HttpServletRequest httpServletRequest,
                                          @ModelAttribute Volunteer volunteer, @RequestParam int page, @RequestParam int rows) {
        Page<Volunteer> result = volunteerService.findVolunteersByVolunteer(volunteer, page, rows);
        return result;
    }

    @RequestMapping(value = "addVolunteer", method =
            { RequestMethod.POST, RequestMethod.GET })
    @ResponseBody
    public String addVolunteer(HttpServletRequest httpServletRequest, @ModelAttribute Volunteer volunteer)
    {
        long volunteerCount=volunteerService.findVolunteersByName(volunteer.getName());
        if (volunteerCount==0)
        {
            volunteerService.insertVolunteer(volunteer);
            return "success";
        }
        else if(volunteerCount>0)
        {
            return "had";
        }
        else
        {
            return "fail";
        }
    }

    @RequestMapping(value = "updateVolunteer", method =
            { RequestMethod.POST, RequestMethod.GET })
    @ResponseBody
    public String updateVolunteer(HttpServletRequest httpServletRequest, @ModelAttribute Volunteer volunteer)
    {
        volunteerService.updateVolunteer(volunteer);
        return "success";
    }

    @RequestMapping(value = "delectVolunteer/{id}", method =
            { RequestMethod.POST, RequestMethod.GET })
    @ResponseBody
    public String delectVolunteer(HttpServletRequest httpServletRequest, @PathVariable int id)
    {
        volunteerService.deleteVolunteer(id);
        return "success";
    }




    @RequestMapping(value = "/findResourceTypes", method = { RequestMethod.POST, RequestMethod.GET })
    @ResponseBody
    public Page<ResourceType> findResourceTypes(HttpServletRequest httpServletRequest,
                                                @ModelAttribute ResourceType resourceType, @RequestParam int page, @RequestParam int rows) {
        Page<ResourceType> result = resourceTypeService.findResourceTypesByResourceType(resourceType, page, rows);
        return result;
    }

    @RequestMapping(value = "addResourceType", method =
            { RequestMethod.POST, RequestMethod.GET })
    @ResponseBody
    public String addResourceType(HttpServletRequest httpServletRequest, @ModelAttribute ResourceType resourceType)
    {
        long resourceTypeCount=resourceTypeService.findResourceTypesByName(resourceType.getType());
        if (resourceTypeCount==0)
        {
            resourceType.setCreateTime(new Date());
            resourceType.setCreateUerId(1);//TODO 需要加上用户id
            resourceTypeService.insertResourceType(resourceType);
            return "success";
        }
        else if(resourceTypeCount>0)
        {
            return "had";
        }
        else
        {
            return "fail";
        }
    }

    @RequestMapping(value = "updateResourceType", method =
            { RequestMethod.POST, RequestMethod.GET })
    @ResponseBody
    public String updateResourceType(HttpServletRequest httpServletRequest, @ModelAttribute ResourceType resourceType)
    {
        resourceTypeService.updateResourceType(resourceType);
        return "success";
    }

    @RequestMapping(value = "delectResourceType/{id}", method =
            { RequestMethod.POST, RequestMethod.GET })
    @ResponseBody
    public String delectResourceType(HttpServletRequest httpServletRequest, @PathVariable int id)
    {
        resourceTypeService.deleteResourceType(id);
        return "success";
    }






}
