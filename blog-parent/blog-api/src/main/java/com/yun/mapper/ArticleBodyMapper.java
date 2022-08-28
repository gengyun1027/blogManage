package com.yun.mapper;

import com.yun.entity.ArticleBody;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ljg
 * @since 2022-05-23
 */
@Mapper
public interface ArticleBodyMapper extends BaseMapper<ArticleBody> {

    void deleteByarticleId(Long articleId);
}
