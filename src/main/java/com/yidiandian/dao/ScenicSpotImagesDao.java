package com.yidiandian.dao;

import com.yidiandian.entity.ScenicSpotImages;
import com.yidiandian.entity.UserHobby;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 景点景区图片集合表(ScenicSpotImages)表数据库访问层
 *
 * @author makejava
 * @since 2020-10-15 17:11:26
 */
@Mapper
public interface ScenicSpotImagesDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ScenicSpotImages queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<ScenicSpotImages> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param scenicSpotImages 实例对象
     * @return 对象列表
     */
    List<ScenicSpotImages> queryAll(ScenicSpotImages scenicSpotImages);

    /**
     * 新增数据
     *
     * @param scenicSpotImages 实例对象
     * @return 影响行数
     */
    int insert(ScenicSpotImages scenicSpotImages);

    /**
     * 修改数据
     *
     * @param scenicSpotImages 实例对象
     * @return 影响行数
     */
    int update(ScenicSpotImages scenicSpotImages);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    /**
     * 批量保存图片
     * @param batchEntities
     * @return
     */
    int batchInsertScenicSpotImages(@Param("batchEntities") List<ScenicSpotImages> batchEntities);

}