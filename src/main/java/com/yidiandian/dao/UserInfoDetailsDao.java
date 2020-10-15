package com.yidiandian.dao;

import com.yidiandian.entity.UserInfoDetails;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 用户信息详情表(UserInfoDetails)表数据库访问层
 *
 * @author makejava
 * @since 2020-10-15 09:47:13
 */
@Mapper
public interface UserInfoDetailsDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    UserInfoDetails queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<UserInfoDetails> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param userInfoDetails 实例对象
     * @return 对象列表
     */
    List<UserInfoDetails> queryAll(UserInfoDetails userInfoDetails);

    /**
     * 新增数据
     *
     * @param userInfoDetails 实例对象
     * @return 影响行数
     */
    int insert(UserInfoDetails userInfoDetails);

    /**
     * 修改数据
     *
     * @param userInfoDetails 实例对象
     * @return 影响行数
     */
    int update(UserInfoDetails userInfoDetails);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}