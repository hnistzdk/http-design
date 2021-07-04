package cn.hnist.mapper;

import cn.hnist.pojo.User;
import org.apache.ibatis.annotations.Param;

/**
 * @author zdk
 * @date 2021/3/28 15:43
 */
public interface UserMapper {
    User login(@Param("username") String username,@Param("password") String password);
    String getUserNameById(@Param("id") String username);
    int addUser(User user);
}
