package com.party.ijurong.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.party.ijurong.dto.MemberServeDto;
import com.party.ijurong.mapper.MemberServeMapper;
import com.party.ijurong.pojo.MemberServe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/5/21 0021.
 */
@Service
public class MemberServeService extends BaseService<MemberServe> {
    @Autowired
    private MemberServeMapper serveMapper;

    public PageInfo<MemberServeDto> queryServeDtoList(MemberServeDto dto, int page, int rows) {
        PageHelper.startPage(page, rows);
        List<MemberServeDto> dtoList = serveMapper.queryServeDtoList(dto);
        return new PageInfo<>(dtoList);
    }
}
