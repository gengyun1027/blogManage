package com.yun.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.util.List;

/**
 * @author : ljg
 * @date : 2022/5/19 11:20
 * @description :
 */

@Data
public class ArticleVo {
//    @JsonSerialize(using = ToStringSerializer.class)
    private String id;

    /**
     * 标题
     */
    private String title;

    /**
     * 简介
     */
    private String summary;

    /**
     * 评论数量
     */
    private Integer commentCounts;

    /**
     * 浏览数量
     */
    private Integer viewCounts;

    /**
     * 是否置顶
     */
    private Integer weight;


    /**
     * 创建时间
     */
    private String createDate;





    /**
     * 作者
     */
    private UserVo  author;

    /**
     * 内容
     */
    private ArticleBodyVo body;

    /**
     * 标签
     */
    private List<TagVo> tags;

    /**
     * 类别
     */
    private CategoryVo category;

}
