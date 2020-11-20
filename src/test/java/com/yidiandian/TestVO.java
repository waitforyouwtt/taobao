package com.yidiandian;

import lombok.Data;

/**
 * @author 凤凰小哥哥
 * @date 2020-11-06
 */
@Data
public class TestVO {

    private String uid;

    private String ud2;

    private String ud3;

    public void setUd3(String ud3) {
        this.ud3 = addZeroForNum(ud3,10);
    }



    public String getUd3() {
        return ud3;
    }

    public static String addZeroForNum(String str, int strLength) {
        int strLen = str.length();
        if (strLen < strLength) {
            while (strLen < strLength) {
                StringBuffer sb = new StringBuffer();
                sb.append("0").append(str);// 左补0
                // sb.append(str).append("0");//右补0
                str = sb.toString();
                strLen = str.length();
            }
        }

        return str;
    }
}
