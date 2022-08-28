package com.yun.mapper;

import com.yun.entity.SysUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ljg
 * @since 2022-05-19
 */
@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {

}
