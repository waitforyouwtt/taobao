package com.yidiandian.service;

import com.yidiandian.entity.ScenicSpotInfo;
import com.yidiandian.view.ScenicSpotInfoView;
import com.yidiandian.vo.QueryScenicSpotVO;
import com.yidiandian.vo.ScenicSpotInfoVO;

import java.util.List;

/**
 * 景点景区表(ScenicSpotInfo)表服务接口
 *
 * @author makejava
 * @since 2020-10-15 17:11:58
 */
public interface ScenicSpotInfoService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ScenicSpotInfo queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<ScenicSpotInfo> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param scenicSpotInfoVO 实例对象
     * @return 实例对象
     */
    int publishMessage(ScenicSpotInfoVO scenicSpotInfoVO);

    /**
     * 修改数据
     *
     * @param scenicSpotInfo 实例对象
     * @return 实例对象
     */
    ScenicSpotInfo update(ScenicSpotInfo scenicSpotInfo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    /**
     * 查看用户发表的动态
     * @param spotVO
     * @return
     */
    List<ScenicSpotInfoView> findSpotInfo(QueryScenicSpotVO spotVO);
}