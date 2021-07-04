package cn.hnist.mapper;

import cn.hnist.pojo.Article;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description
 * @Author zdk
 * @Date 2021/5/15 17:18
 */
public interface ArticleMapper {
    List<Article> getArticle(@Param("userId") String userId,@Param("start") int start);
    int addArticle(Article article);
    int updateArticle(Article article);
    Article getArticleById(@Param("id") int id,@Param("username") String username);
    int getCount();
}
