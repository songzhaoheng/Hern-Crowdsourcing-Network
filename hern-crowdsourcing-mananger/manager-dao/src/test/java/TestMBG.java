import com.hern.manager.bean.TUser;
import com.hern.manager.dao.TUserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.mybatis.spring.SqlSessionFactoryBean;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class TestMBG {
    public SqlSessionFactory getSqlSessionFactory() throws IOException, IOException {
        String resource = "classpath:hern-crowdsourcing-mananger/manager-dao/src/main/resources/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        return new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void testFile(){
        String path = "classpath:src/main/resources/mybatis-config.xml";
        File file = new File(path);
        System.out.println(file.getPath());
    }
    @Test
    public void test() throws IOException {

        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();

        try {
            TUserMapper tUserMapper = sqlSession.getMapper(TUserMapper.class);
            TUser tUser = tUserMapper.selectByPrimaryKey(1);
            System.out.println(tUser);



        }finally {
            sqlSession.close();
        }


    }
}
