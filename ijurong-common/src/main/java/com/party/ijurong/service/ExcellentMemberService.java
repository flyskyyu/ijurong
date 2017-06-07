package com.party.ijurong.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.party.ijurong.dto.ExcellentMemberDto;
import com.party.ijurong.mapper.ExcellentMemberMapper;
import com.party.ijurong.pojo.ExcellentMember;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

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

    public PageInfo<ExcellentMember> queryByMember(ExcellentMember member, int page, int rows) {
        Example example = new Example(ExcellentMember.class);
        example.orderBy("selectionDate").desc();
        PageHelper.startPage(page, rows);
        List<ExcellentMember> objs = excellentMemberMapper.selectByExample(example);
        return new PageInfo<>(objs);
    }
}
