package com.yidiandian.service.impl;

import com.yidiandian.entity.ScenicSpotDetails;
import com.yidiandian.dao.ScenicSpotDetailsDao;
import com.yidiandian.entity.ScenicSpotInfo;
import com.yidiandian.service.ScenicSpotDetailsService;
import com.yidiandian.vo.ScenicSpotInfoVO;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 景点景区详情表(ScenicSpotDetails)表服务实现类
 *
 * @author makejava
 * @since 2020-10-15 17:09:50
 */
@Service("scenicSpotDetailsService")
public class ScenicSpotDetailsServiceImpl implements ScenicSpotDetailsService {
    @Resource
    private ScenicSpotDetailsDao scenicSpotDetailsDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public ScenicSpotDetails queryById(Integer id) {
        return this.scenicSpotDetailsDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<ScenicSpotDetails> queryAllByLimit(int offset, int limit) {
        return this.scenicSpotDetailsDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param vo 实例对象
     * @return 实例对象
     */
    @Override
    public int insertScenicSpotDetails(ScenicSpotInfoVO vo, String userId, int resultOrder) {
        return this.scenicSpotDetailsDao.insert(structureScenicSpotDetails(vo,userId,resultOrder));
    }

    private ScenicSpotDetails structureScenicSpotDetails(ScenicSpotInfoVO vo, String userId,int resultOrder){
        ScenicSpotDetails model = new ScenicSpotDetails();
        BeanCopier beanCopier = BeanCopier.create(ScenicSpotInfoVO.class,ScenicSpotDetails.class,false);
        beanCopier.copy(vo,model,null);
        model.setUserId(userId);
        model.setScenicSpotInfoId(resultOrder);
        return model;
    }

    /**
     * 修改数据
     *
     * @param scenicSpotDetails 实例对象
     * @return 实例对象
     */
    @Override
    public ScenicSpotDetails update(ScenicSpotDetails scenicSpotDetails) {
        this.scenicSpotDetailsDao.update(scenicSpotDetails);
        return this.queryById(scenicSpotDetails.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.scenicSpotDetailsDao.deleteById(id) > 0;
    }
}