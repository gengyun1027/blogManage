package com.yun.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

/**
 * @author : ljg
 * @date : 2022/5/24 17:55
 * @description :
 */
@Data
public class UserVo {
//    @JsonSerialize(using = ToStringSerializer.class)
    private String id;

    private String avatar;

    private String nickname;
}
