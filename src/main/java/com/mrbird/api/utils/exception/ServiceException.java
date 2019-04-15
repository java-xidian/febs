package com.mrbird.api.utils.exception;

import com.hsfw.backyard.biz.code.AbstractReturnCode;

/**
 * @author chenyao
 * @date 2018/10/22
 */
public class ServiceException extends AbstractBackyardException {

    public ServiceException(AbstractReturnCode abstractReturnCode) {
        super(abstractReturnCode);
    }

    public ServiceException(AbstractReturnCode abstractReturnCode, String message) {
        super(abstractReturnCode, message);
    }
}
