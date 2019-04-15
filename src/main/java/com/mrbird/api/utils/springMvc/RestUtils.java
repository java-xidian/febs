package com.mrbird.api.utils.springMvc;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.HandlerMethod;

/**
 * @author chenyao
 * @date 2018/10/31.
 */
public class RestUtils {

    /**
     * controller方法是否为rest 方法
     * @param handlerMethod
     * @return
     */
    public static boolean isRestMethod(HandlerMethod handlerMethod) {

        //导出功能并非ajax请求，用于同一拦截跳转
//        UnRestMethod unRestMethod = handlerMethod.getMethod().getAnnotation(UnRestMethod.class);
//        if(unRestMethod != null) {
//            return false;
//        }
        ResponseBody responseBody = handlerMethod.getMethod().getAnnotation(ResponseBody.class);
        if (responseBody != null) {
            return true;
        }
        //1. 看类上是否添加RestController
        RestController restController = handlerMethod.getBeanType().getAnnotation(RestController.class);
        return restController != null;
    }

}
