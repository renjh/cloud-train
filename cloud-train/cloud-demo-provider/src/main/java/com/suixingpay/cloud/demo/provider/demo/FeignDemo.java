/**  
 * All rights Reserved, Designed By Suixingpay.
 * @author: renjinhao[ren_jh@suixingpay.com] 
 * @date: 2019年10月21日 下午3:33:40   
 * @Copyright ©2019 Suixingpay. All rights reserved. 
 * 注意：本内容仅限于随行付支付有限公司内部传阅，禁止外泄以及用于其他的商业用途。
 */
package com.suixingpay.cloud.demo.provider.demo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import feign.Feign;
import feign.RequestLine;
import lombok.AllArgsConstructor;

/**
 * @author: renjinhao[ren_jh@suixingpay.com]
 * @date: 2019年10月21日 下午3:33:40
 * @version: V1.0
 * @review: renjinhao[ren_jh@suixingpay.com]/2019年10月21日 下午3:33:40
 */
public class FeignDemo {

    public static void main(String[] a) {
        ClientDemo client = Feign.builder().target(ClientDemo.class, "https://www.baidu.com");
        System.out.println(client.baidu());

//        ClientDemo clientSimu = (ClientDemo) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
//            new Class[] { ClientDemo.class }, new FeignSimuInvocationHandler("https://www.baidu.com"));
//        clientSimu.baidu();
    }

    private static interface ClientDemo {

        @RequestLine("GET")
        String baidu();
    }

    @AllArgsConstructor
    private static class FeignSimuInvocationHandler implements InvocationHandler {

        private String url;

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            RequestLine rl = method.getAnnotation(RequestLine.class);
            String verb = rl.value();
            System.out.println("向url=" + url + ",method=" + verb + "发送请求");
            return null;
        }

    }
}
