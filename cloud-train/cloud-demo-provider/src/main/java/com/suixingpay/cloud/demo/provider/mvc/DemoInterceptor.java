/**  
 * All rights Reserved, Designed By Suixingpay.
 * @author: renjinhao[ren_jh@suixingpay.com] 
 * @date: 2019年10月23日 上午11:08:59   
 * @Copyright ©2019 Suixingpay. All rights reserved. 
 * 注意：本内容仅限于随行付支付有限公司内部传阅，禁止外泄以及用于其他的商业用途。
 */
package com.suixingpay.cloud.demo.provider.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**  
 * @author: renjinhao[ren_jh@suixingpay.com]
 * @date: 2019年10月23日 上午11:08:59
 * @version: V1.0
 * @review: renjinhao[ren_jh@suixingpay.com]/2019年10月23日 上午11:08:59
 */
public class DemoInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
        throws Exception {
        System.out.println("pre intercept");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
        ModelAndView modelAndView) throws Exception {
        System.out.println("post intercept");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
        throws Exception {
        System.out.println("complete intercept");
    }

}
