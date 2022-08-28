package com.yun.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.yun.entity.Tag;
import com.yun.mapper.TagMapper;
import com.yun.service.TagService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yun.vo.Result;
import com.yun.vo.TagVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ljg
 * @since 2022-05-19
 */
@Service
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag> implements TagService {
    @Autowired
    private TagMapper tagMapper;

    @Override
    public List<TagVo> findTagByArticleId(Long articleId) {
        //mybatis 无法进行多表查询
        List<Tag> tags=tagMapper.findTagsByArticleId(articleId);
        return copyList(tags);
    }

    @Override
    public Result hots(int limit) {
        /**
         * 最热标签，标签所拥有的文章数量最多
         * 根据tag_id，分组，从大到小排列
         */

        List<Long> tagIds=tagMapper.findHotsTagIds(limit);
        //需求tagId和tagName  tag对象
        if(CollectionUtils.isEmpty(tagIds)){
            return Result.success(Collections.emptyList());
        }


        List<Tag> tagList=tagMapper.findTagsByTagIds(tagIds);

        return Result.success(tagList);
    }

    @Override
    public Result findAll() {
        LambdaQueryWrapper<Tag> queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.select(Tag::getId,Tag::getTagName);
        List<Tag> tags = tagMapper.selectList(queryWrapper);
        return Result.success(copyList(tags));
    }

    @Override
    public Result findAllDetail() {
        List<Tag> tags = tagMapper.selectList(new LambdaQueryWrapper<>());
        return Result.success(tags);
    }

    @Override
    public Result findAllDetailById(Long id) {
        Tag tag = tagMapper.selectById(id);
        return Result.success(copy(tag));
    }

    @Override
    public List<Long> findArticleIdByTagId(Long tagId) {
        List<Long> articleIds=tagMapper.findArticleIdByTagId(tagId);
        return articleIds;
    }

    public List<TagVo> copyList(List<Tag> tags) {
        List<TagVo> tagVoList=new ArrayList<>();
        for (Tag tag : tags) {
            tagVoList.add(copy(tag));
        }
        return tagVoList;
    }

    public TagVo copy(Tag tag){
        TagVo tagVo=new TagVo();
        BeanUtils.copyProperties(tag,tagVo);
        tagVo.setId(String.valueOf(tag.getId()));
        return tagVo;
    }
}
