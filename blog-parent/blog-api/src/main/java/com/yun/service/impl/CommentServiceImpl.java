package com.yun.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.yun.entity.Article;
import com.yun.entity.Comment;
import com.yun.entity.SysUser;
import com.yun.mapper.ArticleMapper;
import com.yun.mapper.CommentMapper;
import com.yun.service.CommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yun.service.SysUserService;
import com.yun.utils.UserThreadLocal;
import com.yun.vo.CommentVo;
import com.yun.vo.Result;
import com.yun.vo.UserVo;
import com.yun.vo.params.CommentParam;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author ljg
 * @since 2022-05-24
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {

    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public Result commentsByArticleId(Long id) {

        /**
         * 1. 根据文章id查询评论，从comment中查询
         * 2. 根据作者id查询作者信息
         * 3. 判断如果level=1 查询有没有子评论
         * 4. 如果有 根据id(parentId)查询
         */
        LambdaQueryWrapper<Comment> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Comment::getArticleId, id);
        queryWrapper.eq(Comment::getLevel, 1);
        List<Comment> comments = commentMapper.selectList(queryWrapper);
        List<CommentVo> commentVoList = copyList(comments);
        return Result.success(commentVoList);
    }

    @Override
    public Result comment(CommentParam commentParam) {
        SysUser sysUser = UserThreadLocal.get();
        Comment comment = new Comment();
        comment.setArticleId(commentParam.getArticleId());
        comment.setAuthorId(sysUser.getId());
        comment.setContent(commentParam.getContent());
        comment.setCreateDate(System.currentTimeMillis());
        Long parent = commentParam.getParent();
        if(parent==null ||parent==0){
            comment.setLevel(1);
            comment.setParentId(0L);
        }else {
            comment.setLevel(2);
            comment.setParentId(parent);
        }
        Long toUserId = commentParam.getToUserId();
        comment.setToUid(toUserId==null?0:toUserId);
        this.commentMapper.insert(comment);
        UpdateWrapper<Article> updateWrapper=new UpdateWrapper<>();
        updateWrapper.eq("id",commentParam.getArticleId());
        updateWrapper.setSql(true,"comment_counts=comment_counts+1");
        this.articleMapper.update(null,updateWrapper);
        CommentVo commentVo=copy(comment);
        return Result.success(commentVo);
    }

    private List<CommentVo> copyList(List<Comment> comments) {
        List<CommentVo> commentVoList = new ArrayList<>();
        for (Comment comment : comments) {
            commentVoList.add(copy(comment));
        }
        return commentVoList;
    }

    private CommentVo copy(Comment comment) {
        CommentVo commentVo = new CommentVo();
        BeanUtils.copyProperties(comment, commentVo);
        commentVo.setId(String.valueOf(comment.getId()));
        //作者信息
        SysUser user = sysUserService.findUserById(comment.getAuthorId());
        UserVo userVo = new UserVo();
        BeanUtils.copyProperties(user, userVo);
        userVo.setId(String.valueOf(user.getId()));
        commentVo.setAuthor(userVo);
        //子评论
        Integer level = comment.getLevel();

        Long id = comment.getId();
        List<CommentVo> commentVoList = findCommentsByParentId(id);
        commentVo.setChildrens(commentVoList);

        //to user 给谁评论
        if (level > 1) {
            SysUser user2 = sysUserService.findUserById(comment.getToUid());
            UserVo userVo2 = new UserVo();
            BeanUtils.copyProperties(user2, userVo2);
            commentVo.setToUser(userVo2);
        }
        return commentVo;
    }

    private List<CommentVo> findCommentsByParentId(Long id) {
        LambdaQueryWrapper<Comment> queryWrapper = new LambdaQueryWrapper();
        queryWrapper.eq(Comment::getParentId, id);
        queryWrapper.eq(Comment::getLevel, 2);
        return copyList(commentMapper.selectList(queryWrapper));
    }
}
