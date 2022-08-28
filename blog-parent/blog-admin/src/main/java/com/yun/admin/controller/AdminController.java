package com.yun.admin.controller;

import com.yun.admin.entity.Permission;
import com.yun.admin.model.params.PageParam;
import com.yun.admin.service.PermissionService;
import com.yun.admin.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.ResultSet;

/**
 * @author : ljg
 * @date : 2022/5/29 15:12
 * @description :
 */

@RestController
@RequestMapping("admin")
public class AdminController {
    @Autowired
    private PermissionService permissionService;

    @PostMapping("permission/permissionList")
    public Result listPermission(@RequestBody PageParam pageParam){
        return permissionService.listPermission(pageParam);
    }

    @PostMapping("permission/add")
    public Result addPermission(@RequestBody Permission permission){
        return permissionService.addPermission(permission);
    }

    @GetMapping("permission/delete/{id}")
    public Result deletePermission(@PathVariable("id") Long id){
        return permissionService.deletePermission(id);
    }

    @PostMapping("permission/update")
    public Result updatePermission(@RequestBody Permission permission){
        return permissionService.updatePermission(permission);
    }
}
