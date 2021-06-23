package org.example.springcloud.service;

/**
 * @Classname StorageService
 * @Description TODO
 * @Date 2021/6/8 10:19
 * @Created by wangjianping
 */
public interface StorageService {
    void decrease(Long productId, Integer count);
}
