package com.yun.vo.params;

import com.yun.vo.CategoryVo;
import com.yun.vo.TagVo;
import lombok.Data;

import java.util.List;

/**
 * @author : ljg
 * @date : 2022/5/26 8:50
 * @description :
 */
@Data
public class ArticleParam {
    private Long id;
    private ArticleBodyParam body;
    private CategoryVo category;
    private  String summary;
    private List<TagVo> tags;
    private String title;
    private String search;
}
