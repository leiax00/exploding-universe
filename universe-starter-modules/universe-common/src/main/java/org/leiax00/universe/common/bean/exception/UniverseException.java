package org.leiax00.universe.common.bean.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.leiax00.universe.common.bean.common.ResultCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class UniverseException extends Exception {
    private ResultCode code;

    public UniverseException() {
    }

    public UniverseException(String message) {
        super(message);
    }

    public UniverseException(String message, Throwable cause) {
        super(message, cause);
    }

    public UniverseException(Throwable cause) {
        super(cause);
    }

    public UniverseException withCode(ResultCode code) {
        this.code = code;
        return this;
    }
}
