package org.example.springcloud.controller;

import org.example.springcloud.entity.CommonResult;
import org.example.springcloud.service.StorageService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Classname StorageController
 * @Description TODO
 * @Date 2021/6/8 10:19
 * @Created by wangjianping
 */
@RestController
public class StorageController {
    @Resource
    private StorageService storageService;
    @PostMapping(value = "/storage/decrease")
    public CommonResult decrease(@RequestParam("productId") Long productId, @RequestParam("count")Integer count) {
        storageService.decrease(productId,count);
        return new CommonResult(200,"库存扣款成功");
    }
}
