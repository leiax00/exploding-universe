package bean.bo;


import bean.common.ResultCode;
import org.junit.jupiter.api.Test;

class ResultCodeTest {
    @Test
    public void testEnum() {
        System.out.println(ResultCode.STATUS_SUCCESS.name());
    }
}
