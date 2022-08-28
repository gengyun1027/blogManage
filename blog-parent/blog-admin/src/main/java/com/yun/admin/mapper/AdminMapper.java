package com.yun.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yun.admin.entity.Admin;
import com.yun.admin.entity.Permission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author : ljg
 * @date : 2022/5/30 10:24
 * @description :
 */

@Mapper
public interface AdminMapper extends BaseMapper<Admin> {
    @Select("select p.id,p.name,p.path,p.description from yun_permission p INNER JOIN yun_admin_permission y on p.id=y.permission_id where y.id=#{id} ")
    List<Permission> findPermissionByAdminId(Long id);
}
