package com.yidiandian.service;


import com.yidiandian.support.Result;
import com.yidiandian.vo.LocalSpecialtyInfoVO;

/**
 * @author 凤凰小哥哥
 * @date 2020-10-22
 */
public interface LocalSpecialtyInfoService {

    /**
     *
     * @param vo
     * @return
     */
   Result saveLocalSpecialtyInfo(LocalSpecialtyInfoVO vo);

    /**
     * 查询当地特产且根据名字进行分组
     * @return
     */
   Result findLocalSpecialtyInfoGroup();
}
