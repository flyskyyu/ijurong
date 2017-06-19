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
import tk.mybatis.mapper.entity.Example;

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

    public PageInfo<HardMemberApply> queryApplyList(HardMemberApply apply, int page, int rows) {
        PageHelper.startPage(page, rows);
        Example example = new Example(HardMemberApply.class);
        Example.Criteria criteria = example.createCriteria();
        if(apply.getStaffId() != null) {
            criteria.andEqualTo("staffId", apply.getStaffId());
        }
        example.orderBy("id").desc();
        return new PageInfo<>(applyMapper.selectByExample(example));
    }

    /**
     * 回复申请
     * @param apply
     */
    public void reply(HardMemberApply apply) {
        //不能被更新的设成空
        apply.setApplyTime(null);
        applyMapper.updateByPrimaryKeySelective(apply);

        if(apply.getIsAgree() == HardMemberApply.YES) {
            PartyMember member = new PartyMember();
            member.setUserId(apply.getStaffId());
            member.setIsHardMember(apply.getIsHardMember());
            member.setIsOldMember(apply.getIsOldMember());
            member.setIsEnjoyMla(apply.getIsEnjoyMla());
            member.setIsEnjoySubsidy(apply.getIsEnjoySubsidy());
            member.setHardType(apply.getHardType());
            member.setHardDesc(apply.getHardDesc());
            member.setHealthStatus(apply.getHealthStatus());
            member.setWorkSituation(apply.getWorkSituation());
            member.setLifeSituation(apply.getLifeSituation());
            member.setOtherDesc(apply.getOtherDesc());
            member.setPoliceStation(apply.getPoliceStation());
            memberMapper.updateByPrimaryKeySelective(member);
        }
    }
}
