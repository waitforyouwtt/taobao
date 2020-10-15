package com.yidiandian.service.impl;

import cn.hutool.json.JSONUtil;
import com.oracle.tools.packager.Log;
import com.yidiandian.entity.ScenicSpotInfo;
import com.yidiandian.dao.ScenicSpotInfoDao;
import com.yidiandian.service.ScenicSpotDetailsService;
import com.yidiandian.service.ScenicSpotImagesService;
import com.yidiandian.service.ScenicSpotInfoService;
import com.yidiandian.vo.ScenicSpotInfoVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 景点景区表(ScenicSpotInfo)表服务实现类
 *
 * @author makejava
 * @since 2020-10-15 17:11:58
 */
@Slf4j
@Service
public class ScenicSpotInfoServiceImpl implements ScenicSpotInfoService {

    @Resource
    private ScenicSpotInfoDao scenicSpotInfoDao;

    @Autowired
    private ScenicSpotDetailsService scenicSpotDetailsService;

    @Autowired
    private ScenicSpotImagesService scenicSpotImagesService;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public ScenicSpotInfo queryById(Integer id) {
        return this.scenicSpotInfoDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<ScenicSpotInfo> queryAllByLimit(int offset, int limit) {
        return this.scenicSpotInfoDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param scenicSpotInfoVO 实例对象
     * @return 实例对象
     */
    @Override
    public int publishMessage(ScenicSpotInfoVO scenicSpotInfoVO) {
        log.info("用户发布动态请求参数：{}", JSONUtil.parseObj(scenicSpotInfoVO));
        String userId = "McJLCxSF";
        ScenicSpotInfo scenicSpotInfo = structureScenicSpotInfo(scenicSpotInfoVO, userId);
        int resultOrder = this.scenicSpotInfoDao.insert(scenicSpotInfo);
        if (resultOrder > 0){
            int insertScenicSpotDetails = scenicSpotDetailsService.insertScenicSpotDetails(scenicSpotInfoVO, userId, scenicSpotInfo.getId());
            int insertScenicSpotImages = scenicSpotImagesService.insertScenicSpotImages(scenicSpotInfoVO, userId, scenicSpotInfo.getId());
        }
        return resultOrder > 0 ? 1 : 0;
    }

    private ScenicSpotInfo  structureScenicSpotInfo(ScenicSpotInfoVO vo,String userId){
        ScenicSpotInfo model = new ScenicSpotInfo();
        BeanCopier beanCopier = BeanCopier.create(ScenicSpotInfoVO.class,ScenicSpotInfo.class,false);
        beanCopier.copy(vo,model,null);
        model.setUserId(userId);
        model.setStatus(0);
        model.setPulishStatus(0);
        return model;
    }

    /**
     * 修改数据
     *
     * @param scenicSpotInfo 实例对象
     * @return 实例对象
     */
    @Override
    public ScenicSpotInfo update(ScenicSpotInfo scenicSpotInfo) {
        this.scenicSpotInfoDao.update(scenicSpotInfo);
        return this.queryById(scenicSpotInfo.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.scenicSpotInfoDao.deleteById(id) > 0;
    }
}