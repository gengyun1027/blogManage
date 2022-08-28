package com.yun.admin.vo;

import lombok.Data;

import java.util.List;

/**
 * @author : ljg
 * @date : 2022/5/29 17:24
 * @description :
 */
@Data
public class PageResult<T> {


    private List<T> list;

    private Long total;
}
