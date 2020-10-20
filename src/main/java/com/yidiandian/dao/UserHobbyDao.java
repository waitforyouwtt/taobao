package com.yidiandian.dao;

import com.yidiandian.entity.UserHobby;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 用户爱好表(UserHobby)表数据库访问层
 *
 * @author makejava
 * @since 2020-10-15 09:49:28
 */
@Mapper
public interface UserHobbyDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    UserHobby queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<UserHobby> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param userHobby 实例对象
     * @return 对象列表
     */
    List<UserHobby> queryAll(UserHobby userHobby);

    /**
     * 新增数据
     *
     * @param userHobby 实例对象
     * @return 影响行数
     */
    int insert(UserHobby userHobby);

    /**
     * 修改数据
     *
     * @param userHobby 实例对象
     * @return 影响行数
     */
    int update(UserHobby userHobby);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    int deleteByUserId(@Param("userId") String userId);


    /**
     * 选择爱好落库
     * @param batchEntities
     * @return
     */
    int batchInsertHobby(@Param("batchEntities") List<UserHobby> batchEntities);

}