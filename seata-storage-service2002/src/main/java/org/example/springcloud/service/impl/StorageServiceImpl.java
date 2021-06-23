package org.example.springcloud.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.example.springcloud.dao.StorageDao;
import org.example.springcloud.service.StorageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Classname StorageServiceImpl
 * @Description TODO
 * @Date 2021/6/8 10:19
 * @Created by wangjianping
 */
@Service
@Slf4j
public class StorageServiceImpl implements StorageService {

    @Resource
    private StorageDao storageDao;
    @Override
    public void decrease(Long productId, Integer count) {
        log.info("--->开始扣减库存");
        storageDao.decrease(productId, count);
        log.info("--->扣减库存结束");
    }
}
