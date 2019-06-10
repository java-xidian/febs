package com.mrbird.api.utils.exception;


import com.mrbird.api.utils.springMvc.AbstractResultEnum2;

/**
 * 业务异常
 *
 * @author chenyao
 */
public class BizException1 extends AbstractBackyardException1 {


    public BizException1(AbstractResultEnum2 abstractReturnCode) {
        super(abstractReturnCode);
    }

    public BizException1(AbstractResultEnum2 abstractReturnCode, String message) {
        super(abstractReturnCode, message);
    }
}
