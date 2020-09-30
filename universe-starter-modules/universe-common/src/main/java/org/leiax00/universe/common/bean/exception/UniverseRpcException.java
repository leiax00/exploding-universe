package org.leiax00.universe.common.bean.exception;

import org.leiax00.universe.common.bean.common.ResultCode;

import javax.annotation.PostConstruct;

public class UniverseRpcException extends UniverseRuntimeException {
    public UniverseRpcException() {
        this.init();
    }

    public UniverseRpcException(String message) {
        super(message);
        this.init();
    }

    public UniverseRpcException(String message, Throwable cause) {
        super(message, cause);
        this.init();
    }

    public UniverseRpcException(Throwable cause) {
        super(cause);
        this.init();
    }

    @PostConstruct
    public void init() {
        this.withCode(ResultCode.STATUS_RPC_EXCEPTION);
    }
}
