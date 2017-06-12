package com.party.ijurong.controller.mobile;

import com.party.ijurong.bean.MobileResult;
import com.party.ijurong.pojo.PartyBranchInfo;
import com.party.ijurong.service.PartyBranchInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Administrator on 2017/6/12 0012.
 */
@Controller
@RequestMapping("mobile/branchInfo")
public class MobileBranchInfoController {
    @Autowired
    private PartyBranchInfoService branchInfoService;

    @RequestMapping("listAll")
    @ResponseBody
    public MobileResult listAll() {
        List<PartyBranchInfo> branchInfos = branchInfoService.queryAll();
        MobileResult result = new MobileResult();
        result.setCode(200);
        result.setData(branchInfos);
        return  result;
    }
}
