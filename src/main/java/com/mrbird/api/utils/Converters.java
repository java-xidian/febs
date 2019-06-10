package com.mrbird.api.utils;

import com.alibaba.fastjson.PropertyNamingStrategy;
import com.mrbird.api.utils.exception.BizException1;
import com.mrbird.api.utils.springMvc.AbstractResultEnum2;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class Converters {

    /**
     * 转换bean
     *
     * @param source    要转换的bean
     * @param destClass 结果bean class类型
     * @return
     */
    public static <S, D> D convert(S source, Class<D> destClass) {
        if (source == null) {
            return null;
        }
        D dest;
        try {
            dest = BeanUtils.instantiateClass(destClass);
            BeanUtils.copyProperties(source, dest, destClass);
        } catch (Exception e) {
            throw new BizException1(AbstractResultEnum2.COMM_SYSTEM_EXCEPTION, "convert bean error");
        }
        return dest;
    }

    /**
     * source bean List convert to dest bean list
     *
     * @param sourceList 要转换bean的集合
     * @param destClass  目标bean class类型
     * @return
     */
    public static <S, D> List<D> convertList(List<S> sourceList, Class<D> destClass) {
        List<D> list = new ArrayList<>();
        if (sourceList == null || sourceList.isEmpty()) {
            return list;
        }
        return sourceList.parallelStream().map(s -> convert(s, destClass)).collect(Collectors.toList());
    }

    /**
     * 驼峰命名转换成已下划线命名
     *
     * @param str 字符串
     * @return 下划线命名
     */
    public static String snakeCase(String str) {
        if (StringUtils.isBlank(str)) {
            return StringUtils.EMPTY;
        }
        return PropertyNamingStrategy.SnakeCase.translate(str);
    }


    /**
     * 下划线命名转驼峰命名
     *
     * @param str 命名
     * @return 驼峰命名
     */
    public static String camelCase(String str) {
        if (StringUtils.isBlank(str)) {
            return StringUtils.EMPTY;
        }
        return PropertyNamingStrategy.CamelCase.translate(str);
    }

    /**
     * 驼峰命名转帕斯卡命名
     *
     * @param str
     * @return
     */
    public static String pascalCase(String str) {
        if (StringUtils.isBlank(str)) {
            return StringUtils.EMPTY;
        }
        return PropertyNamingStrategy.PascalCase.translate(str);
    }
}
