package com.yun.utils;

import com.alibaba.fastjson.JSON;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.UnsupportedEncodingException;

/**
 * @author : ljg
 * @date : 2022/5/26 17:45
 * @description :
 */
@Component
public class QinUtils {
    public static final String url = "http://qn.gengyun.icu/";


    private String accessKey = "dG65EPqmkIvHCRk6Skcx6LV-v2IQdf05eKjhmvnH";
    private String accessSecretKey = "sCv8qZN1DcVc8qpn2AYx5qI5jPIKPmGvwFiZk9S7";

    public boolean upload(MultipartFile file, String filename) {
        //构造一个带指定 Region 对象的配置类
        Configuration cfg = new Configuration(Region.huabei());
        //...其他参数参考类注释
        UploadManager uploadManager = new UploadManager(cfg);
        //...生成上传凭证，然后准备上传
        String bucket = "yun-image";
        //默认不指定key的情况下，以文件内容的hash值作为文件名
        String key = null;
        try {
            byte[] uploadBytes = file.getBytes();
            Auth auth = Auth.create(accessKey, accessSecretKey);
            String upToken = auth.uploadToken(bucket);
                Response response = uploadManager.put(uploadBytes, filename, upToken);
                //解析上传成功的结果
                DefaultPutRet putRet = JSON.parseObject(response.bodyString(), DefaultPutRet.class);
                System.out.println(putRet.key);
                System.out.println(putRet.hash);
                return true;
            } catch (Exception ex) {
                ex.printStackTrace();

            }
        return false;
        }
}
