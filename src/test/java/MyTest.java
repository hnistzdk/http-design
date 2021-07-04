import cn.hnist.mapper.UserMapper;
import cn.hnist.pojo.User;
import cn.hnist.utils.MybatisUtils;
import cn.hnist.utils.SendEmail;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * @Description
 * @Author zdk
 * @Date 2021/4/15 8:49
 */
public class MyTest {
    @Test
    public void emailTest(){
        SendEmail.sendEmail("369365576@qq.com");
    }

    @Test
    public void mybatisTest(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.addUser(new User("张迪凯","123",null));
    }
}
