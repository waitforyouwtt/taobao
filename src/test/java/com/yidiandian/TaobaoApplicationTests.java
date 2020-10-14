package com.yidiandian;

import com.yidiandian.utils.RedisUtils;
import org.assertj.core.util.DateUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaobaoApplicationTests {

	@Autowired
	RedisUtils redisUtils;

	@Test
	public void redisGetTest() {
		Object value = redisUtils.get("hello");
		System.out.println("得到的redis value:"+value);
	}

	@Test
	public void contextLoads() {
		boolean flag = redisUtils.set("hello","word");
		System.out.println("得到的redis value:"+flag);

	}

}
