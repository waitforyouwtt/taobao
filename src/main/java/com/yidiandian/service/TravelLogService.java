package com.yidiandian.service;

import com.yidiandian.entity.TravelLog;
import com.yidiandian.support.Result;

/**
 * @author 凤凰小哥哥
 * @date 2020-10-20
 */
public interface TravelLogService {

    /**
     * 保存平台日志
     * @return
     */
    Result saveTravelLog(TravelLog log);

    /**
     * 根据验证码查询用户信息
     * @param code
     * @return
     */
    TravelLog findLogByCode(String code);
}
