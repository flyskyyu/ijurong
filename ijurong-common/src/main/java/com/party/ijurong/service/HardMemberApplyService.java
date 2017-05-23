package com.party.ijurong.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.party.ijurong.dto.HardMemberApplyDto;
import com.party.ijurong.mapper.HardMemberApplyMapper;
import com.party.ijurong.mapper.PartyMemberMapper;
import com.party.ijurong.pojo.HardMemberApply;
import com.party.ijurong.pojo.PartyMember;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Cloud on 2017/5/23.
 */
@Service
public class HardMemberApplyService extends BaseService<HardMemberApply> {
    @Autowired
    private HardMemberApplyMapper applyMapper;
    @Autowired
    private PartyMemberMapper memberMapper;

    public PageInfo<HardMemberApplyDto> queryApplyDtoList(HardMemberApplyDto dto, int page, int rows) {
        PageHelper.startPage(page, rows);
        List<HardMemberApplyDto> dtos = applyMapper.queryApplyDtoList(dto);
        return new PageInfo<>(dtos);
    }

    /**
     * 回复申请
     * @param apply
     */
    public void apply(HardMemberApply apply) {
        HardMemberApply dbApply = applyMapper.selectByPrimaryKey(apply.getId());
        dbApply.setIsAgree(apply.getIsAgree());
        dbApply.setReply(apply.getReply());
        applyMapper.updateByPrimaryKeySelective(dbApply);

        if(apply.getIsAgree() == HardMemberApply.YES) {
            PartyMember member = new PartyMember();
            member.setUserId(dbApply.getStaffId());
            member.setIsHardMember(dbApply.getIsHardMember());
            member.setIsOldMember(dbApply.getIsOldMember());
            member.setIsEnjoyMla(dbApply.getIsEnjoyMla());
            member.setIsEnjoySubsidy(dbApply.getIsEnjoySubsidy());
            member.setHardType(dbApply.getHardType());
            member.setHardDesc(dbApply.getHardDesc());
            member.setHealthStatus(dbApply.getHealthStatus());
            member.setPoliceStation(dbApply.getPoliceStation());
            memberMapper.updateByPrimaryKeySelective(member);
        }
    }
}
