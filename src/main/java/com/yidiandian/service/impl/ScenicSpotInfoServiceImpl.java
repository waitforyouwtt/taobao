package com.yidiandian.service.impl;

import cn.hutool.json.JSONUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yidiandian.dao.ScenicSpotImagesDao;
import com.yidiandian.entity.ScenicSpotImages;
import com.yidiandian.entity.ScenicSpotInfo;
import com.yidiandian.dao.ScenicSpotInfoDao;
import com.yidiandian.page.PageRequest;
import com.yidiandian.page.PageResult;
import com.yidiandian.page.PageUtils;
import com.yidiandian.service.ScenicSpotDetailsService;
import com.yidiandian.service.ScenicSpotImagesService;
import com.yidiandian.service.ScenicSpotInfoService;
import com.yidiandian.support.Result;
import com.yidiandian.utils.GenerateCodeUtils;
import com.yidiandian.utils.UploadUtils;
import com.yidiandian.view.ScenicSpotInfoView;
import com.yidiandian.view.ScenicSpotView;
import com.yidiandian.vo.QueryScenicSpotVO;
import com.yidiandian.vo.ScenicSpotInfoVO;
import com.yidiandian.vo.UserDynamicVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.*;

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

    @Resource
    private ScenicSpotImagesDao scenicSpotImagesDao;

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
     *
     * 后台发布景点景区动态
     * @param scenicSpotInfoVO 实例对象
     * @return 实例对象
     */
    @Override
    public Result publishMessage(ScenicSpotInfoVO scenicSpotInfoVO) {
        log.info("后台发布景点景区动态请求参数：{}", JSONUtil.parseObj(scenicSpotInfoVO));
        String userId = "McJLCxSF";
        ScenicSpotInfo scenicSpotInfo = structureScenicSpotInfo(scenicSpotInfoVO, userId);
        //platform_unique_code
        //校验：主表不能添加重复的数据，判断字段：scenicSpotName
        ScenicSpotInfo allByScenicSpotName = this.scenicSpotInfoDao.findAllByScenicSpotName(scenicSpotInfoVO.getScenicSpotName());
        if (allByScenicSpotName != null){
            return Result.error("该景点在平台中已存在，请勿重复添加");
        }

        int resultOrder = this.scenicSpotInfoDao.insert(scenicSpotInfo);
        if (resultOrder > 0){
            scenicSpotInfoVO.setMainImage(uploadServer(scenicSpotInfoVO).get("mainPath").get(0));
            scenicSpotDetailsService.insertScenicSpotDetails(scenicSpotInfoVO, userId, scenicSpotInfo.getId());
            //上传服务器
            List<String> images = uploadServer(scenicSpotInfoVO).get("imagesPath");
            if (CollectionUtils.isEmpty(images)){
                log.info("没有上传图片......");
            }else{
                structureScenicSpotInfoUpload(scenicSpotInfoVO,images, scenicSpotInfoVO.getUserId(),scenicSpotInfo.getId());
                scenicSpotImagesService.insertScenicSpotImages(scenicSpotInfoVO, userId, scenicSpotInfo.getId());
            }
        }
        return resultOrder > 0 ? Result.success("操作成功") : Result.error("操作失败");
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


    private Map<String,List<String>> uploadServer(ScenicSpotInfoVO scenicSpotInfoVO){
        Map<String,List<String>> hashMap = new HashMap<>(16);
        if (scenicSpotInfoVO.getMain() == null && scenicSpotInfoVO.getFiles() == null){
            return hashMap;
        }

        if (scenicSpotInfoVO.getMain() != null){
            hashMap.put("mainPath",Arrays.asList(UploadUtils.upload(scenicSpotInfoVO.getMain())));
        }

        if (scenicSpotInfoVO.getFiles() != null){
            List<String> filePaths = new ArrayList<>();
            for(MultipartFile file : scenicSpotInfoVO.getFiles()){
                String filePath =  UploadUtils.upload(file);
                filePaths.add(filePath);
            }
            hashMap.put("imagesPath",filePaths);
        }
        return hashMap;
    }

    private ScenicSpotInfo  structureScenicSpotInfo(ScenicSpotInfoVO vo,String userId){
        ScenicSpotInfo model = new ScenicSpotInfo();
        BeanCopier beanCopier = BeanCopier.create(ScenicSpotInfoVO.class,ScenicSpotInfo.class,false);
        beanCopier.copy(vo,model,null);
        String uniqueCode = GenerateCodeUtils.generatePlatformUniqueCode(vo.getProvinceCode(), vo.getCityCode());
        model.setPlatformUniqueCode(uniqueCode);
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
        log.info("查看用户发表的动态请求参数：{}",JSONUtil.parseObj(spotVO));

        return null;
    }

    @Override
    public Result findSpotInfoPage(PageRequest pageRequest) {
       // scenicSpotInfoDao.findSpotInfoPage();

        PageResult pageResult = PageUtils.getPageResult(pageRequest, getPageInfo(pageRequest));

        return Result.success(pageResult);
    }

    /**
     * 调用分页插件完成分页
     * @param pageRequest
     * @return
     */
    private PageInfo<ScenicSpotImages> getPageInfo(PageRequest pageRequest) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);

        ScenicSpotImages image = new ScenicSpotImages ();
        List<ScenicSpotImages> images = scenicSpotImagesDao.queryAll(image);

        return new PageInfo<ScenicSpotImages>(images);
    }

    @Override
    public Result<List<ScenicSpotInfo>> findSpotInfoLikeTitle(String title) {
        log.info("根据标题模糊查询请求参数：{}",title);
        List<ScenicSpotInfo> spotInfoLikeTitle = scenicSpotInfoDao.findSpotInfoLikeTitle(title);
        return Result.success(spotInfoLikeTitle);
    }

    @Override
    public int publishDynamic(UserDynamicVO userDynamicVO) {
        ScenicSpotInfo scenicSpotInfo = structurePublishDynamicModel(userDynamicVO);
        return scenicSpotInfoDao.insert(scenicSpotInfo) > 0 ? scenicSpotInfo.getId() : 0;
    }

    @Override
    public Result queryScenicSpotGroup(QueryScenicSpotVO vo) {
        List<ScenicSpotView> scenicSpotViews = scenicSpotInfoDao.queryScenicSpotGroup(vo);
        return Result.success(scenicSpotViews);
    }

    @Override
    public int deleteUserDynamic(UserDynamicVO vo) {
        return scenicSpotInfoDao.deleteUserDynamic(vo.getScenicSpotId(),vo.getUserId());
    }

    private ScenicSpotInfo structurePublishDynamicModel(UserDynamicVO vo){
        ScenicSpotInfo info = new ScenicSpotInfo();
        String uniqueCode = GenerateCodeUtils.generatePlatformUniqueCode(vo.getProvinceCode(), vo.getCityCode());
        info.setPlatformUniqueCode(uniqueCode);
        info.setUserId(vo.getUserId());
        info.setScenicSpotName(vo.getTitle());
        info.setScenicSpotDescribe(vo.getTitle());
        info.setStatus(0);
        info.setPulishStatus(0);
        return info;
    }
}