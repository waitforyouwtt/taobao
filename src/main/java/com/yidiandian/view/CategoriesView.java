package com.yidiandian.view;

import lombok.Data;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/8/6 0:26
 * @Email: 15290810931@163.com
 */
@Data
public class CategoriesView {
    private Integer id;
    private String parentId;
    private String categoriesName;
    private String categoriesLinkUrl ;
}
