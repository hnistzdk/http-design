package cn.hnist.interceptor;

import static spark.Spark.before;
import static spark.Spark.halt;

/**
 * @Description
 * @Author zdk
 * @Date 2021/5/16 14:00
 */
public class EditInterceptor {
    public static void init(){
        before("/article/edit/:id/:userId",(req, res)->{
            String username = req.session().attribute("id");
            String userId = req.params("userId");
            if(!username.equals(userId)){
                halt(401,"你无法编辑别人的文章");
            }
        });
    }
}
