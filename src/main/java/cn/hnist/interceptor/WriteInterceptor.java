package cn.hnist.interceptor;

import static spark.Spark.before;
import static spark.Spark.halt;

/**
 * @Description
 * @Author zdk
 * @Date 2021/5/16 19:20
 */
public class WriteInterceptor {
    public static void init(){
        before("/article/intoAdd",(req, res)->{
            String username = req.session().attribute("id");
            if(username==null){
                halt(401,"登录后才能发布文章");
            }
        });
    }
}
