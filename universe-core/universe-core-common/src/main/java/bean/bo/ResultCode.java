package bean.bo;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

@Getter
public enum ResultCode {
    STATUS_SUCCESS(1000, "STATUS_SUCCESS"),
    STATUS_FAILED(1050, "STATUS_FAILED"),
    STATUS_UNAUTHORIZED(1051, "STATUS_UNAUTHORIZED"),
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
