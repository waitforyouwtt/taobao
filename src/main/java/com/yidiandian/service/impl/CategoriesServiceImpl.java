package com.yidiandian.service.impl;

import com.yidiandian.entity.Categories;
import com.yidiandian.enums.CategoriesOperationTypeEnum;
import com.yidiandian.mapper.CategoriesMapper;
import com.yidiandian.service.CategoriesService;
import com.yidiandian.utils.MyException;
import com.yidiandian.utils.Result;
import com.yidiandian.view.CategoriesView;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/8/6 0:30
 * @Email: 15290810931@163.com
 */
@Service
@Slf4j
public class CategoriesServiceImpl implements CategoriesService {

    @Autowired
    CategoriesMapper categoriesMapper;
    /**
     * @param categoriesView
     * @return
     */
    @Override
    public Result<Categories> saveCategories(CategoriesView categoriesView) {
        Categories queryCategories = queryCategories(categoriesView);
        if (queryCategories != null){
            throw new MyException("已存在该记录");
        }
        Categories vo = new Categories();
        BeanCopier beanCopier = BeanCopier.create(CategoriesView.class,Categories.class,false);
        beanCopier.copy(categoriesView,vo,null);
        return Result.success(categoriesMapper.save(vo));
    }

    /**
     * 删除类型
     *
     * @param categoriesView
     * @return
     */
    @Override
    public Result<Integer> deleteCategories(CategoriesView categoriesView) {
        Categories queryCategories = queryCategories(categoriesView);
        if (queryCategories == null){
            throw new MyException("不存在该记录");
        }
        try{
            categoriesMapper.deleteById(categoriesView.getId());
        }catch (Exception e){
            log.info("删除类目异常：{}",e.getMessage());
            return Result.error();
        }
        return  Result.success();
    }

    /**
     * 修改
     *
     * @param categoriesView
     * @return
     */
    @Override
    public Result<Categories> updateCategories(CategoriesView categoriesView) {
        Optional<Categories> optionalCategories = categoriesMapper.findById(categoriesView.getId());
        if (!optionalCategories.isPresent()){
            throw new MyException("不存在该记录");
        }
        Categories queryCategories = optionalCategories.get();
        queryCategories.setCategoriesName(categoriesView.getCategoriesName());
        Categories save = categoriesMapper.save(queryCategories);
        return Result.success(save);
    }
    private Categories queryCategories(CategoriesView categoriesView) {
        if (categoriesView == null) {
            throw new MyException(300, "参数缺失");
        }
        Optional<Categories> optionalCategories = categoriesMapper.findByCategoriesNameAndParentId(categoriesView.getCategoriesName(), categoriesView.getParentId());
        if (optionalCategories.isPresent()) {
            return optionalCategories.get();
        } else {
            return null;
        }
    }


}
