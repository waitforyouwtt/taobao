package com.yidiandian;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.stereotype.Component;




/**
 * @author 凤凰小哥哥
 * @date 2020-10-22
 */
@Component
@Slf4j
public class ThreadTest extends TaobaoApplicationTests{

    private int value;

    private synchronized int getValue(){
        return value ++;
    }

    @Test
    public void plus(){

    }


}
