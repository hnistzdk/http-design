package cn.hnist.controllers;

import cn.hnist.mapper.UserMapper;
import cn.hnist.pojo.User;
import cn.hnist.utils.MybatisUtils;
import com.alibaba.fastjson.JSON;
import org.apache.ibatis.session.SqlSession;
import spark.Route;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.post;

/**
 * @author fengzhu
 */
public final class UserController {

    static Route user_login = (req,res)->{
//        String username = ParseText.parse(req,"username");
//        String password = ParseText.parse(req,"password");
        String username = req.queryParams("username");
        String password = req.queryParams("password");
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.login(username, password);
        Map map = new HashMap<>();
        if(user!=null){
            req.session(true);
            req.session().attribute("id",username);
            req.session().attribute(username,user);
            req.session().attribute("logined",true);
            map.put("code", 200);
//            res.redirect("/userMain.html");
            return JSON.toJSONString(map);
        }else{
            map.put("code", 201);
            return JSON.toJSONString(map);
        }
    };

    static Route user_register = (req,res)->{
        String username = req.queryParams("username");
        String password = req.queryParams("password");
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        String username1 = mapper.getUserNameById(username);
        Map map = new HashMap<>();
        if(username1!=null){
            map.put("code", 201);
            map.put("msg", "该用户已经存在");
        }else{
            int result = mapper.addUser(new User(username, password, null));
            if(result>0){
                map.put("code", 200);
                map.put("msg", "注册成功");
            }else{
                map.put("code", 202);
                map.put("msg", "注册失败");
            }
        }
        return JSON.toJSONString(map);
    };



    public static Route getAuthors=(req,res)->{
        String username = req.session().attribute("id");
        Map map=new HashMap();
        map.put("username", username);
        return JSON.toJSONString(map);
    };


    public static void init(){
        post("/user/login",user_login);
        post("/user/register",user_register);
        post("/authname", getAuthors);
    }
}
