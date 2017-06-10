package com.party.ijurong.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.party.ijurong.constants.ConstantOrigin;
import com.party.ijurong.dto.ReplyDto;
import com.party.ijurong.mapper.ActivityMapper;
import com.party.ijurong.mapper.ReplyMapper;
import com.party.ijurong.pojo.Reply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Created by Administrator on 2017/6/9 0009.
 */
@Service
public class ReplyService extends BaseService<Reply> {
    @Autowired
    private ReplyMapper replyMapper;
    @Autowired
    private ActivityMapper activityMapper;

    public PageInfo<Reply> queryByReply(Reply reply, int page, int rows) {
        Example example = new Example(Reply.class);
        Example.Criteria criteria = example.createCriteria();
        if(reply.getContent() != null) {
            criteria.andLike("content", "%" + reply.getContent() + "%");
        }
        if(reply.getStaffId() != null) {
            criteria.andEqualTo("staffId", reply.getStaffId());
        }
        example.orderBy("id").desc();
        List<Reply> list = replyMapper.selectByExample(example);
        return new PageInfo<>(list);
    }

    public void reply(Reply reply) {
        replyMapper.insertSelective(reply);
        if(reply.getArticleType() == ConstantOrigin.C20_REPLY) {
            replyMapper.increaseReplyNum(reply.getArticleId());
        } else if(reply.getArticleType() == ConstantOrigin.C7_ACTIVITIES) {
            activityMapper.increaseReplyNum(reply.getArticleId());
        }
    }

    public PageInfo<ReplyDto> queryByReplyDto(ReplyDto dto, int page, int rows) {
        PageHelper.startPage(page, rows);
        List<ReplyDto> dtos = replyMapper.queryByReplyDto(dto);
        return new PageInfo<>(dtos);
    }
}
