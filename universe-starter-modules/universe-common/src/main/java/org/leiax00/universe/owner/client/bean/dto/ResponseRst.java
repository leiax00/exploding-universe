package org.leiax00.universe.owner.client.bean.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.leiax00.universe.owner.client.bean.common.ResultCode;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseRst<T> {
    private int status;

    private String message;

    private T data;

    public static <E> ResponseRst<E> build() {
        return new ResponseRst<>();
    }

    public ResponseRst<T> withData(T t) {
        this.data = t;
        return this;
    }

    public ResponseRst<T> withOk() {
        return this.withOk(ResultCode.STATUS_SUCCESS);
    }

    public ResponseRst<T> withOk(ResultCode resultCode) {
        return this.with(resultCode.getCode(), resultCode.getMessage());
    }

    public ResponseRst<T> withError() {
        return this.withError(ResultCode.STATUS_FAILED);
    }

    public ResponseRst<T> withError(String message) {
        return this.with(ResultCode.STATUS_FAILED.getCode(), message);
    }

    public ResponseRst<T> withError(ResultCode resultCode) {
        return this.with(resultCode.getCode(), resultCode.messageKey());
    }

    public ResponseRst<T> with(int status, String message) {
        this.status = status;
        this.message = message;
        return this;
    }
}
