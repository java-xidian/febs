package com.mrbird.api.utils.fastjson;

/**
 * 属性名策略说明：
 * CamelCase策略，Java对象属性：personId，序列化后属性：persionId
 * PascalCase策略，Java对象属性：personId，序列化后属性：PersonId
 * SnakeCase策略，Java对象属性：personId，序列化后属性：person_id
 * KebabCase策略，Java对象属性：personId，序列化后属性：person-id
 *
 * @Description
 * @Author: liucq
 * @Date: 2019/4/26
 */

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.PropertyNamingStrategy;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.serializer.SerializeConfig;

public class FastJsonMain {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // 创建对象并赋值
        Person person = new Person();
        person.personId = 21;
        person.personName = "小奋斗教程";
        person.personEmail = "1732482792@qq.com";
        person.personPhone = "156983444xx";

        // 序列化配置对象
        SerializeConfig config = new SerializeConfig();
        config.propertyNamingStrategy = PropertyNamingStrategy.CamelCase;
        ;

        // 序列化对象
        String json = JSON.toJSONString(person, config);
        System.out.println("反序列 person json -> ");
        System.out.println(json);

        // 反序列化配置对象
        ParserConfig parserConfig = new ParserConfig();
        parserConfig.propertyNamingStrategy = PropertyNamingStrategy.CamelCase;

        // 反序列化对象
        person = JSON.parseObject(json, Person.class, parserConfig);
        System.out.println("反序列化 内容 -> ");
        System.out.print(person.personId + " ");
        System.out.print(person.personName + " ");
        System.out.print(person.personEmail + " ");
        System.out.println(person.personPhone);
    }

}
