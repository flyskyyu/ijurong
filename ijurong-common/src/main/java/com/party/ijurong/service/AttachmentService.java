package com.party.ijurong.service;

import com.party.ijurong.bean.Page;
import com.party.ijurong.pojo.Attachment;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Created by yu on 2017/5/19.
 */
@Service
public class AttachmentService extends BaseService<Attachment>{

    /**
     * 查询所有附件
     * @param attachment
     * @param page
     * @param rows
     * @return
     */
    public Page<Attachment> findAttachmentsByAttachment(Attachment attachment, int page, int rows) {
        RowBounds rowBounds=new RowBounds((page - 1) * rows,page*rows);
        Example example = new Example(Attachment.class);
        List<Attachment> list =mapper.selectByExampleAndRowBounds(example,rowBounds);
        long count = mapper.selectCountByExample(example);
        return new Page<Attachment>(count, list);
    }

    //按功能查找
    public List<Attachment> findAttachmentByFunction(int functionType,int functionId) {
        Attachment attachment=new Attachment();
        attachment.setFunctionId(functionId);
        attachment.setFunctionType(functionType);
        return  mapper.select(attachment);
    }



    /**
     * 添加附件
     * @param attachment
     */
    public void insertAttachment(Attachment attachment)
    {
        mapper.insert(attachment);
    }

    /**
     * 更新附件
     * @param attachment
     */
    public void updateAttachment(Attachment attachment)
    {
        mapper.updateByPrimaryKeySelective(attachment);
    }

    /**
     * 删除附件
     * @param id
     */
    public void deleteAttachment(int id)
    {
        Attachment attachment=new Attachment();
        attachment.setId(id);
        mapper.delete(attachment);
    }

}
