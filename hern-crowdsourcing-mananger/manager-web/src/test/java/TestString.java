import com.hern.commons.StringUtils;
import com.hern.mananger.test.TestService;
import org.junit.Test;

/**
 * @Description 测试依赖crowdsourcing-commons、manager-service是否成功
 * @Author Hern
 * @Date 2019-06-07 14:15
 */
public class TestString {

    public static void main(String[] args) {
        StringUtils stringUtils = new StringUtils();
        System.out.println(stringUtils.isEmpty(""));
    }

    @Test
    public void test(){
        System.out.println(new StringUtils().isEmpty(""));
    }

    @Test
    public void test2(){
        new TestService().test();
    }
}
