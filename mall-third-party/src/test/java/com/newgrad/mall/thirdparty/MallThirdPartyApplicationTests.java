package com.newgrad.mall.thirdparty;

import com.aliyun.oss.OSSClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

@SpringBootTest
class MallThirdPartyApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private OSSClient ossClient;

    @Test
    void uploadFile() throws FileNotFoundException {

//        String endpoint = "oss-us-west-1.aliyuncs.com";
//        // 阿里云账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM用户进行API访问或日常运维，请登录RAM控制台创建RAM用户。
//        String accessKeyId = "LTAI5tDo8HRshjvuqJ7hrsRA";
//        String accessKeySecret = "vcQC3J9DvSzsltDwUiQRBp5J8Dq6oB";


        // 创建OSSClient实例。

//        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

        InputStream inputStream = new FileInputStream("C:\\Users\\14055\\Pictures\\2.jpg");
        // 创建PutObject请求。
        ossClient.putObject("mall-newgrad", "test3.jpg", inputStream);

        ossClient.shutdown();

    }
}
