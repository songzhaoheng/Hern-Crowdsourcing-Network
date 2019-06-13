import com.hern.commons.MD5Util;
import org.junit.Test;

public class TestMD5Util {

    @Test
    public void test(){
        String string = "123456";
        System.out.println(MD5Util.digest(string));
        System.out.println(MD5Util.digest16(string));
        System.out.println(MD5Util.digest(string));
        System.out.println(MD5Util.digest16(string));

        String string2 =MD5Util.digest(MD5Util.digest(string));
        System.out.println(string2);
        System.out.println(MD5Util.digest16(MD5Util.digest16(string)));
    }
}
