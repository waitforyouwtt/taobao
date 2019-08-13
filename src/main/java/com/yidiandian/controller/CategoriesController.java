package com.yidiandian.controller;

import com.yidiandian.entity.Categories;
import com.yidiandian.service.CategoriesService;
import com.yidiandian.view.CategoriesView;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/8/5 23:42
 * @Email: 15290810931@163.com
 * 类目控制层
 */
@Controller
@Slf4j
public class CategoriesController {

    @Autowired
    CategoriesService categoriesService;

    @PostMapping("/saveCategories")
    @ResponseBody
    public ResponseEntity saveCategories(@RequestBody CategoriesView params) {
        return new ResponseEntity(categoriesService.saveCategories(params), HttpStatus.OK);
    }

    @PostMapping("/deleteCategories")
    @ResponseBody
    public ResponseEntity deleteCategories(@RequestBody CategoriesView params) {
        return new ResponseEntity(categoriesService.deleteCategories(params), HttpStatus.OK);
    }


}
