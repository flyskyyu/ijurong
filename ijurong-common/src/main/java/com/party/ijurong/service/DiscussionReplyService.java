package com.party.ijurong.service;

import com.party.ijurong.bean.Page;
import com.party.ijurong.pojo.DiscussionReply;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Created by yu on 2017/5/19.
 */
@Service
public class DiscussionReplyService extends BaseService<DiscussionReply>{

    /**
     * 查询所有回复
     * @param discussionReply
     * @param page
     * @param rows
     * @return
     */
    public Page<DiscussionReply> findDiscussionReplysByDiscussionReply(DiscussionReply discussionReply, int page, int rows) {
        RowBounds rowBounds=new RowBounds((page - 1) * rows,page*rows);
        Example example = new Example(DiscussionReply.class);
//        if(discussionReply.getReplyContent()!=null&&discussionReply.getReplyContent()!="") {
//            example.createCriteria().andLike("replyContent", "%" + discussionReply.getReplyContent() + "%");
//        }
        example.createCriteria().andEqualTo("discussionId",  discussionReply.getDiscussionId() );
        List<DiscussionReply> list =mapper.selectByExampleAndRowBounds(example,rowBounds);
        long count = mapper.selectCountByExample(example);
        return new Page<DiscussionReply>(count, list);
    }

    public DiscussionReply findDiscussionReplyById(int id) {
        DiscussionReply discussionReply=new DiscussionReply();
        discussionReply.setId(id);
        return  mapper.selectOne(discussionReply);
    }


    /**
     * 根据名称查询回复
     * @param name
     * @return
     */
    public long findDiscussionReplysByName(String name)
    {
        DiscussionReply discussionReply=new DiscussionReply();
        discussionReply.setReplyContent(name);
        return mapper.selectCount(discussionReply);
    }

    /**
     * 添加回复
     * @param discussionReply
     */
    public void insertDiscussionReply(DiscussionReply discussionReply)
    {
        mapper.insert(discussionReply);
    }

    /**
     * 更新回复
     * @param discussionReply
     */
    public void updateDiscussionReply(DiscussionReply discussionReply)
    {
        mapper.updateByPrimaryKeySelective(discussionReply);
    }

    /**
     * 删除回复
     * @param id
     */
    public void deleteDiscussionReply(int id)
    {
        DiscussionReply discussionReply=new DiscussionReply();
        discussionReply.setId(id);
        mapper.delete(discussionReply);
    }

}
