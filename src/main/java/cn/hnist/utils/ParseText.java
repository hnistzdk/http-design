package cn.hnist.utils;

import spark.Request;

import javax.servlet.MultipartConfigElement;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

public class ParseText {
    public static String parse(Request req,String name){
        req.attribute("org.eclipse.jetty.multipartConfig",
                new MultipartConfigElement("C:\\Users\\fengzhu\\Desktop\\temp"));
        try{
            InputStream is = req.raw().getPart(name).getInputStream();
            ByteArrayOutputStream result = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            for (int length; (length = is.read(buffer)) != -1; ) {
                result.write(buffer, 0, length);
            }
            is.close();
            return result.toString();
        }catch (Exception e){
            e.printStackTrace();
        }
        return "";

    }
}
