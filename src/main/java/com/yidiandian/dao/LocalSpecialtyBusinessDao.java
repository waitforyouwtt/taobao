package com.yidiandian.dao;

import com.yidiandian.entity.LocalSpecialtyBusiness;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 当地特产合作商家表(LocalSpecialtyBusiness)表数据库访问层
 *
 * @author makejava
 * @since 2020-10-22 16:15:11
 */
@Mapper
public interface LocalSpecialtyBusinessDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    LocalSpecialtyBusiness queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<LocalSpecialtyBusiness> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param localSpecialtyBusiness 实例对象
     * @return 对象列表
     */
    List<LocalSpecialtyBusiness> queryAll(LocalSpecialtyBusiness localSpecialtyBusiness);

    /**
     * 新增数据
     *
     * @param localSpecialtyBusiness 实例对象
     * @return 影响行数
     */
    int insert(LocalSpecialtyBusiness localSpecialtyBusiness);

    /**
     * 修改数据
     *
     * @param localSpecialtyBusiness 实例对象
     * @return 影响行数
     */
    int update(LocalSpecialtyBusiness localSpecialtyBusiness);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}