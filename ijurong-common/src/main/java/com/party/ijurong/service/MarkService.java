package com.party.ijurong.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.party.ijurong.mapper.MarkMapper;
import com.party.ijurong.pojo.Mark;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Created by Administrator on 2017/6/10 0010.
 */
@Service
public class MarkService extends BaseService<Mark> {
    @Autowired
    private MarkMapper markMapper;

    public PageInfo<Mark> queryByMark(Mark mark, int page, int rows) {
        Example example = new Example(Mark.class);
        Example.Criteria criteria = example.createCriteria();
        if(mark.getStaffId() != null) {
            criteria.andEqualTo("staffId", mark.getStaffId());
        }
        example.orderBy("id").desc();
        PageHelper.startPage(page, rows);
        List<Mark> list = markMapper.selectByExample(example);
        return new PageInfo<>(list);
    }

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
