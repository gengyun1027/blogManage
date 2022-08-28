package com.yun.admin.service;

/**
 * @author : ljg
 * @date : 2022/5/29 16:06
 * @description :
 */

import com.yun.admin.entity.Permission;
import com.yun.admin.model.params.PageParam;
import com.yun.admin.vo.Result;

public interface PermissionService {

     /**
      * 查找
      * @param pageParam
      * @return
      */
     Result listPermission(PageParam pageParam);

     /**
      * 增加
      * @param permission
      * @return
      */
     Result addPermission(Permission permission);

     /**
      * 删除
      * @param id
      * @return
      */
     Result deletePermission(Long id);

     /**
      * 修改
      * @param permission
      * @return
      */
     Result updatePermission(Permission permission);
}
