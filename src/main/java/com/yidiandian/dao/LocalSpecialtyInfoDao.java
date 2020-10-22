package com.yidiandian.dao;

import com.yidiandian.entity.LocalSpecialtyInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 当地特产信息表(LocalSpecialtyInfo)表数据库访问层
 *
 * @author makejava
 * @since 2020-10-22 16:15:50
 */
@Mapper
public interface LocalSpecialtyInfoDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    LocalSpecialtyInfo queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<LocalSpecialtyInfo> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param localSpecialtyInfo 实例对象
     * @return 对象列表
     */
    List<LocalSpecialtyInfo> queryAll(LocalSpecialtyInfo localSpecialtyInfo);

    /**
     * 新增数据
     *
     * @param localSpecialtyInfo 实例对象
     * @return 影响行数
     */
    int insert(LocalSpecialtyInfo localSpecialtyInfo);

    /**
     * 修改数据
     *
     * @param localSpecialtyInfo 实例对象
     * @return 影响行数
     */
    int update(LocalSpecialtyInfo localSpecialtyInfo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}