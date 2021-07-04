package cn.hnist.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Description
 * @Author zdk
 * @Date 2021/4/29 16:48
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Article implements Serializable {
    private Integer id;
    private String userId;
    private String articleTitle;
    private String articleIntro;
    private String articleText;
    private Integer articleUp;
    private Integer articleCollection;
    private Integer articleShare;
    private String articleTime;
}
