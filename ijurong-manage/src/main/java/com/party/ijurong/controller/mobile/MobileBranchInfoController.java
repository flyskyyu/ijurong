package com.party.ijurong.controller.mobile;

import com.party.ijurong.bean.MobileResult;
import com.party.ijurong.bean.Page;
import com.party.ijurong.pojo.PartyBranchInfo;
import com.party.ijurong.service.PartyBranchInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @RequestMapping(value = "list")
    @ResponseBody
    public MobileResult list(PartyBranchInfo branchInfo, @RequestParam(defaultValue = "1")int page
            , @RequestParam(defaultValue = "20")int rows) {
        Page<PartyBranchInfo> pageInfo = branchInfoService.findPartyBranchInfosByPartyBranchInfo(branchInfo, page, rows);
        MobileResult result = new MobileResult();
        result.setCode(200);
        result.setData(pageInfo.getRows());
        return  result;
    }
}
