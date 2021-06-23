package org.example.springcloud.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.example.springcloud.entity.CommonResult;

/**
 * @Classname CustomerBlockHandler
 * @Description TODO
 * @Date 2021/6/3 19:09
 * @Created by wangjianping
 */
public class CustomerBlockHandler {
    public static CommonResult handlerException(BlockException exception){
        return new CommonResult(444,"自定义异常,global handlerException------1");
    }
    public static CommonResult handlerException2(BlockException exception){
        return new CommonResult(444,"自定义异常,global handlerException-------2");
    }
}
