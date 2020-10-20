package com.yidiandian.aspect;

import com.yidiandian.entity.TravelLog;
import com.yidiandian.enums.LogTypeEnum;
import com.yidiandian.service.TravelLogService;
import com.yidiandian.vo.UserInfoVO;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Date;

/**
 * @author 凤凰小哥哥
 * @date 2020-10-20
 */
@Component
@Aspect
@Order(2)
@Slf4j
public class LogAspect {

    private final static String SAVE_USER_DETAILS_METHOD = "saveUserDetails";

    @Autowired
    TravelLogService travelLogService;

    @Around(value = "@annotation(LogAnnotation)")
    public Object interceptUpdatePrice(ProceedingJoinPoint pjp) {
        Object result = new Object();
        Method targetMethod = ((MethodSignature) (pjp.getSignature())).getMethod();
        String methodName = targetMethod.getName();
        Object[] args = pjp.getArgs();

        try{
            result = pjp.proceed(args);
            actionMthod(methodName, args, result);
        }catch (Throwable throwable){
            throwable.getMessage();
        }
        return result;
    }

    private void actionMthod(String methodName, Object[] args, Object ret) {
        switch(methodName){
            case SAVE_USER_DETAILS_METHOD :
                UserInfoVO info = (UserInfoVO) args[0];
                String userId   = (String) args[1];
                saveTravelLog(info,userId);
                break;
/*            case SAVE_LOGIN_MESSAGE_METHOD :
                String mobile = args[2].toString();
                String ip = args[3].toString();
                Integer messageType = 3;
                saveSendMessageRecord(ip,mobile,messageType);
                break;
            case MESSAGE_REGISTER_METHOD :
                String registerPhone = args[2].toString();
                String registerIp = args[3].toString();
                Integer registerMessageType = 1;
                saveSendMessageRecord(registerIp,registerPhone,registerMessageType);
                break;
            case MESSAGE_FIND_PWD_METHOD :
                String  messageFindPwdPhone = args[2].toString();
                String  messageFindPwdIp = args[3].toString();
                Integer messageFindPwdType = 2;
                saveSendMessageRecord(messageFindPwdIp,messageFindPwdPhone,messageFindPwdType);
                break;
            case MODIFY_MOBILE_MESSAGE_METHOD :
                String  modifyPhone = args[2].toString();
                String  modifyIp = args[3].toString();
                Integer modifyType = 4;
                saveSendMessageRecord(modifyIp,modifyPhone,modifyType);
                break;
            case REGISTER_MERCHANT_SENDMESSAGE_METHOD :
                String  merchantResgisterPhone = args[2].toString();
                String  merchantResgisterIp = args[3].toString();
                Integer merchantResgisterType = 5;
                saveSendMessageRecord(merchantResgisterIp,merchantResgisterPhone,merchantResgisterType);
                break;*/
            default:
                break;
        }
    }

    /**
     * 通过aop切面保存平台邮件日志记录
     * @param info
     */
    private void saveTravelLog(UserInfoVO info, String userId){
        TravelLog log = new TravelLog();
        log.setUserId(userId);
        log.setCode(info.getVerifyCode());
        log.setLogType(LogTypeEnum.EMAIL_ACTIVETION.getCode());
        log.setCreateTime(new Date());
        log.setUpdateTime(new Date());

        travelLogService.saveTravelLog(log);
    }

    /**
     * 通过aop 切面保存短信发送统计日志记录
     */
    /*public void saveSendMessageRecord(String ip,String mobile,Integer messageType){
        messageRecordService.insertMessageRecordByType(ip, mobile, messageType);
    }*/
}
