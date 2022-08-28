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
 * @since 2022-05-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("yun_comment")
public class Comment implements Serializable {


//    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String content;

    @TableField("create_date")
    private Long createDate;

    @TableField("article_id")
    private Long articleId;

    @TableField("author_id")
    private Long authorId;

    @TableField("parent_id")
    private Long parentId;

    @TableField("to_uid")
    private Long toUid;

    private Integer level;


}
