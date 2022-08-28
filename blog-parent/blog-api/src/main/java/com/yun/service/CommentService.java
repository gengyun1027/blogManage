package com.yun.service;

import com.yun.entity.Comment;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yun.vo.Result;
import com.yun.vo.params.CommentParam;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ljg
 * @since 2022-05-24
 */
public interface CommentService extends IService<Comment> {

    /**
     * 根据文章ID查询评论
     * @param id
     * @return
     */
    Result commentsByArticleId(Long id);

    Result comment(CommentParam commentParam);
}
