import com.hern.commons.StringUtils;
import org.junit.Test;

/**
 * @Description 测试依赖crowdsourcing-commons是否成功
 * @Author Hern
 * @Date 2019-06-07 14:12
 */
public class TestString {

    @Test
    public void test(){
        System.out.println(new StringUtils().isEmpty(""));
    }
}
