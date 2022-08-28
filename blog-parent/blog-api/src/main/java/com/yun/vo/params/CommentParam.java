package com.yun.vo.params;

import lombok.Data;

/**
 * @author : ljg
 * @date : 2022/5/25 8:34
 * @description :
 */
@Data
public class CommentParam {
    private Long articleId;

    private String content;

    private Long parent;

    private Long toUserId;

}
