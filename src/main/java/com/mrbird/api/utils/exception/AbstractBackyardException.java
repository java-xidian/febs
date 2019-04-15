package com.mrbird.api.utils.exception;


import com.mrbird.api.utils.springMvc.AbstractResultEnum;

/**
 * 系统基础异常
 *
 * @author chenyao
 */
public abstract class AbstractBackyardException extends RuntimeException {

    private final int errorCode;

    private final String errorMsg;


    public AbstractBackyardException(AbstractResultEnum abstractReturnCode) {
        super(abstractReturnCode.message());
        this.errorCode = abstractReturnCode.code();
        this.errorMsg = abstractReturnCode.message();
    }

    public AbstractBackyardException(AbstractResultEnum abstractReturnCode, String message) {
        super(message);
        this.errorCode = abstractReturnCode.code();
        this.errorMsg = message;
    }


    public int getErrorCode() {
        return errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }
}
