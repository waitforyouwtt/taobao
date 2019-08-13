package com.yidiandian;

import com.yidiandian.service.CategoriesService;
import com.yidiandian.view.CategoriesView;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

@Component
@Slf4j
public class CategoriesTests extends TaobaoApplicationTests{

	@Autowired
	CategoriesService categoriesService;

	@Test
	public void saveCategories() {
		CategoriesView view = new CategoriesView();
		view.setParentId("0");
		view.setCategoriesName("服装内衣");
		view.setCategoriesLinkUrl("http://clothing.underwear.url.com");
		categoriesService.saveCategories(view);
	}
	@Test
	public void deleteCategories() {
		CategoriesView view = new CategoriesView();
		view.setId(100);
		categoriesService.deleteCategories(view);
	}

	@Test
	public void updateCategories() {
		CategoriesView view = new CategoriesView();
		view.setId(1);
		view.setCategoriesName("衣服");
		categoriesService.updateCategories(view);
	}

}
