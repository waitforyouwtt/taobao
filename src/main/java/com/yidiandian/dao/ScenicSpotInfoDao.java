package com.yidiandian.dao;

import com.yidiandian.entity.ScenicSpotInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 景点景区表(ScenicSpotInfo)表数据库访问层
 *
 * @author makejava
 * @since 2020-10-15 17:07:50
 */
@Mapper
public interface ScenicSpotInfoDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ScenicSpotInfo queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<ScenicSpotInfo> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param scenicSpotInfo 实例对象
     * @return 对象列表
     */
    List<ScenicSpotInfo> queryAll(ScenicSpotInfo scenicSpotInfo);

    /**
     * 新增数据
     *
     * @param scenicSpotInfo 实例对象
     * @return 影响行数
     */
    int insert(ScenicSpotInfo scenicSpotInfo);

    /**
     * 修改数据
     *
     * @param scenicSpotInfo 实例对象
     * @return 影响行数
     */
    int update(ScenicSpotInfo scenicSpotInfo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    /**
     *  通过scenicSpotName模糊匹配
      * @param scenicSpotName
     * @return
     */
    ScenicSpotInfo findAllByScenicSpotName(@Param("scenicSpotName") String scenicSpotName);

}