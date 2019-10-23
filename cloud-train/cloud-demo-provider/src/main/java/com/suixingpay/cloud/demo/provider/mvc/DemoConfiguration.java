/**  
 * All rights Reserved, Designed By Suixingpay.
 * @author: renjinhao[ren_jh@suixingpay.com] 
 * @date: 2019年10月23日 上午10:34:59   
 * @Copyright ©2019 Suixingpay. All rights reserved. 
 * 注意：本内容仅限于随行付支付有限公司内部传阅，禁止外泄以及用于其他的商业用途。
 */
package com.suixingpay.cloud.demo.provider.mvc;

import java.util.List;

import org.springframework.boot.autoconfigure.web.WebMvcRegistrations;
import org.springframework.boot.autoconfigure.web.WebMvcRegistrationsAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

/**
 * @author: renjinhao[ren_jh@suixingpay.com]
 * @date: 2019年10月23日 上午10:34:59
 * @version: V1.0
 * @review: renjinhao[ren_jh@suixingpay.com]/2019年10月23日 上午10:34:59
 */
@Configuration
public class DemoConfiguration {

    @Bean
    public WebMvcRegistrations webMvcRegistrations() {
        return new WebMvcRegistrationsAdapter() {

            @Override
            public RequestMappingHandlerMapping getRequestMappingHandlerMapping() {
                return new RequestMappingHandlerMapping() {

                    @Override
                    protected boolean isHandler(Class<?> beanType) {
                        return AnnotatedElementUtils.hasAnnotation(beanType, Controller.class);
                    }
                };
            }
        };
    }

    @Bean
    public WebMvcConfigurer webMvcConfigurer() {
        return new WebMvcConfigurerAdapter() {

            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(new DemoInterceptor());
            }

            @Override
            public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
                converters.add(new DateMessageConverter());
            }
        };
    }
}
