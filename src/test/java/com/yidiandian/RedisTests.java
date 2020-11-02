package com.yidiandian;

import com.yidiandian.utils.RedisUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

@Component
@Slf4j
public class RedisTests extends TaobaoApplicationTests{

	@Autowired
	RedisUtils redisUtils;

	@Test
	public void redisCloudSetTest() {
		boolean flag = redisUtils.set("hello","word");
		System.out.println("得到的redis value:"+flag);

	}

	@Test
	public void redisCloudGetTest() {
		Object value = redisUtils.get("hello");
		System.out.println("得到的redis value:"+value);
	}

	@Test
	public void redisLoalSetTest2() {
		Object value = redisUtils.set("user_session","huangwenhao is xiaosegou");
		System.out.println("赋值local redis value:"+value);
	}

	@Test
	public void redisLocalGetTest() {
		Object value = redisUtils.get("user_session");
		System.out.println("得到的redis value:"+value);
	}


}
