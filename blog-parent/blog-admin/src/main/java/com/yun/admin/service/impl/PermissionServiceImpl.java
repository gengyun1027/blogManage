package com.yun.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yun.admin.entity.Permission;
import com.yun.admin.mapper.PermissionMapper;
import com.yun.admin.model.params.PageParam;
import com.yun.admin.service.PermissionService;
import com.yun.admin.vo.PageResult;
import com.yun.admin.vo.Result;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author : ljg
 * @date : 2022/5/29 16:08
 * @description :
 */
@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public Result listPermission(PageParam pageParam) {
        /**
         *需要的数据是，管理台  表的所有字段
         * 分页查询
         *
         */
        Page<Permission> page=new Page<>(pageParam.getCurrentPage(),pageParam.getPageSize());
        LambdaQueryWrapper<Permission> queryWrapper=new LambdaQueryWrapper<>();
        if(StringUtils.isNotBlank(pageParam.getQueryString())){
            queryWrapper.like(Permission::getName,pageParam.getQueryString());
        }
        Page<Permission> permissionPage = permissionMapper.selectPage(page, queryWrapper);
        PageResult<Permission> pageResult=new PageResult<>();
        pageResult.setList(permissionPage.getRecords());
        pageResult.setTotal(permissionPage.getTotal());
        return Result.success(pageResult);
    }

    @Override
    public Result addPermission(Permission permission) {
        permissionMapper.insert(permission);
        return Result.success(null);
    }

    @Override
    public Result deletePermission(Long id) {
        permissionMapper.deleteById(id);
        return Result.success(null);
    }

    @Override
    public Result updatePermission(Permission permission) {
        permissionMapper.updateById(permission);
        return Result.success(null);
    }
}
