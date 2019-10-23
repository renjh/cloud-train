/**  
 * All rights Reserved, Designed By Suixingpay.
 * @author: renjinhao[ren_jh@suixingpay.com] 
 * @date: 2019年10月23日 上午10:10:11   
 * @Copyright ©2019 Suixingpay. All rights reserved. 
 * 注意：本内容仅限于随行付支付有限公司内部传阅，禁止外泄以及用于其他的商业用途。
 */
package com.suixingpay.cloud.demo.provider.mvc;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author: renjinhao[ren_jh@suixingpay.com]
 * @date: 2019年10月23日 上午10:10:11
 * @version: V1.0
 * @review: renjinhao[ren_jh@suixingpay.com]/2019年10月23日 上午10:10:11
 */
@Component
@RequestMapping("/demo2")
public class Demo2Controller {

    @GetMapping
    @ResponseBody
    public String demo2() {
        return "demo2";
    }
}
