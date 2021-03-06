package com.party.ijurong.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.party.ijurong.constants.ConstantOrigin;
import com.party.ijurong.mapper.ActivityMapper;
import com.party.ijurong.mapper.PraiseMapper;
import com.party.ijurong.mapper.ReplyMapper;
import com.party.ijurong.pojo.Praise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Created by Administrator on 2017/6/10 0010.
 */
@Service
public class PraiseService extends BaseService<Praise> {
    @Autowired
    private PraiseMapper praiseMapper;
    @Autowired
    private ReplyMapper replyMapper;
    @Autowired
    private ActivityMapper activityMapper;

    public PageInfo<Praise> queryByPraise(Praise praise, int page, int rows) {
        Example example = new Example(Praise.class);
        Example.Criteria criteria = example.createCriteria();
        if(praise.getStaffId() != null) {
            criteria.andEqualTo("staffId", praise.getStaffId());
        }
        example.orderBy("id").desc();
        PageHelper.startPage(page, rows);
        List<Praise> list = praiseMapper.selectByExample(example);
        return new PageInfo<>(list);
    }

    //返回1表示成功，2表示已经点赞过
    public int add(Praise praise) {
        Praise temp = new Praise();
        temp.setStaffId(praise.getStaffId());
        temp.setPraisedId(praise.getPraisedId());
        temp.setType(praise.getType());
        if (praiseMapper.selectCount(temp) > 0) {
            return 2;
        }
        praiseMapper.insert(praise);
        if (praise.getType() == ConstantOrigin.C20_REPLY) {
            replyMapper.increaseLikeNum(praise.getPraisedId());
        } else if (praise.getType() == ConstantOrigin.C7_ACTIVITIES) {
            //activityMapper.increaseLikeNum(praise.getPraisedId());
        }
        return 1;
    }

    public int likeCount(int id, int type) {
        Praise praise = new Praise();
        praise.setPraisedId(id);
        praise.setType(type);
        return praiseMapper.selectCount(praise);
    }

    public int isLiked(int userId, int id, int type) {
        Praise praise = new Praise();
        praise.setPraisedId(id);
        praise.setType(type);
        praise.setStaffId(userId);
        return praiseMapper.selectCount(praise);
    }
}
