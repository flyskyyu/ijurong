package com.party.ijurong.service;

import com.party.ijurong.dto.StaffTokenDto;
import com.party.ijurong.mapper.StaffTokenMapper;
import com.party.ijurong.pojo.StaffToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/5/28 0028.
 */
@Service
public class StaffTokenService extends BaseService<StaffToken> {
    @Autowired
    private StaffTokenMapper tokenMapper;

    public StaffTokenDto queryByTokenDto(StaffTokenDto dto) {
        return tokenMapper.queryByTokenDto(dto);
    }

    public StaffTokenDto queryByToken(String token) {
        StaffTokenDto dto = new StaffTokenDto();
        dto.setToken(token);
        return tokenMapper.queryByTokenDto(dto);
    }
}
