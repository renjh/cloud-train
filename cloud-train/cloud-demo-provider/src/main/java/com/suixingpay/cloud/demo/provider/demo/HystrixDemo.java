/**  
 * All rights Reserved, Designed By Suixingpay.
 * @author: renjinhao[ren_jh@suixingpay.com] 
 * @date: 2019年10月21日 上午10:19:32   
 * @Copyright ©2019 Suixingpay. All rights reserved. 
 * 注意：本内容仅限于随行付支付有限公司内部传阅，禁止外泄以及用于其他的商业用途。
 */
package com.suixingpay.cloud.demo.provider.demo;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandKey;
import com.netflix.hystrix.HystrixCommandProperties;

/**  
 * 结构：以限流为例
 * @formatter:off
 * public String execute() {
 *     ConcurrentHashMap<String, TryableSemaphore> executionSemaphorePerCircuit = new ConcurrentHashMap<String, TryableSemaphore>();
 *     TryableSemaphore semaphore = executionSemaphorePerCircuit.get(commandKey);
 *     if(semaphore.tryAcquire()) {
 *         try {
 *             return run();
 *         } finally {
 *             semaphore.release();
 *         }
 *     } else {
 *         return getFallback();
 *     }
 * }
 * @formatter:on
 * 
 * @author: renjinhao[ren_jh@suixingpay.com]
 * @date: 2019年10月21日 上午10:19:32
 * @version: V1.0
 * @review: renjinhao[ren_jh@suixingpay.com]/2019年10月21日 上午10:19:32
 */
public class HystrixDemo extends HystrixCommand<String> {

    private String commandKey;

    protected HystrixDemo(String commandKey) {
        //@formatter:off
        super(Setter
            .withGroupKey(HystrixCommandGroupKey.Factory.asKey("group"))
            .andCommandKey(HystrixCommandKey.Factory.asKey(commandKey))
            .andCommandPropertiesDefaults(
                HystrixCommandProperties.Setter()
                .withExecutionTimeoutEnabled(false)
                .withExecutionIsolationSemaphoreMaxConcurrentRequests(5)));
        //@formatter:on  
        this.commandKey = commandKey;
    }

    @Override
    protected String run() throws Exception {
        Thread.sleep(10000);
        return commandKey + "success";
    }

    protected String getFallback() {
        return commandKey + "fallback";
    }

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            if (i < 10) {
                new Thread() {

                    public void run() {
                        HystrixDemo command1 = new HystrixDemo("demo1");
                        System.out.println(command1.execute());
                    }
                }.start();
                ;
            } else {
                new Thread() {

                    public void run() {
                        HystrixDemo command2 = new HystrixDemo("demo2");
                        System.out.println(command2.execute());
                    }
                }.start();
            }
        }
    }

}
