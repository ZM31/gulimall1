package com.atguigu.gulimall.product;

import com.aliyun.oss.OSSClient;
import com.atguigu.gulimall.product.entity.BrandEntity;
import com.atguigu.gulimall.product.service.BrandService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class GulimallProductApplicationTests {

    @Autowired
    BrandService brandService;

    @Resource
    OSSClient ossClient;


//    @Test
//    void contextLoads() {
////        BrandEntity brandEntity = new BrandEntity();
////        brandEntity.setDescript("pinpai");
////        brandEntity.setName("小米");
////        brandService.save(brandEntity);
////        System.out.println("保存成功！！1");
//        List<BrandEntity> list = brandService.list(new QueryWrapper<BrandEntity>().eq("brand_id",1L));
//        list.forEach((item)->{
//            System.out.println(item);
//        });
//    }




    @Test
    public void testUpload() throws FileNotFoundException {

        // 上传文件流。
        InputStream inputStream = new FileInputStream("C:\\Users\\17449\\Pictures\\Camera Roll\\微信截图\\微信图片_20220508162416.jpg");
        ossClient.putObject("gulimall-zmm", "problem1.png", inputStream);


        // 关闭OSSClient。
        ossClient.shutdown();

        System.out.println("上传完成...");
    }


}
