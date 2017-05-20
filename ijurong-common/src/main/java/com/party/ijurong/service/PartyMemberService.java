package com.party.ijurong.service;

import com.party.ijurong.pojo.PartyMember;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

/**
 * Created by Cloud on 2017/5/20 0020.
 */
@Service
public class PartyMemberService extends BaseService<PartyMember> {
    public void save() {
        Example example = new Example(PartyMember.class);
        example.createCriteria().andLike("name", "%xx%");
        mapper.selectByExample(example);
    }
}
