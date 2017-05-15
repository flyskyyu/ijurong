package com.party.ijurong.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.ids.DeleteByIdsMapper;
import tk.mybatis.mapper.common.ids.SelectByIdsMapper;

import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class BaseService<T> {
    @Autowired
    protected Mapper<T> mapper;
    private Class<T> clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];

    /**
     * 根据id查询数据
     *
     * @param id
     * @return
     */
    public T queryById(Long id) {
        return this.mapper.selectByPrimaryKey(id);
    }

    /**
     * 查询所有数据
     *
     * @return
     */
    public List<T> queryAll() {
        return this.mapper.select(null);
    }

    /**
     * 根据条件查询一条数据
     *
     * @param record
     * @return
     */
    public T queryOne(T record) {
        return this.mapper.selectOne(record);
    }

    /**
     * 根据条件查询数据列表
     *
     * @param record
     * @return
     */
    public List<T> queryListByWhere(T record) {
        return this.mapper.select(record);
    }

    /**
     * 根据条件分页查询数据列表
     *
     * @param page
     * @param rows
     * @param record
     * @return
     */
    public PageInfo<T> queryPageListByWhere(Integer page, Integer rows, T record) {
        // 设置分页参数
        PageHelper.startPage(page, rows);
        List<T> list = this.mapper.select(record);
        return new PageInfo<T>(list);
    }

    /**
     * 分页查询数据列表
     *
     * @param page
     * @param rows
     * @return
     */
    public PageInfo<T> queryPageList(Integer page, Integer rows) {
        return queryPageListByWhere(page, rows, null);
    }

    /**
     * 新增数据
     *
     * @param t
     * @return
     */
    public Integer save(T t) {
        return this.mapper.insert(t);
    }

    /**
     * 有选择的保存，选择不为null的字段作为插入字段
     *
     * @param t
     * @return
     */
    public Integer saveSelective(T t) {
        return this.mapper.insertSelective(t);
    }

    /**
     * 更新数据
     *
     * @param t
     * @return
     */
    public Integer update(T t) {
        return this.mapper.updateByPrimaryKey(t);
    }

    /**
     * 有选择的更新，选择不为null的字段作为插入字段
     *
     * @param t
     * @return
     */
    public Integer updateSelective(T t) {
        return this.mapper.updateByPrimaryKeySelective(t);
    }

    /**
     * 根据id删除数据
     *
     * @param id
     * @return
     */
    public Integer deleteById(Long id) {
        return this.mapper.deleteByPrimaryKey(id);
    }

    /**
     * 批量删除,必须包含唯一主键id
     *
     * @param ids
     * @return
     */
    public Integer deleteByIds(Long[] ids) {
        if (mapper instanceof DeleteByIdsMapper) {
            return ((DeleteByIdsMapper) mapper).deleteByIds(StringUtils.join(ids, ","));
        }
        throw new UnsupportedOperationException("不支持批量删除");
    }

    /**
     * 批量获取
     *
     * @param ids
     * @return
     */
    public List<T> selectByIds(Long[] ids) {
        if (mapper instanceof SelectByIdsMapper) {
            return ((SelectByIdsMapper) mapper).selectByIds(StringUtils.join(ids, ","));
        }
        throw new UnsupportedOperationException("不支持批量获取");
    }

    /**
     * 根据条件删除数据
     *
     * @param record
     * @return
     */
    public Integer deleteByWhere(T record) {
        return this.mapper.delete(record);
    }
}
