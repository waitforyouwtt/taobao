package com.yidiandian.mapper;

import com.yidiandian.entity.Categories;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/8/6 0:35
 * @Email: 15290810931@163.com
 */
public interface CategoriesMapper extends JpaRepository<Categories,Integer>{

    Optional<Categories> findByCategoriesNameAndParentId(String categoriesName,String parentId);
}
