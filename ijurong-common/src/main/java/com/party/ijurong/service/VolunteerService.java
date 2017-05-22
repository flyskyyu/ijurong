package com.party.ijurong.service;

import com.party.ijurong.bean.Page;
import com.party.ijurong.pojo.Volunteer;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Created by yu on 2017/5/19.
 */
@Service
public class VolunteerService extends BaseService<Volunteer>{

    /**
     * 查询所有志愿者
     * @param volunteer
     * @param page
     * @param rows
     * @return
     */
    public Page<Volunteer> findVolunteersByVolunteer(Volunteer volunteer, int page, int rows) {
        RowBounds rowBounds=new RowBounds((page - 1) * rows,page*rows);
        Example example = new Example(Volunteer.class);
        if(volunteer.getName()!=null&&volunteer.getName()!="") {
            example.createCriteria().andLike("name", "%" + volunteer.getName() + "%");
        }
        if(volunteer.getSex()!=null&&volunteer.getSex()!=0) {
            example.createCriteria().andEqualTo("sex",volunteer.getSex());
        }
        if(volunteer.getIsPass()!=-1) {
            example.createCriteria().andEqualTo("isPass",volunteer.getIsPass());
        }
        List<Volunteer> list =mapper.selectByExampleAndRowBounds(example,rowBounds);
        long count = mapper.selectCountByExample(example);
        return new Page<Volunteer>(count, list);
    }

    public Volunteer findVolunteerById(int id) {
        Volunteer volunteer=new Volunteer();
        volunteer.setId(id);
        return  mapper.selectOne(volunteer);
    }


    /**
     * 根据名称查询志愿者
     * @param name
     * @return
     */
    public long findVolunteersByName(String name)
    {
        Volunteer volunteer=new Volunteer();
        volunteer.setName(name);
        return mapper.selectCount(volunteer);
    }

    /**
     * 添加志愿者
     * @param volunteer
     */
    public void insertVolunteer(Volunteer volunteer)
    {
        mapper.insert(volunteer);
    }

    /**
     * 更新志愿者
     * @param volunteer
     */
    public void updateVolunteer(Volunteer volunteer)
    {
        mapper.updateByPrimaryKeySelective(volunteer);
    }

    /**
     * 删除志愿者
     * @param id
     */
    public void deleteVolunteer(int id)
    {
        Volunteer volunteer=new Volunteer();
        volunteer.setId(id);
        mapper.delete(volunteer);
    }

}
