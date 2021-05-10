package com.atguigu.utils;

import org.apache.commons.beanutils.BeanUtils;

import java.util.Map;

public class WebUtils {
    public static <T>T copyParamToBeam(Map map, T bean){
        try {
            BeanUtils.populate(bean,map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }

    /**
     * 提供一个方法来转换字符串为整型 并提供转换失败的默认值
     * @param str                   待转换的字符串
     * @param defaultInt    默认数值
     * @return  返回转换后的结果，如果失败，返回defaultInt
     */
    public static int parseInt(String str,int defaultInt) {
        try {
            return Integer.parseInt(str);
        } catch (Exception e) {
            //e.printStackTrace();
        }
        return defaultInt;
    }
}
