/**  
 * All rights Reserved, Designed By Suixingpay.
 * @author: renjinhao[ren_jh@suixingpay.com] 
 * @date: 2019年10月23日 上午10:07:43   
 * @Copyright ©2019 Suixingpay. All rights reserved. 
 * 注意：本内容仅限于随行付支付有限公司内部传阅，禁止外泄以及用于其他的商业用途。
 */
package com.suixingpay.cloud.demo.provider.mvc;

import java.util.Date;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: renjinhao[ren_jh@suixingpay.com]
 * @date: 2019年10月23日 上午10:07:43
 * @version: V1.0
 * @review: renjinhao[ren_jh@suixingpay.com]/2019年10月23日 上午10:07:43
 */
@RestController
public class Demo1Controller {

    @GetMapping("/demo1")
    public String demo1() {
        System.out.println("demo1");
        return "demo1";
    }

    @GetMapping("/argument")
    public void argument(UserInfo userInfo) {
        System.out.println(userInfo.toString());
    }

    @GetMapping("/returnValue")
    public Date returnValue() {
        return new Date();
    }

    @GetMapping("/exp1")
    public void exp1() throws Exception {
        throw new Exception1();
    }

    @GetMapping("/exp2")
    public void exp2() throws Exception {
        throw new Exception2();
    }

    @ExceptionHandler(Exception1.class)
    public String exception1() {
        return "捕获exp1";
    }
}
