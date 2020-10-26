package com.yidiandian.service.impl;

import com.yidiandian.dao.LocalSpecialtyInfoDao;
import com.yidiandian.entity.LocalSpecialtyInfo;
import com.yidiandian.service.LocalSpecialtyInfoService;
import com.yidiandian.support.Result;
import com.yidiandian.utils.GenerateCodeUtils;
import com.yidiandian.utils.UploadUtils;
import com.yidiandian.vo.LocalSpecialtyInfoVO;
import com.yidiandian.vo.UserDynamicVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 凤凰小哥哥
 * @date 2020-10-23
 */
@Slf4j
@Service
public class LocalSpecialtyInfoServiceImpl implements LocalSpecialtyInfoService {
    @Resource
    LocalSpecialtyInfoDao localSpecialtyInfoDao;

    @Override
    public Result saveLocalSpecialtyInfo(LocalSpecialtyInfoVO vo) {
        String uniqueCode = GenerateCodeUtils.generatePlatformUniqueCode(vo.getProvinceCode(), vo.getCityCode());
        vo.setProductCode(uniqueCode);
        String image = uploadServer(vo).get("mainPath").get(0);
        vo.setProductImage(image);
        return localSpecialtyInfoDao.insert(structureLocalSpecialtyInfo(vo)) > 0 ? Result.success("操作成功") : Result.error("操作失败");
    }

    @Override
    public Result findLocalSpecialtyInfoGroup() {

        return null;
    }

    private LocalSpecialtyInfo structureLocalSpecialtyInfo(LocalSpecialtyInfoVO vo){
        LocalSpecialtyInfo info = new LocalSpecialtyInfo();
        BeanCopier beanCopier = BeanCopier.create(LocalSpecialtyInfoVO.class, LocalSpecialtyInfo.class,false);
        beanCopier.copy(vo,info,null);
        return info;
    }

    private Map<String, List<String>> uploadServer(LocalSpecialtyInfoVO vo){
        Map<String,List<String>> hashMap = new HashMap<>(16);
        if (vo.getMain() == null){
            return hashMap;
        }
        hashMap.put("mainPath", Arrays.asList(UploadUtils.upload(vo.getMain())));
        return hashMap;
    }
}
