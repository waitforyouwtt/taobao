package com.yidiandian.vo;

import com.yidiandian.entity.LocalSpecialtyInfo;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author 凤凰小哥哥
 * @date 2020-10-22
 */
@Data
public class LocalSpecialtyInfoVO extends LocalSpecialtyInfo {

    /**
     * 主图地址
     */
    MultipartFile main;
}
