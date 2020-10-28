package com.yidiandian.page;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author 凤凰小哥哥
 * @date 2020-10-27
 */
@Data
public class PageRequest {

    @ApiModelProperty(value = "当前页码")
    private int pageNum;

    @ApiModelProperty(value = "每页数量")
    private int pageSize;

}
