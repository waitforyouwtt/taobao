package com.yidiandian.service;

import com.yidiandian.entity.Categories;
import com.yidiandian.support.Result;
import com.yidiandian.view.CategoriesView;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/8/6 0:18
 * @Email: 15290810931@163.com
 */
public interface CategoriesService {
    /**
     * 添加类型
     * @param categoriesView
     * @return
     */
    Result<Categories> saveCategories(CategoriesView categoriesView);
    /**
     * 删除类型
     * @param categoriesView
     * @return
     */
    Result<Integer> deleteCategories(CategoriesView categoriesView);

    /**
     * 修改
     * @param categoriesView
     * @return
     */
    Result<Categories> updateCategories(CategoriesView categoriesView);
}
