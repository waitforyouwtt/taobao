package com.yidiandian.service;

import com.yidiandian.entity.ScenicSpotDetails;
import com.yidiandian.vo.ScenicSpotInfoVO;
import com.yidiandian.vo.UserDynamicVO;

import java.util.List;

/**
 * 景点景区详情表(ScenicSpotDetails)表服务接口
 *
 * @author makejava
 * @since 2020-10-15 17:09:50
 */
public interface ScenicSpotDetailsService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ScenicSpotDetails queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<ScenicSpotDetails> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param scenicSpotDetails 实例对象
     * @return 实例对象
     */
    int insertScenicSpotDetails(ScenicSpotInfoVO vo, String userId, int resultOrder);

    /**
     * 修改数据
     *
     * @param scenicSpotDetails 实例对象
     * @return 实例对象
     */
    ScenicSpotDetails update(ScenicSpotDetails scenicSpotDetails);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    /**
     * 平台用户发布动态
     * @param userDynamicVO
     * @param scenicSpotInfoId
     * @return
     */
    int publishDynamic(UserDynamicVO userDynamicVO, int scenicSpotInfoId);
}