package com.yun.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yun.entity.ArticleTag;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author : ljg
 * @date : 2022/5/26 10:09
 * @description :
 */
@Mapper
public interface ArticleTagMapper extends BaseMapper<ArticleTag> {
    void deleteByarticleId(Long articleId);
}
