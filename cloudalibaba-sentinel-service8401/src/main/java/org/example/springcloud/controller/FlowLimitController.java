package org.example.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @Classname FlowLimitController
 * @Description TODO
 * @Date 2021/5/20 11:56
 * @Created by wangjianping
 */
@RestController
@Slf4j
public class FlowLimitController {

    @GetMapping("/testA")
    public String testA(){
        //暂停几秒钟线程
            /*try{
                TimeUnit.MILLISECONDS.sleep(800);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
        return "-----------testA";
    }
//    @SentinelResource("testBForTest")
    @GetMapping("/testB")
    public String testB(){
        log.info(Thread.currentThread().getName()+"\t ----testB");
        return "-----------testB";
    }
    @GetMapping("/testD")
    public String testD(){
        //暂停几秒钟线程
        try{
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("testD 测试RT");
        return "----testD";
    }

    @GetMapping("/testE")
    public String testE(){
        log.info("testE 异常比例");
        int age=10/0;
        return "----testE";
    }

    @GetMapping(value = "/testHotKey")
    @SentinelResource(value = "testHotKey",blockHandler = "block_testHotKey")
    public String testHotKey(@RequestParam(value = "p1",required = false) String p1,@RequestParam(value = "p2",required = false) String p2){
        int age=10/0;
        return "-----testHotKey";
    }

    public String block_testHotKey(String p1, String p2, BlockException blockException){
        return "----block_testHotKey,o(╥﹏╥)o    ";//sentinel系统默认提示:Blocked by Sentinel (flow limiting)
    }
}
