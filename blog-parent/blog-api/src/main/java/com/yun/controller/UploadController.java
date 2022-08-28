package com.yun.controller;

import com.yun.utils.QinUtils;
import com.yun.vo.Result;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

/**
 * @author : ljg
 * @date : 2022/5/26 16:48
 * @description :
 */
@RestController
@RequestMapping("upload")
public class UploadController {

    @Autowired
    private QinUtils qinUtils;

    @PostMapping
    public Result upload(@RequestParam("image") MultipartFile file){
        //原始文件名称 比如 a.png
        String originalFilename = file.getOriginalFilename();
        String fileName=UUID.randomUUID().toString()+"."+ StringUtils.substringAfterLast(originalFilename,".");
        //上传到哪？ 七牛云 云服务器（离用户最近的服务器）

        boolean upload = qinUtils.upload(file, fileName);
        if(upload){
            return Result.success(QinUtils.url+fileName);
        }
        return Result.fail(20001,"上传失败");
    }

}
