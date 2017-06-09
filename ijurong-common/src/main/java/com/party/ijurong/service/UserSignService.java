package com.party.ijurong.service;

import com.party.ijurong.bean.CombotreeResult;
import com.party.ijurong.bean.Page;
import com.party.ijurong.mapper.UserSignMapper;
import com.party.ijurong.pojo.UserSign;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yu on 2017/5/19.
 */
@Service
public class UserSignService extends BaseService<UserSign>{

    @Autowired
    private UserSignMapper userSignMapper;
    /**
     * 查询所有
     * @param page
     * @param rows
     * @return
     */
    public Page<UserSign> findUserSignsByUserSign(UserSign userSign,int page, int rows) {
        RowBounds rowBounds=new RowBounds((page - 1) * rows,page*rows);
        List<UserSign> list =mapper.selectByRowBounds(userSign, rowBounds);
        long count = mapper.selectCount(userSign);
        return new Page<UserSign>(count, list);
    }



    public UserSign findUserSignById(int id) {
        UserSign userSign=new UserSign();
        userSign.setId(id);
        return  mapper.selectOne(userSign);
    }

    public List<UserSign> findUserSignByUserIdAndDate(int userId) {
        return userSignMapper.findUserSignByUserIdAndDate(userId);
    }

    /**
     * 添加
     * @param userSign
     */
    public void insertUserSign(UserSign userSign)
    {
        mapper.insert(userSign);
    }

    /**
     * 更新
     * @param userSign
     */
    public void updateUserSign(UserSign userSign)
    {
        mapper.updateByPrimaryKeySelective(userSign);
    }

    /**
     * 删除
     * @param id
     */
    public void deleteUserSign(int id)
    {
        UserSign userSign=new UserSign();
        userSign.setId(id);
        mapper.delete(userSign);
    }

}
