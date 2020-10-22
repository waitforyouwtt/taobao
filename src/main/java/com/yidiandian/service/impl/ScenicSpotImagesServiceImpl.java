package com.yidiandian.service.impl;

import com.yidiandian.entity.ScenicSpotImages;
import com.yidiandian.dao.ScenicSpotImagesDao;
import com.yidiandian.service.ScenicSpotImagesService;
import com.yidiandian.utils.UploadUtils;
import com.yidiandian.vo.ScenicSpotInfoVO;
import com.yidiandian.vo.UserDynamicVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.*;

/**
 * 景点景区图片集合表(ScenicSpotImages)表服务实现类
 *
 * @author makejava
 * @since 2020-10-15 17:12:26
 */
@Service
@Slf4j
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
            model.setImage(o.getImage());
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

    @Override
    public int publishDynamic(UserDynamicVO userDynamicVO,int scenicSpotInfoId) {
        List<String> images = uploadServer(userDynamicVO).get("imagesPath");
        if (CollectionUtils.isEmpty(images)){
            log.info("没有上传图片......");
            return 0;
        }else{
            List<ScenicSpotImages> imagesList = structurePublishDynamicModel(userDynamicVO, images, scenicSpotInfoId);
            return scenicSpotImagesDao.batchInsertScenicSpotImages(imagesList);
        }
    }

    @Override
    public int deleteUserDynamic(UserDynamicVO vo) {
        return scenicSpotImagesDao.deleteUserDynamic(vo.getScenicSpotId(),vo.getUserId());
    }

    private List<ScenicSpotImages> structurePublishDynamicModel(UserDynamicVO vo,List<String> images, int resultOrder){
        if (CollectionUtils.isEmpty(images)){
            return Collections.EMPTY_LIST;
        }
        List<ScenicSpotImages>  imagesList = new ArrayList<>();
        images.stream().forEach(image ->{
            ScenicSpotImages model = new ScenicSpotImages();
            model.setScenicSpotInfoId(resultOrder);
            model.setImage(image);
            model.setUserId(vo.getUserId());
            model.setCreateTime(new Date());
            model.setUpdateTime(new Date());
            imagesList.add(model);
        });
        return imagesList;
    }

    private Map<String,List<String>> uploadServer(UserDynamicVO vo){
        Map<String,List<String>> hashMap = new HashMap<>(16);
        if (vo.getFiles() == null || vo.getFiles().length ==0 ){
            return hashMap;
        }
        List<String> filePaths = new ArrayList<>();
        for(MultipartFile file : vo.getFiles()){
            String filePath =  UploadUtils.upload(file);
            filePaths.add(filePath);
        }
        hashMap.put("imagesPath", filePaths);
        return hashMap;
    }


}