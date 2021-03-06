package com.yidiandian.enums;

import com.google.common.collect.Lists;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author 凤凰小哥哥
 * @date 2020-10-15
 */
public enum HobbyEnum {

    hobby_1(1,"读书"),
    hooby_2(2,"绘画")
    ;

    //根据code 找到desc 描述
    private static final Map<Integer, HobbyEnum> valueLookup = new ConcurrentHashMap<>(values().length);
    static {
        for (HobbyEnum type: EnumSet.allOf( HobbyEnum.class)){
            valueLookup.put(type.code, type);
        }
    }

    //将枚举转换成list格式，这样前台遍历的时候比较容易，列如 下拉框 后台调用toList方法，便可以得到code 和name
    public static List<Map> typeEnumList() {
        //javac通过自动推导尖括号里的数据类型.
        List list = Lists.newArrayList();
        for (HobbyEnum enumClass : HobbyEnum.values()) {
            Map<String, Object> map = new HashMap<>();
            map.put( "code", enumClass.getCode() );
            map.put( "message", enumClass.getMsg() );
            list.add( map );
        }
        return list;
    }

    public static HobbyEnum fromValue(Integer code) {
        HobbyEnum data = valueLookup.get(code);
        if (data == null) {
            throw new IllegalArgumentException("参数[" + code + "]不正确，没有找到对应的 Enum");
        }
        return data;
    }
    HobbyEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private Integer code;
    private String  msg;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
