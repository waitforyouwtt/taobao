package com.yidiandian.service.impl;

import com.yidiandian.dao.ScenicSpotCommentDao;
import com.yidiandian.entity.ScenicSpotComment;
import com.yidiandian.service.ScenicSpotCommentService;
import com.yidiandian.support.Result;
import com.yidiandian.vo.ScenicSpotCommentVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author 凤凰小哥哥
 * @date 2020-10-22
 */
@Service
@Slf4j
public class ScenicSpotCommentServiceImpl implements ScenicSpotCommentService {

    @Resource
    ScenicSpotCommentDao scenicSpotCommentDao;

    @Override
    public Result dynamicComment(ScenicSpotCommentVO vo) {
        return scenicSpotCommentDao.insert(structureScenicSpotComment(vo)) > 0 ? Result.success("操作成功") : Result.error("操作失败");
    }

    @Override
    public Result cancelDynamicComment(ScenicSpotCommentVO vo) {
        return scenicSpotCommentDao.deleteByUserIdAndCommentId(vo.getId(),vo.getUserId()) > 0 ? Result.success("操作成功") : Result.error("操作失败");
    }

    private ScenicSpotComment structureScenicSpotComment(ScenicSpotCommentVO vo){
        ScenicSpotComment info = new ScenicSpotComment();
        BeanCopier beanCopier = BeanCopier.create(ScenicSpotCommentVO.class,ScenicSpotComment.class,false);
        beanCopier.copy(vo,info,null);
        return info;
    }


}
