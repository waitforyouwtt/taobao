package com.yidiandian.dao;

import com.yidiandian.entity.District;
import com.yidiandian.view.DistrictView;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 中国行政区划代码表
数据时间：2019年11月
数据来源：http://www.mca.gov.cn/article/sj/xzqh(District)表数据库访问层
 *
 * @author makejava
 * @since 2020-10-16 18:36:33
 */
public interface DistrictDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    District queryById(Object id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<District> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param district 实例对象
     * @return 对象列表
     */
    List<District> queryAll(District district);

    /**
     * 新增数据
     *
     * @param district 实例对象
     * @return 影响行数
     */
    int insert(District district);

    /**
     * 修改数据
     *
     * @param district 实例对象
     * @return 影响行数
     */
    int update(District district);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Object id);

    List<DistrictView> findBbsAreaByUPid(District district);

}