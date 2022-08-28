package com.yun.admin.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.yun.admin.entity.Admin;
import com.yun.admin.entity.Permission;
import com.yun.admin.mapper.AdminMapper;
import com.yun.admin.mapper.PermissionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : ljg
 * @date : 2022/5/30 10:11
 * @description :
 */
@Service
public class AdminService {

    @Autowired
    public AdminMapper adminMapper;

    @Autowired
    public PermissionMapper permissionMapper;

    public Admin findAdminByUsername(String username){
        LambdaQueryWrapper<Admin> queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.eq(Admin::getUsername,username);
        queryWrapper.last("limit 1");
        Admin admin = adminMapper.selectOne(queryWrapper);
        return admin;
    }

    public List<Permission> findPermissionByAdminId(Long id) {
        //select p.id,p.name,p.path,p.description from yun_permission p INNER JOIN yun_admin_permission y on p.id=y.permission_id where y.id=1
        return adminMapper.findPermissionByAdminId(id);
    }
}
