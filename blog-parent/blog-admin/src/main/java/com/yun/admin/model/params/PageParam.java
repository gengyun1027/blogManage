package com.yun.admin.model.params;

import lombok.Data;

/**
 * @author : ljg
 * @date : 2022/5/29 15:52
 * @description :
 */
@Data
public class PageParam {

    private Integer currentPage;

    private Integer pageSize;

    private String queryString;

}
