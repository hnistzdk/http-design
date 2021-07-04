package cn.hnist.controllers;

import cn.hnist.mapper.ArticleMapper;
import cn.hnist.pojo.Article;
import cn.hnist.utils.DateConversion;
import cn.hnist.utils.MybatisUtils;
import cn.hnist.utils.ParseText;
import com.alibaba.fastjson.JSON;
import org.apache.ibatis.session.SqlSession;
import spark.Route;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.post;

/**
 * @Description
 * @Author zdk
 * @Date 2021/5/19 8:05
 */
public class ArticleController {

    public static Route getArticleByUser=(req, res)->{
        String username = req.session().attribute("id");
        System.out.println("username:"+username);
        SqlSession sqlSession =MybatisUtils.getSqlSession();
        ArticleMapper mapper = sqlSession.getMapper(ArticleMapper.class);
        List<Article> list = mapper.getArticle(username,0);
        return JSON.toJSONString(list);
    };

    public static Route getArticles=(req,res)->{
        SqlSession sqlSession =MybatisUtils.getSqlSession();
        ArticleMapper mapper = sqlSession.getMapper(ArticleMapper.class);
        Integer start = Integer.valueOf(req.params("newpage"));
        List<Article> list = mapper.getArticle(null,(start-1)*5);
        for(int i=0;i<5-list.size();i++){
            list.add(new Article(null," "," "," "," ",null,null,null,null));
        }
        list.add(new Article(null," "," ",""," ",null,null,null,""));
        list.add(new Article(null," "," ",""," ",null,null,null,""));
        return JSON.toJSONString(list);
    };

    public static Route addArticle=(req,res)->{
        String username = req.session().attribute("id");
        String articleTitle = ParseText.parse(req, "articleTitle");
        String articleIntro = ParseText.parse(req, "articleIntro");
        String articleText = ParseText.parse(req, "articleText");
        Article article = new Article(null, username, articleTitle, articleIntro, articleText, 0, 0, 0, DateConversion.getNowDate());
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        ArticleMapper mapper = sqlSession.getMapper(ArticleMapper.class);
        int result = mapper.addArticle(article);
        if(result>0){
            res.redirect("/userMain.html");
            return JSON.toJSONString("{status:200}");
        }else {
            return JSON.toJSONString("{status:201}");
        }
    };

    public static Route getArticleById=(req,res)->{
        String id = req.params("id");
        SqlSession sqlSession =MybatisUtils.getSqlSession();
        ArticleMapper mapper = sqlSession.getMapper(ArticleMapper.class);
        Article article = mapper.getArticleById(Integer.parseInt(id),null);
        return JSON.toJSONString(article);
    };

    public static Route editArticle=(req,res)->{
        Map map=new HashMap();
        map.put("status", 200);
        return JSON.toJSONString(map);
    };

    public static Route updateArticle=(req,res)->{
//        Integer id =Integer.parseInt(ParseText.parse(req, "toId"));
//        String articleTitle = ParseText.parse(req, "articleTitle");
//        String articleIntro = ParseText.parse(req, "articleIntro");
//        String articleText = ParseText.parse(req, "articleText");
        Integer id =Integer.parseInt(req.queryParams("toId"));
        String articleTitle = req.queryParams("articleTitle");
        String articleIntro = req.queryParams("articleIntro");
        String articleText = req.queryParams("articleText");
        System.out.println(id);
        System.out.println(articleTitle);
        System.out.println(articleIntro);
        System.out.println(articleText);
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        ArticleMapper mapper = sqlSession.getMapper(ArticleMapper.class);
        Map map=new HashMap();
        if(articleTitle==null||articleIntro==null||articleText==null){
            map.put("status", 500);
            map.put("msg", "参数异常");
        }
        int result = mapper.updateArticle(new Article(id, null, articleTitle, articleIntro, articleText, null, null, null, null));
        System.out.println("修改-====="+result);
        if(result>0){
            map.put("status", 200);
            map.put("msg", "编辑成功");
        }else {
            map.put("status", 201);
            map.put("msg", "编辑失败");
        }
        return JSON.toJSONString(map);
    };

    public static Route getCount=(req,res)->{
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        ArticleMapper mapper = sqlSession.getMapper(ArticleMapper.class);
        System.out.println("总数"+mapper.getCount());
        return mapper.getCount();
    };

    public static Route intoAdd=(req,res)-> "ok";

    public static void init(){
        get("/article", getArticleByUser);
        get("/article/:id", getArticleById);
        //get("/articles", getArticles);
        get("/articles/:newpage", getArticles);
        post("/article/add", addArticle);
        post("/article/edit/:id/:userId", editArticle);
        get("/count",getCount);
        post("/article/update", updateArticle);
        post("/article/intoAdd",intoAdd);
    }
}
