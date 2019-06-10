package com.mrbird.api.utils.exception;


import com.mrbird.api.utils.springMvc.AbstractResultEnum2;

/**
 * 系统基础异常
 *
 * @author chenyao
 */
public abstract class AbstractBackyardException1 extends RuntimeException {

    private final int errorCode;

    private final String errorMsg;


    public AbstractBackyardException1(AbstractResultEnum2 abstractReturnCode) {
        super(abstractReturnCode.message());
        this.errorCode = abstractReturnCode.code();
        this.errorMsg = abstractReturnCode.message();
    }

    public AbstractBackyardException1(AbstractResultEnum2 abstractReturnCode, String message) {
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
