package bean.dto;

import bean.common.ResultCode;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseRst<T> {
    private int status;

    private String message;

    private T data;

    public ResponseRst<T> withOk() {
        return this.withOk(ResultCode.STATUS_SUCCESS);
    }

    public ResponseRst<T> withOk(ResultCode resultCode) {
        return this.withOk(resultCode.getCode());
    }

    public ResponseRst<T> withOk(int status) {
        this.status = status;
        return this;
    }

    public ResponseRst<T> withError() {
        return this.withError(ResultCode.STATUS_FAILED);
    }

    public ResponseRst<T> withError(String message) {
        return this.withError(ResultCode.STATUS_FAILED.getCode(), message);
    }

    public ResponseRst<T> withError(ResultCode resultCode) {
        return this.withError(resultCode.getCode(), resultCode.messageKey());
    }

    public ResponseRst<T> withError(int status, String message) {
        this.status = status;
        this.message = message;
        return this;
    }
}
