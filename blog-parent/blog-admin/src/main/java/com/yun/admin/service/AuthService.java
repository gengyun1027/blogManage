package com.yun.admin.service;

import com.yun.admin.entity.Admin;
import com.yun.admin.entity.Permission;
import org.apache.catalina.authenticator.SpnegoAuthenticator;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author : ljg
 * @date : 2022/5/30 10:44
 * @description :
 */
@Service
public class AuthService {

    @Autowired
    private AdminService adminService;

    public boolean auth(HttpServletRequest request, Authentication authentication){
        //权限认证
        //请求路径
        String requestURI = request.getRequestURI();
        Object principal = authentication.getPrincipal();
        if(principal==null||"anonymousUser".equals(principal)){
            //未登录
            return false;
        }
        UserDetails userDetails = (UserDetails) principal;
        String username = userDetails.getUsername();
        Admin admin = adminService.findAdminByUsername(username);
        if(admin==null){
            return false;
        }
        if(1==admin.getId()){
            //超级管理员
            return true;
        }
        Long id = admin.getId();
        List<Permission> permissionList=adminService.findPermissionByAdminId(id);
        requestURI= StringUtils.split(requestURI,"?")[0];
        for (Permission permission : permissionList) {
            if(requestURI.equals(permission.getPath())){
                return true;
            }
        }
        return false;
    }
}
