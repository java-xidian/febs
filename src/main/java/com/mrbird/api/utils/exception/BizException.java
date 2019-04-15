package com.mrbird.api.utils.exception;


import com.mrbird.api.utils.springMvc.AbstractResultEnum;

/**
 * 业务异常
 *
 * @author chenyao
 */
public class BizException extends AbstractBackyardException {


    public BizException(AbstractResultEnum abstractReturnCode) {
        super(abstractReturnCode);
    }

    public BizException(AbstractResultEnum abstractReturnCode, String message) {
        super(abstractReturnCode, message);
    }
}
