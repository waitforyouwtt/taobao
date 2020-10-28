package com.yidiandian.dao;

import com.yidiandian.entity.ScenicSpotInfo;
import com.yidiandian.view.ScenicSpotInfoView;
import com.yidiandian.view.ScenicSpotView;
import com.yidiandian.view.UserScenicSpotView;
import com.yidiandian.vo.QueryScenicSpotVO;
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

    /**
     * 根据标题模糊查询
     * @param title
     * @return
     */
    List<ScenicSpotInfo> findSpotInfoLikeTitle(@Param("title") String title);

    /**
     * 查询景点景区且根据省份城市分组
     * @param vo
     * @return
     */
    List<ScenicSpotView> queryScenicSpotGroup(QueryScenicSpotVO vo);

    /**
     * 删除用户动态
     * @param id
     * @param userId
     * @return
     */
    int deleteUserDynamic(@Param("id") int id,@Param("userId") String userId);

    /**
     * 查询用户动态且分页
     * @return
     */
    List<UserScenicSpotView> findSpotInfoPage();
}