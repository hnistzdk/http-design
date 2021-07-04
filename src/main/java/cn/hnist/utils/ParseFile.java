package cn.hnist.utils;

import spark.Request;

import javax.servlet.MultipartConfigElement;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public final class ParseFile {

    public static Boolean parse(Request req,String filepath,String name){
        req.attribute("org.eclipse.jetty.multipartConfig",
                new MultipartConfigElement("C:\\Users\\fengzhu\\Desktop\\temp"));
        // /temp 换成你自己，d:/tmp(必须存在)
        try (InputStream is = req.raw().getPart(name).getInputStream()) {
            System.out.println("path:"+filepath);
            OutputStream os = new FileOutputStream(filepath);
            byte[] buffer = new byte[10*1024];
            int l;
            while((l=is.read(buffer))!=-1){
                os.write(buffer,0,l);
            }
            is.close();
            os.flush();
            os.close();
            return true;
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return  false;

    }
}
