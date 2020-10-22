package com.yidiandian.dao;

import com.yidiandian.entity.ScenicSpotComment;
import com.yidiandian.support.Result;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 景点景区评论表(ScenicSpotComment)表数据库访问层
 *
 * @author makejava
 * @since 2020-10-22 11:00:17
 */
@Mapper
public interface ScenicSpotCommentDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ScenicSpotComment queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<ScenicSpotComment> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param scenicSpotComment 实例对象
     * @return 对象列表
     */
    List<ScenicSpotComment> queryAll(ScenicSpotComment scenicSpotComment);

    /**
     * 新增数据
     *
     * @param scenicSpotComment 实例对象
     * @return 影响行数
     */
    int insert(ScenicSpotComment scenicSpotComment);

    /**
     * 修改数据
     *
     * @param scenicSpotComment 实例对象
     * @return 影响行数
     */
    int update(ScenicSpotComment scenicSpotComment);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    /**
     * 用户对浏览的动态删除评论
     * @param id
     * @param userId
     * @return
     */
    int deleteByUserIdAndCommentId(@Param("id") Integer id,@Param("userId") String userId);
}