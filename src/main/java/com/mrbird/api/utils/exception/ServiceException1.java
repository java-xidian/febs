package com.mrbird.api.utils.exception;


import com.mrbird.api.utils.springMvc.AbstractResultEnum2;

/**
 * @author chenyao
 * @date 2018/10/22
 */
public class ServiceException1 extends AbstractBackyardException1 {

    public ServiceException1(AbstractResultEnum2 abstractReturnCode) {
        super(abstractReturnCode);
    }

    public ServiceException1(AbstractResultEnum2 abstractReturnCode, String message) {
        super(abstractReturnCode, message);
    }
}
