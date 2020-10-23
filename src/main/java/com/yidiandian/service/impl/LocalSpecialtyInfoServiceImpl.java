package com.yidiandian.service.impl;

import com.yidiandian.dao.LocalSpecialtyInfoDao;
import com.yidiandian.entity.LocalSpecialtyInfo;
import com.yidiandian.service.LocalSpecialtyInfoService;
import com.yidiandian.support.Result;
import com.yidiandian.utils.GenerateCodeUtils;
import com.yidiandian.vo.LocalSpecialtyInfoVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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
        return localSpecialtyInfoDao.insert(structureLocalSpecialtyInfo(vo)) > 0 ? Result.success() : Result.error();
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
}
