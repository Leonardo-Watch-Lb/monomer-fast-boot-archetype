package org.example.scaffolding.infrastructure.entity.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Leonardo
 * @creatTime 2023/3/13 23:54
 */
@Getter
@Setter
public class BizException extends RuntimeException {

    /**
     * 错误码
     */
    private Integer errorCode;

    /**
     * 附加信息
     */
    private String extraMessage;

    public BizException(String message, Throwable cause, Integer errorCode, String extraMessage) {
        super(message, cause);
        this.errorCode = errorCode;
        this.extraMessage = extraMessage;
    }

}
