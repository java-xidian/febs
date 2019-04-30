package com.mrbird.api.demoRestful;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 接口信息对象
 * 主要包括授权地址，权限唯一标识，权限名称，创建时间，请求方式
 *
 * @Description
 * @Author: liucq
 * @Date: 2019/4/30
 */
@Data
public class Auth implements Serializable {
    private String authName;
    private String authUrl;
    private String authUniqueMark;
    private Date createTime;
    private String methodType;
}



