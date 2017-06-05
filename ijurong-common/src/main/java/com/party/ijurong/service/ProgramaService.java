package com.party.ijurong.service;

import com.party.ijurong.bean.Page;
import com.party.ijurong.pojo.Programa;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Created by yu on 2017/5/19.
 */
@Service
public class ProgramaService extends BaseService<Programa>{

    /**
     * 查询所有栏目
     * @param programa
     * @param page
     * @param rows
     * @return
     */
    public Page<Programa> findProgramasByPrograma(Programa programa, int page, int rows,int origin) {
        RowBounds rowBounds=new RowBounds((page - 1) * rows,page*rows);
        Example example = new Example(Programa.class);
        if(programa.getName()!=null&&programa.getName()!="") {
            example.createCriteria().andLike("name", "%" + programa.getName() + "%");
        }
        example.createCriteria().andEqualTo("origin",origin);
        example.setOrderByClause("create_time DESC");
        List<Programa> list =mapper.selectByExampleAndRowBounds(example,rowBounds);
        long count = mapper.selectCountByExample(example);
        return new Page<Programa>(count, list);
    }

    public Programa findProgramaById(int id) {
        Programa programa=new Programa();
        programa.setId(id);
        return  mapper.selectOne(programa);
    }


    /**
     * 根据名称查询栏目
     * @param name
     * @return
     */
    public long findProgramasByName(String name,int origin)
    {
        Programa programa=new Programa();
        programa.setName(name);
        programa.setOrigin(origin);
        return mapper.selectCount(programa);
    }

    /**
     * 添加栏目
     * @param programa
     */
    public void insertPrograma(Programa programa,int origin)
    {
        programa.setOrigin(origin);
        mapper.insert(programa);
    }

    /**
     * 更新栏目
     * @param programa
     */
    public void updatePrograma(Programa programa)
    {
        mapper.updateByPrimaryKeySelective(programa);
    }

    /**
     * 删除栏目
     * @param id
     */
    public void deletePrograma(int id)
    {
        Programa programa=new Programa();
        programa.setId(id);
        mapper.delete(programa);
    }

}
