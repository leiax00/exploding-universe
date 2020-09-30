package org.leiax00.universe.common.bean.common;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

@Getter
public enum ResultCode {
    STATUS_SUCCESS(1000, "STATUS_SUCCESS"),
    STATUS_FAILED(1500, "STATUS_FAILED"),
    STATUS_UNAUTHORIZED(1501, "STATUS_UNAUTHORIZED"),
    STATUS_INVALID_AUTH_INFO(1502, "INVALID_AUTH_INFO"),
    STATUS_RPC_EXCEPTION(1550, "RPC_EXCEPTION"),
    ;

    private final int code;
    private final String message;

    public String messageKey() {
        return StringUtils.isEmpty(this.message) ? this.name() : this.message;
    }

    ResultCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

}
