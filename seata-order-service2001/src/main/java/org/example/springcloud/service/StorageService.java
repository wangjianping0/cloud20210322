package org.example.springcloud.service;

import org.example.springcloud.entity.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Classname StorageService
 * @Description 库存
 * @Date 2021/6/7 16:38
 * @Created by wangjianping
 */
@Component
@FeignClient(value="seata-storage-service")
public interface StorageService {
    @PostMapping(value = "/storage/decrease")
    public CommonResult decrease(@RequestParam("productId") Long productId, @RequestParam("count")Integer count) ;
}
