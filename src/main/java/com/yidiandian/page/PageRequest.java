package com.yidiandian.page;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author 凤凰小哥哥
 * @date 2020-10-27
 */
public class PageRequest {

    @ApiModelProperty(value = "当前页码")
    private Integer pageNum;

    @ApiModelProperty(value = "每页数量")
    private Integer pageSize;

    public int getPageNum() {
        if (pageNum == null || pageNum == 0){
            this.pageNum = 1;
        }
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        if (pageSize == null || pageNum == 0){
            this.pageSize = 10;
        }
            return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
