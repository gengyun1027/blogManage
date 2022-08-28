package com.yun.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.util.List;

/**
 * @author : ljg
 * @date : 2022/5/24 17:51
 * @description :
 */

@Data
public class CommentVo {
    //防止前端精度损失，将id转为string
//    @JsonSerialize(using= ToStringSerializer.class)
    private String id;
    private UserVo author;
    private String content;
    private List<CommentVo> childrens;
    private String createDate;
    private Integer level;
    private UserVo toUser;
}
