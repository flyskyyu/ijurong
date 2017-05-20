package com.party.ijurong.controller.admin;

import com.github.pagehelper.PageInfo;
import com.party.ijurong.bean.Page;
import com.party.ijurong.pojo.PartyMember;
import com.party.ijurong.service.PartyMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Cloud on 2017/5/19.
 */
@Controller
@RequestMapping("/admin/member")
public class PartyMemberController {
    @Autowired
    private PartyMemberService partyMemberService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Page<PartyMember>> list(@RequestParam(defaultValue = "1")int page
            , @RequestParam(defaultValue = "20")int rows) {
        try {
            PageInfo<PartyMember> pageInfo = partyMemberService.queryPageList(page, rows);
            Page<PartyMember> result = new Page(pageInfo);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }
}
