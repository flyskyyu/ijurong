package com.party.ijurong.service;

import com.party.ijurong.mapper.MarkMapper;
import com.party.ijurong.pojo.Mark;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/6/10 0010.
 */
@Service
public class MarkService extends BaseService<Mark> {
    @Autowired
    private MarkMapper markMapper;

    public int markCount(int id, int type) {
        Mark mark = new Mark();
        mark.setMarkedId(id);
        mark.setType(type);
        return markMapper.selectCount(mark);
    }

    public int isMarked(int userId, int id, int type) {
        Mark mark = new Mark();
        mark.setStaffId(userId);
        mark.setMarkedId(id);
        mark.setType(type);
        return markMapper.selectCount(mark);
    }
}
