package com.yun.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.yun.entity.Article;
import com.yun.mapper.ArticleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @author : ljg
 * @date : 2022/5/24 9:33
 * @description :
 */
@Component
public class ThreadService {

    /**
     *期望操作在线程池中执行，不能影响原有的主线程
     *
     */
    @Autowired
    private ArticleMapper articleMapper;

    @Async("taskExecutor")
    public void updateArticleViewCount(Article article) {
//        article.setViewCounts(article.getViewCounts()+1);
//        articleMapper.updateById(article);
        int viewCounts=article.getViewCounts();
        Article articleUpdate = new Article();
        articleUpdate.setViewCounts(viewCounts+1);
        LambdaUpdateWrapper<Article> updateWrapper=new LambdaUpdateWrapper<>();
        updateWrapper.eq(Article::getId,article.getId());
        //多线程环境下，类似于CAS乐观锁
        updateWrapper.eq(Article::getViewCounts,viewCounts);
        /**
         * 1. 在并发量不大的情况下，可以尝试对viewCount加1后继续去执行update
         * 2.高并发情况下，可以使用redis，Redis的incr是个原子操作，key=>文章Id，value=>viewCount
         * redis> SET page_view 20
         * OK
         * redis> INCR page_view
         * (integer) 21
         * redis> GET page_view    # 数字值在 Redis 中以字符串的形式保存
         * "21"
         */

        //update article set view_count=100 where view_count=99 and id=11
        articleMapper.update(articleUpdate,updateWrapper);

        try {
            Thread.sleep(5000);
            System.out.println("更新完成了");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
