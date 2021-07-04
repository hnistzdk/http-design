package cn.hnist;
import cn.hnist.controllers.*;
import cn.hnist.interceptor.*;

import static spark.Spark.staticFiles;

/**
 * @author fengzhu
 */
public class Main {
    public static void main(String[] args){
        // port(9999);
        // 指定静态资源路径
        staticFiles.location("/public");
        UserController.init();
        ArticleController.init();
        EditInterceptor.init();
        WriteInterceptor.init();
    }
}
