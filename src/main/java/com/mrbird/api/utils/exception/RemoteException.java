package com.mrbird.api.utils.exception;

/**
 * 远程调用失败抛出的异常，需客户端捕获处理
 *
 * @author chenyao
 * @date 2019/3/27
 */
public class RemoteException extends Exception {

    public RemoteException() {
    }

    public RemoteException(String message) {
        super(message);
    }

    public RemoteException(String message, Throwable cause) {
        super(message, cause);
    }
}
