package com.party.ijurong.controller.client;

import com.github.pagehelper.PageInfo;
import com.party.ijurong.dto.ExcellentMemberDto;
import com.party.ijurong.service.ExcellentMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Administrator on 2017/6/26 0026.
 */
@Controller
@RequestMapping("client")
public class ClientExcellentMemberController {
    @Autowired
    private ExcellentMemberService excellentMemberService;

    @RequestMapping("excellentMember")
    public ModelAndView list() {
        ModelAndView mv = new ModelAndView();
        ExcellentMemberDto record = new ExcellentMemberDto();
        record.setHeadChar("a");
        PageInfo<ExcellentMemberDto> pageInfo = excellentMemberService.queryExcellentMemberDtoList(record, 1, 9999999);
        List<ExcellentMemberDto> list = pageInfo.getList();
        Map<String, List<ExcellentMemberDto>> map = new TreeMap<>();
        for(ExcellentMemberDto dto : list) {
            String key = dto.getHeadChar().toUpperCase();
            List members = map.get(key);
            if(members == null) {
                members = new ArrayList();
                map.put(key, members);
            }
            members.add(dto);
        }
        mv.setViewName("client/excellentMember");
        mv.addObject("members", map);
        return mv;
    }

    @RequestMapping("member_detail")
    public ModelAndView detail(Integer id) {
        ModelAndView mv = new ModelAndView();
        ExcellentMemberDto record = new ExcellentMemberDto();
        record.setId(id);
        PageInfo<ExcellentMemberDto> pageInfo = excellentMemberService.queryExcellentMemberDtoList(record, 1, 1);
        ExcellentMemberDto member = pageInfo.getList().get(0);
        mv.setViewName("client/member_detail");
        mv.addObject("member", member);
        return mv;
    }
}
