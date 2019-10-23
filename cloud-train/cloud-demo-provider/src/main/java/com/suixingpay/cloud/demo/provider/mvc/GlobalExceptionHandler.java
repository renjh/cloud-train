/**  
 * All rights Reserved, Designed By Suixingpay.
 * @author: renjinhao[ren_jh@suixingpay.com] 
 * @date: 2019年10月23日 上午10:42:17   
 * @Copyright ©2019 Suixingpay. All rights reserved. 
 * 注意：本内容仅限于随行付支付有限公司内部传阅，禁止外泄以及用于其他的商业用途。
 */
package com.suixingpay.cloud.demo.provider.mvc;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * TODO
 * 
 * @author: renjinhao[ren_jh@suixingpay.com]
 * @date: 2019年10月23日 上午10:42:17
 * @version: V1.0
 * @review: renjinhao[ren_jh@suixingpay.com]/2019年10月23日 上午10:42:17
 */
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception1.class)
    public String exception1() {
        return "全局捕获exp1";
    }

    @ExceptionHandler(Exception2.class)
    public String exception2() {
        return "全局捕获exp2";
    }
}
