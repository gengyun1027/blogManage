package com.yun.service;

import com.yun.entity.Tag;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yun.vo.Result;
import com.yun.vo.TagVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ljg
 * @since 2022-05-19
 */
public interface TagService extends IService<Tag> {
    List<TagVo> findTagByArticleId(Long articleId);

    Result hots(int limit);

    /**
     * 查询所有的文章标签
     * @return
     */
    Result findAll();

    /**
     * 查询所有的标签详情
     * @return
     */
    Result findAllDetail();

    /**
     * 根据id查询标签
     * @param id
     * @return
     */
    Result findAllDetailById(Long id);

    /**
     * 查找同一标签下的文章Id
     * @param tagId
     * @return
     */
    List<Long> findArticleIdByTagId(Long tagId);
}
