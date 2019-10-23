/**  
 * All rights Reserved, Designed By Suixingpay.
 * @author: renjinhao[ren_jh@suixingpay.com] 
 * @date: 2019年10月23日 下午2:32:40   
 * @Copyright ©2019 Suixingpay. All rights reserved. 
 * 注意：本内容仅限于随行付支付有限公司内部传阅，禁止外泄以及用于其他的商业用途。
 */
package com.suixingpay.cloud.demo.provider.mvc;

import lombok.Data;

/**
 * TODO
 * 
 * @author: renjinhao[ren_jh@suixingpay.com]
 * @date: 2019年10月23日 下午2:32:40
 * @version: V1.0
 * @review: renjinhao[ren_jh@suixingpay.com]/2019年10月23日 下午2:32:40
 */
@Data
public class UserInfo {

    private String username = "test";
    private String password = "1111";
    private String email = "aaa@suixingpay.com";
    private String mobile = "11111111111";
}
