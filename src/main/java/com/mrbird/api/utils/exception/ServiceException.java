package com.mrbird.api.utils.exception;


import com.mrbird.api.utils.springMvc.AbstractResultEnum;

/**
 * @author chenyao
 * @date 2018/10/22
 */
public class ServiceException extends AbstractBackyardException {

    public ServiceException(AbstractResultEnum abstractReturnCode) {
        super(abstractReturnCode);
    }

    public ServiceException(AbstractResultEnum abstractReturnCode, String message) {
        super(abstractReturnCode, message);
    }
}
