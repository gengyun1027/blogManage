package com.yun.mapper;

import com.yun.entity.Comment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ljg
 * @since 2022-05-24
 */
@Mapper
public interface CommentMapper extends BaseMapper<Comment> {

}
