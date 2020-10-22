package com.yidiandian.service;

import com.yidiandian.support.Result;
import com.yidiandian.vo.ScenicSpotCommentVO;

/**
 * @author 凤凰小哥哥
 * @date 2020-10-22
 */
public interface ScenicSpotCommentService {

    /**
     * 用户对浏览的动态评论
     * @param vo
     * @return
     */
    Result dynamicComment(ScenicSpotCommentVO vo);

    /**
     * 用户对浏览的动态删除评论
     * @param vo
     * @return
     */
    Result cancelDynamicComment(ScenicSpotCommentVO vo);
}
