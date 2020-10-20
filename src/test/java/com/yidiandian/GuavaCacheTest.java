package com.yidiandian;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author 凤凰小哥哥
 * @date 2020-10-19
 */
@Component
@Slf4j
public class GuavaCacheTest extends TaobaoApplicationTests {

    /**
     * 简单的学习cache
     */
    @Test
    public void test1() {
        Cache<String, String> cache = CacheBuilder.newBuilder()
                .build();
        cache.put("word", "Hello Guava Cache");
        System.out.println(cache.getIfPresent("word"));
    }

    /**
     * 设置最大存储
     * Guava Cache可以在构建缓存对象时指定缓存所能够存储的最大记录数量。当Cache中的记录数量达到最大值后再调用put方法向其中添加对象，
     * Guava会先从当前缓存的对象记录中选择一条删除掉，腾出空间后再将新的对象存储到Cache中。
     */
    @Test
    public void test2() {
        Cache<String, String> cache = CacheBuilder.newBuilder()
                .maximumSize(2)
                .build();
        cache.put("key1", "value1");
        cache.put("key2", "value2");
        cache.put("key3", "value3");
        System.out.println("第一个值：" + cache.getIfPresent("key1"));
        System.out.println("第二个值：" + cache.getIfPresent("key2"));
        System.out.println("第三个值：" + cache.getIfPresent("key3"));
    }

    /**
     * 设置过期时间
     * 在构建Cache对象时，可以通过CacheBuilder类的expireAfterAccess和expireAfterWrite两个方法为缓存中的对象指定过期时间，
     * 使用`CacheBuilder`构建的缓存不会“自动”执行清理和逐出值，也不会在值到期后立即执行或逐出任何类型。相反，它在写入操作期间执行少量维护，
     * 或者在写入很少的情况下偶尔执行读取操作。其中，expireAfterWrite方法指定对象被写入到缓存后多久过期，
     * expireAfterAccess指定对象多久没有被访问后过期。
     * @throws InterruptedException
     */
    @Test
    public void test3() throws InterruptedException {
        Cache<String, String> cache = CacheBuilder.newBuilder()
                .maximumSize(2)
                .expireAfterWrite(3, TimeUnit.SECONDS)
                .build();
        cache.put("key1", "value1");
        int time = 1;
        while (true) {
            System.out.println("第" + time++ + "次取到key1的值为：" + cache.getIfPresent("key1"));
            Thread.sleep(1000);
        }
    }


}
