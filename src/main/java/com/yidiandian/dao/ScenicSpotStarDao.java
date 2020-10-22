package com.yidiandian.dao;

import com.yidiandian.entity.ScenicSpotStar;
import com.yidiandian.support.Result;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 景点景区点赞表(ScenicSpotStar)表数据库访问层
 *
 * @author makejava
 * @since 2020-10-22 10:59:51
 */
@Mapper
public interface ScenicSpotStarDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ScenicSpotStar queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<ScenicSpotStar> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param scenicSpotStar 实例对象
     * @return 对象列表
     */
    List<ScenicSpotStar> queryAll(ScenicSpotStar scenicSpotStar);

    /**
     * 新增数据
     *
     * @param scenicSpotStar 实例对象
     * @return 影响行数
     */
    int insert(ScenicSpotStar scenicSpotStar);

    /**
     * 修改数据
     *
     * @param scenicSpotStar 实例对象
     * @return 影响行数
     */
    int update(ScenicSpotStar scenicSpotStar);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    /**
     * 用户对浏览的动态取消点赞
     * @param scenicSpotInfoId
     * @param userId
     * @return
     */
    int cancelDynamicStar(@Param("scenicSpotInfoId") Integer scenicSpotInfoId,@Param("userId") String userId);
}