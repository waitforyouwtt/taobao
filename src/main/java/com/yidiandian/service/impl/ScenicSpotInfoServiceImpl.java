package com.yidiandian.service.impl;

import cn.hutool.json.JSONUtil;
import com.yidiandian.entity.ScenicSpotImages;
import com.yidiandian.entity.ScenicSpotInfo;
import com.yidiandian.dao.ScenicSpotInfoDao;
import com.yidiandian.service.ScenicSpotDetailsService;
import com.yidiandian.service.ScenicSpotImagesService;
import com.yidiandian.service.ScenicSpotInfoService;
import com.yidiandian.utils.UploadUtils;
import com.yidiandian.view.ScenicSpotInfoView;
import com.yidiandian.vo.QueryScenicSpotVO;
import com.yidiandian.vo.ScenicSpotInfoVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
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
            String filePath =  UploadUtils.upload(scenicSpotInfoVO.getMain());
            scenicSpotInfoVO.setMainImage(filePath);
            int insertScenicSpotDetails = scenicSpotDetailsService.insertScenicSpotDetails(scenicSpotInfoVO, userId, scenicSpotInfo.getId());
            //上传服务器
            List<String> images = uploadServer(scenicSpotInfoVO);
            if (CollectionUtils.isEmpty(images)){
                log.info("没有上传图片......");
            }else{
                structureScenicSpotInfoUpload(scenicSpotInfoVO,images, scenicSpotInfoVO.getUserId(),scenicSpotInfo.getId());
                int insertScenicSpotImages = scenicSpotImagesService.insertScenicSpotImages(scenicSpotInfoVO, userId, scenicSpotInfo.getId());
            }
        }
        return resultOrder > 0 ? 1 : 0;
    }

    private void structureScenicSpotInfoUpload(ScenicSpotInfoVO vo, List<String> images, String userId,int id){
        List<ScenicSpotImages> imagesList = new ArrayList<>();
        images.stream().forEach( image ->{
            ScenicSpotImages entity = new ScenicSpotImages();
            entity.setScenicSpotInfoId(id);
            entity.setImage(image);
            entity.setUserId(userId);
            entity.setCreateTime(new Date());
            entity.setUpdateTime(new Date());
            imagesList.add(entity);
        });
        vo.setImagesList(imagesList);
    }

    private List<String> uploadServer(ScenicSpotInfoVO scenicSpotInfoVO){
        List<String> filePaths = new ArrayList<>();
        if (scenicSpotInfoVO.getFiles() == null){
            log.info("没有图片需要上传... ...");
            return new ArrayList<>();
        }
        for(MultipartFile file : scenicSpotInfoVO.getFiles()){
          String filePath =  UploadUtils.upload(file);
          filePaths.add(filePath);
        }
        return filePaths;
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

    @Override
    public List<ScenicSpotInfoView> findSpotInfo(QueryScenicSpotVO spotVO) {
        return null;
    }
}