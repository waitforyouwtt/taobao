package com.yidiandian.vo;

import java.util.*;

/**
 * @author 凤凰小哥哥
 * @date 2020-11-06
 */
public class ListUtils {
    /**
     * List去重，不打乱原来顺序，泛型list对象
     * 对象重写hashCode和equals
     * @param <T>
     * @param list
     * @return
     */
    public static <T> List<T> distinctBySetOrder(List<T> list){
        Set<T> set = new HashSet<T>();
        List<T> newList = new ArrayList<T>();
        for(T t: list){
            if(set.add(t)){
                newList.add(t);
            }
        }
        return newList;
    }

    /**
     * List去重，可能打乱原来顺序，泛型list对象
     * 对象重写hashCode和equals
     * @param list
     * @return
     */
    public static <T> List<T> distinctBySet(List<T> list){
        return new ArrayList<T>(new HashSet<T>(list));
    }

    /**
     * 去重
     * @param list
     * @param <T>
     * @return
     */
    public static <T> List<T> uquenlist(List<T> list){

        List<T> newlist = new ArrayList<T>();
        Set<T> set = new HashSet<T>();

        for(Iterator<T> iter = list.iterator(); iter.hasNext(); ){
            T element = iter.next();
            if(set.add(element)){
                newlist.add(element);
            }
        }
        return  newlist;
    }
}
