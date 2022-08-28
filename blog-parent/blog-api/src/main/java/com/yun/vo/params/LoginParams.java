package com.yun.vo.params;

import lombok.Data;

/**
 * @author : ljg
 * @date : 2022/5/21 11:12
 * @description :
 */
@Data
public class LoginParams {

    private String account;
    private String password;
    private String nickname;
}
