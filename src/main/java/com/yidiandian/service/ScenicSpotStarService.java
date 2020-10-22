package com.yidiandian.service;

import com.yidiandian.support.Result;
import com.yidiandian.vo.ScenicSpotStarVO;

/**
 * @author 凤凰小哥哥
 * @date 2020-10-22
 */
public interface ScenicSpotStarService {

    /**
     * 用户对浏览的某条动态点赞
     * @param vo
     * @return
     */
    Result dynamicStar(ScenicSpotStarVO vo);

    /**
     * 用户对浏览的动态取消点赞
     * @param vo
     * @return
     */
    Result cancelDynamicStar(ScenicSpotStarVO vo);
}
