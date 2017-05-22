package com.party.ijurong.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.party.ijurong.dto.ExcellentMemberDto;
import com.party.ijurong.mapper.ExcellentMemberMapper;
import com.party.ijurong.pojo.ExcellentMember;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/5/22 0022.
 */
@Service
public class ExcellentMemberService extends BaseService<ExcellentMember> {
    @Autowired
    private ExcellentMemberMapper excellentMemberMapper;

    public PageInfo<ExcellentMemberDto> queryExcellentMemberDtoList(ExcellentMemberDto dto, int page, int rows) {
        PageHelper.startPage(page, rows);
        List<ExcellentMemberDto> dtos = excellentMemberMapper.queryExcellentMemberDtoList(dto);
        return new PageInfo<>(dtos);
    }
}
