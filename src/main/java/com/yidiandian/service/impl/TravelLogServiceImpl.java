package com.yidiandian.service.impl;

import com.yidiandian.dao.TravelLogDao;
import com.yidiandian.entity.TravelLog;
import com.yidiandian.service.TravelLogService;
import com.yidiandian.support.Result;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author 凤凰小哥哥
 * @date 2020-10-20
 */
@Slf4j
@Service
public class TravelLogServiceImpl implements TravelLogService {

    @Resource
    TravelLogDao travelLogDao;

    @Override
    public Result saveTravelLog(TravelLog log) {
        return Result.success(travelLogDao.insert(log));
    }

    @Override
    public TravelLog findLogByCode(String code) {
        TravelLog log = new TravelLog();
        log.setCode(code);
        if (CollectionUtils.isEmpty(travelLogDao.queryAll(log))){
            return null;
        }
        return travelLogDao.queryAll(log).get(0);
    }
}
