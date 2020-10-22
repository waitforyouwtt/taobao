package com.yidiandian.service;

import com.yidiandian.entity.ScenicSpotImages;
import com.yidiandian.vo.ScenicSpotInfoVO;
import com.yidiandian.vo.UserDynamicVO;

import java.util.List;

/**
 * 景点景区图片集合表(ScenicSpotImages)表服务接口
 *
 * @author makejava
 * @since 2020-10-15 17:12:26
 */
public interface ScenicSpotImagesService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ScenicSpotImages queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<ScenicSpotImages> queryAllByLimit(int offset, int limit);

    /**
     * 用户发布动态添加图片数据
     * @return 实例对象
     */
    int insertScenicSpotImages(ScenicSpotInfoVO vo, String userId, int resultOrder);

    /**
     * 修改数据
     *
     * @param scenicSpotImages 实例对象
     * @return 实例对象
     */
    ScenicSpotImages update(ScenicSpotImages scenicSpotImages);

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
     * @return
     */
    int publishDynamic(UserDynamicVO userDynamicVO,int scenicSpotInfoId);

    /**
     * 删除用户动态
     * @param vo
     * @return
     */
    int deleteUserDynamic(UserDynamicVO vo);
}