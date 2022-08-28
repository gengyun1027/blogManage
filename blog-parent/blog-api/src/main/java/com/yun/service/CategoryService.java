package com.yun.service;

import com.yun.entity.Category;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yun.vo.CategoryVo;
import com.yun.vo.Result;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ljg
 * @since 2022-05-23
 */
public interface CategoryService extends IService<Category> {

    CategoryVo findCategoryById(Long categoryId);

    /**
     * 查询所有的种类
     * @return
     */
    Result findAll();

    /**
     * 查询所有的文章分类细节
     * @return
     */
    Result findAllDetail();

    /**
     * 根据分类查询
     * @param id
     * @return
     */
    Result categoriesDetailById(Long id);
}
