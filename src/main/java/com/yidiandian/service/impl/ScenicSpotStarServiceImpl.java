package com.yidiandian.service.impl;

import com.yidiandian.dao.ScenicSpotStarDao;
import com.yidiandian.entity.ScenicSpotStar;
import com.yidiandian.service.ScenicSpotStarService;
import com.yidiandian.support.Result;
import com.yidiandian.vo.ScenicSpotStarVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author 凤凰小哥哥
 * @date 2020-10-22
 */
@Slf4j
@Service
public class ScenicSpotStarServiceImpl implements ScenicSpotStarService {

    @Resource
    ScenicSpotStarDao scenicSpotStarDao;

    @Override
    public Result dynamicStar(ScenicSpotStarVO vo) {
        return scenicSpotStarDao.insert(structureScenicSpotStar(vo)) > 0 ? Result.success("操作成功") : Result.error("操作失败");
    }

    @Override
    public Result cancelDynamicStar(ScenicSpotStarVO vo) {
        return scenicSpotStarDao.cancelDynamicStar(vo.getScenicSpotInfoId(),vo.getUserId()) > 0 ? Result.success("操作成功") : Result.error("操作失败");
    }

    private ScenicSpotStar structureScenicSpotStar(ScenicSpotStarVO vo){
        ScenicSpotStar star = new ScenicSpotStar();
        BeanCopier beanCopier = BeanCopier.create(ScenicSpotStarVO.class,ScenicSpotStar.class,false);
        beanCopier.copy(vo,star,null);
        vo.setStar("0");
        return star;
    }
}
