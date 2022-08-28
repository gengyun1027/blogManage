package com.yun.vo.params;

import lombok.Data;

/**
 * @author : ljg
 * @date : 2022/5/19 10:40
 * @description :
 */

@Data
public class PageParams {
    private int page = 1;
    private int pageSize = 5;
    private Long categoryId;
    private Long tagId;

    private String year;
    private String month;

    public String getMonth() {
        if(month!=null&&month.length()==1){
            return "0"+this.month;
        }
        return this.month;
    }
}
