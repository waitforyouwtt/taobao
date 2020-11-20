package com.yidiandian;

import com.yidiandian.vo.ListUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toCollection;

/**
 * @author 凤凰小哥哥
 * @date 2020-11-09
 */
@Component
@Slf4j

public class DistinctTest extends TaobaoApplicationTests{

    @Test
    public void sub(){
        TestVO vo = new TestVO();
        vo.setUd3("abc");
        vo.setUid("1");
        vo.setUd2("2");

        TestVO vo1 = new TestVO();
        vo1.setUd3("abc");
        vo1.setUid("1");
        vo1.setUd2("2");

        List<TestVO> list =new ArrayList<>();
        list.add(vo);
        list.add(vo1);

        List<?> list2 = list;
        List<?> list3 = ListUtils.distinctBySetOrder(list2);
        List<?> list4 = ListUtils.distinctBySet(list2);


		list = list.stream().collect(
				collectingAndThen(
						toCollection(() -> new TreeSet<>(Comparator.comparing(TestVO::getUd3))), ArrayList::new)
		);

        log.info("去重：{}", list3.size());
    }
}
