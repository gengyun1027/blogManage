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
 * @since 2022-05-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("yun_category")
public class Category implements Serializable {


//    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String avatar;

    @TableField("category_name")
    private String categoryName;

    private String description;


}
