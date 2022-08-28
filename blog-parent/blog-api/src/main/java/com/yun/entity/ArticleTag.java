package com.yun.entity;

import lombok.Data;

/**
 * @author : ljg
 * @date : 2022/5/26 10:07
 * @description :
 */
@Data
public class ArticleTag {
    private Long id;
    private Long articleId;
    private Long tagId;
}
