package com.yun.service;

import com.yun.entity.Article;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yun.vo.Result;
import com.yun.vo.params.ArticleParam;
import com.yun.vo.params.PageParams;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ljg
 * @since 2022-05-19
 */
public interface ArticleService extends IService<Article> {

    /**
     * 分页查询文章列表
     * @param pageParams
     * @return
     */
    Result listArticle(PageParams pageParams);

    /**
     * 最热文章
     * @param limit
     * @return
     */
    Result hotArticle(int limit);

    /**
     * 最新文章
     * @param limit
     * @return
     */
    Result newArticle(int limit);

    /**
     * 文章归档
     * @return
     */
    Result listArchives();

    /**
     * 查看文章详情
     * @param articleId
     * @return
     */
    Result findArticleById(Long articleId);

    /**
     * 发布文章
     * @param articleParam
     * @return
     */
    Result publish(ArticleParam articleParam);

    /**
     * 模糊搜索
     * @param search
     * @return
     */
    Result searchArticle(String search);
}
