package com.yidiandian;


import cn.hutool.json.JSONUtil;
import com.yidiandian.service.DistrictService;
import com.yidiandian.view.DistrictView;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class DistrictTests extends TaobaoApplicationTests{

	@Autowired
	DistrictService districtService;

	@Test
	public void queryDistrictSortTest(){
		List<DistrictView> bbsAreaByUPid = districtService.findBbsAreaByUPid(0);
		log.info("得到的地点地区数据是：{}", JSONUtil.parseArray(bbsAreaByUPid));
	}


}
