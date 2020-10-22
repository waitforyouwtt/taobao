package com.yidiandian.dao;

import com.yidiandian.entity.ScenicSpotDetails;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 景点景区详情表(ScenicSpotDetails)表数据库访问层
 *
 * @author makejava
 * @since 2020-10-15 17:09:50
 */
@Mapper
public interface ScenicSpotDetailsDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ScenicSpotDetails queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<ScenicSpotDetails> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param scenicSpotDetails 实例对象
     * @return 对象列表
     */
    List<ScenicSpotDetails> queryAll(ScenicSpotDetails scenicSpotDetails);

    /**
     * 新增数据
     *
     * @param scenicSpotDetails 实例对象
     * @return 影响行数
     */
    int insert(ScenicSpotDetails scenicSpotDetails);

    /**
     * 修改数据
     *
     * @param scenicSpotDetails 实例对象
     * @return 影响行数
     */
    int update(ScenicSpotDetails scenicSpotDetails);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    /**
     * 删除用户动态
     * @param scenicSpotId
     * @param userId
     * @return
     */
    int deleteUserDynamic(@Param("scenicSpotId") int scenicSpotId,@Param("userId") String userId);
}