package org.leiax00.universe.common.bean.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.leiax00.universe.common.bean.common.ResultCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class UniverseRuntimeException extends RuntimeException {
    private ResultCode code;

    public UniverseRuntimeException() {
    }

    public UniverseRuntimeException(String message) {
        super(message);
    }

    public UniverseRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public UniverseRuntimeException(Throwable cause) {
        super(cause);
    }

    public UniverseRuntimeException withCode(ResultCode code) {
        this.code = code;
        return this;
    }
}
