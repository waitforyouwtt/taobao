package com.yidiandian.page;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author 凤凰小哥哥
 * @date 2020-10-27
 */
@Data
public class PageResult {

    @ApiModelProperty(value = "当前页码")
    private int pageNum;

    @ApiModelProperty(value = "每页数量")
    private int pageSize;

    @ApiModelProperty(value = "记录总数")
    private long totalSize;

    @ApiModelProperty(value = "页码总数")
    private int totalPages;

    @ApiModelProperty(value = "数据模型")
    private List<?> content;
}
