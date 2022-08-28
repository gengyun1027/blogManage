package com.yun.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author ljg
 * @since 2022-05-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("yun_article")
public class Article implements Serializable {


//    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 评论数量
     */
    @TableField("comment_counts")
    private Integer commentCounts;

    /**
     * 创建时间
     */
    @TableField("create_date")
    private Long createDate;

    /**
     * 简介
     */
    private String summary;

    /**
     * 标题
     */
    private String title;

    /**
     * 浏览数量
     */
    @TableField("view_counts")
    private Integer viewCounts;

    /**
     * 是否置顶
     */
    private Integer weight;

    /**
     * 作者id
     */
    @TableField("author_id")
    private Long authorId;

    /**
     * 内容id
     */
    @TableField("body_id")
    private Long bodyId;

    /**
     * 类别id
     */
    @TableField("category_id")
    private Long categoryId;


}
