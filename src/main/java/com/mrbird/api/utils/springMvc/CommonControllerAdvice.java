package com.mrbird.api.utils.springMvc;


import com.mrbird.api.utils.exception.AbstractBackyardException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.*;

/**
 * 统一异常处理
 *
 * @author chenyao
 */
@ControllerAdvice
public class CommonControllerAdvice {

    private static final Logger logger = LoggerFactory.getLogger(CommonControllerAdvice.class);

    @ExceptionHandler(value = Exception.class)
    public ModelAndView handler(HttpServletRequest request, HandlerMethod handler, Exception ex) {
        Method method = handler.getMethod();
        //1.打印error日志，包括入参，异常信息
        logger.error("[commonControllerAdvice,method:{}, params:{}] 异常", method.getName(), request.getParameterMap(), ex);
        //2. 处理返回值
        //2.1 json (Result, Collection, 基本类型)
        //2.2 jsp view
        ErrorMessage message = build(ex);
        Class<?> returnType = method.getReturnType();
        if (RestUtils.isRestMethod(handler)) {
            MappingJackson2JsonView jsonView = new MappingJackson2JsonView();
            //The effect of setting this flag is similar to using MappingJackson2HttpMessageConverter with an @ResponseBody request-handling method.
            //使 @ResponseBody效果一样
            jsonView.setExtractValueFromSingleKeyModel(true);
            ModelAndView view = new ModelAndView(jsonView);
            Object returnObj = null;
            if (returnType == Result.class) {
                returnObj = Result.fail(message.getCode(), message.getMessage());
            } else {
                returnObj = create(returnType);
            }
            view.addObject("_result", returnObj);
            return view;
        }
        //jsp
        ModelAndView jspView = new ModelAndView("error");
        jspView.addObject("exception", ex.getMessage());
        return jspView;
    }

    private static final Map<Class, Object> DEFAULT_VALUE_OF_PRIMITIVE = new HashMap<Class, Object>() {{
        put(int.class, 0);
        put(double.class, 0.0D);
        put(long.class, 0L);
        put(char.class, '\u0000');
        put(float.class, 0.0F);
        put(short.class, 0);
        put(byte.class, 0);
        put(boolean.class, false);
        put(void.class, null);
    }};


    /**
     * 创建返回值
     *
     * @param clazz
     * @return
     */
    private Object create(Class clazz) {
        Object instance;
        try {
            if (clazz == null) {
                return null;
            }
            if (clazz.isInterface()) {
                return interfaceInstance(clazz);
            }
            if (clazz.isPrimitive()) {
                //对基本类型处理
                return primitiveInstance(clazz);
            }
            if (clazz.isArray()) {
                return new Object[0];
            }
            instance = clazz.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            //ignore exception, 对未知类型，或者无默认构造函数，统一返回null
            return null;
        }
        return instance;
    }

    private Object interfaceInstance(Class clazz) {
        if (clazz == List.class || clazz == Collection.class) {
            return Collections.emptyList();
        }
        if (clazz == Map.class) {
            return Collections.emptyMap();
        }
        return null;
    }

    private Object primitiveInstance(Class clazz) {
        return DEFAULT_VALUE_OF_PRIMITIVE.get(clazz);
    }


    private ErrorMessage build(Exception ex) {
        if (ex instanceof AbstractBackyardException) {
            AbstractBackyardException e = (AbstractBackyardException) ex;
            return new ErrorMessage(e.getErrorCode(), e.getMessage());
        }
        if (ex instanceof BindException) {
            BindException bindException = (BindException) ex;
            String message = bindException.getBindingResult().getAllErrors()
                    .stream()
                    .findFirst()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .orElse(AbstractResultEnum.COMM_SYSTEM_EXCEPTION.message());
            return new ErrorMessage(AbstractResultEnum.COMM_ILLEGAL_ARGUMENT.code(), message);
        }
        return new ErrorMessage(AbstractResultEnum.COMM_SYSTEM_EXCEPTION.code(), AbstractResultEnum.COMM_SYSTEM_EXCEPTION.message());
    }


    private static class ErrorMessage {
        private final int code;
        private final String message;

        ErrorMessage(int code, String message) {
            this.code = code;
            this.message = message;
        }

        public int getCode() {
            return code;
        }

        public String getMessage() {
            return message;
        }
    }


}