package com.yidiandian.service.impl;

import com.yidiandian.entity.ScenicSpotImages;
import com.yidiandian.dao.ScenicSpotImagesDao;
import com.yidiandian.service.ScenicSpotImagesService;
import com.yidiandian.vo.ScenicSpotInfoVO;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 景点景区图片集合表(ScenicSpotImages)表服务实现类
 *
 * @author makejava
 * @since 2020-10-15 17:12:26
 */
@Service
public class ScenicSpotImagesServiceImpl implements ScenicSpotImagesService {
    @Resource
    private ScenicSpotImagesDao scenicSpotImagesDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public ScenicSpotImages queryById(Integer id) {
        return this.scenicSpotImagesDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<ScenicSpotImages> queryAllByLimit(int offset, int limit) {
        return this.scenicSpotImagesDao.queryAllByLimit(offset, limit);
    }

    /**
     * 用户发布动态添加图片数据
     *
     */
    @Override
    public int insertScenicSpotImages(ScenicSpotInfoVO vo, String userId, int resultOrder) {
        return CollectionUtils.isEmpty(structureScenicSpotImagesList(vo,userId,resultOrder)) ? 0 : scenicSpotImagesDao.batchInsertScenicSpotImages(structureScenicSpotImagesList(vo,userId,resultOrder));
    }

    private List<ScenicSpotImages> structureScenicSpotImagesList(ScenicSpotInfoVO vo, String userId, int resultOrder){
        if (CollectionUtils.isEmpty(vo.getImagesList())){
            return Collections.EMPTY_LIST;
        }
        List<ScenicSpotImages>  images = new ArrayList<>();
        vo.getImagesList().stream().forEach(o ->{
            ScenicSpotImages model = new ScenicSpotImages();
            model.setScenicSpotInfoId(resultOrder);
            model.setMainImage(o.getMainImage());
            model.setImage1(o.getImage1());
            model.setImage2(o.getImage2());
            model.setImage3(o.getImage3());
            model.setImage4(o.getImage4());
            model.setImage5(o.getImage5());
            model.setImage6(o.getImage6());
            model.setImage7(o.getImage7());
            model.setImage8(o.getImage8());
            model.setUserId(userId);
            images.add(model);
        });
        return images;
    }

    /**
     * 修改数据
     *
     * @param scenicSpotImages 实例对象
     * @return 实例对象
     */
    @Override
    public ScenicSpotImages update(ScenicSpotImages scenicSpotImages) {
        this.scenicSpotImagesDao.update(scenicSpotImages);
        return this.queryById(scenicSpotImages.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.scenicSpotImagesDao.deleteById(id) > 0;
    }
}