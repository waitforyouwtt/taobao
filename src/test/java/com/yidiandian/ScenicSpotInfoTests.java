package com.yidiandian;


import cn.hutool.json.JSONUtil;
import com.yidiandian.entity.ScenicSpotInfo;
import com.yidiandian.service.DistrictService;
import com.yidiandian.service.ScenicSpotInfoService;
import com.yidiandian.support.Result;
import com.yidiandian.view.DistrictView;
import com.yidiandian.view.ScenicSpotInfoView;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class ScenicSpotInfoTests extends TaobaoApplicationTests{

	@Autowired
	ScenicSpotInfoService scenicSpotInfoService;

	@Test
	public void queryDistrictSortTest(){
		String title = "上海外滩";
		Result<List<ScenicSpotInfo>> findSpotInfoLikeTitle = scenicSpotInfoService.findSpotInfoLikeTitle(title);
		log.info("得到的数据是：{}", JSONUtil.parseArray(findSpotInfoLikeTitle.getData()));
	}


}
