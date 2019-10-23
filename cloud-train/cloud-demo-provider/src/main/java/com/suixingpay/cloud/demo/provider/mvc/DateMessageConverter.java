/**  
 * All rights Reserved, Designed By Suixingpay.
 * @author: renjinhao[ren_jh@suixingpay.com] 
 * @date: 2019年10月23日 上午11:48:35   
 * @Copyright ©2019 Suixingpay. All rights reserved. 
 * 注意：本内容仅限于随行付支付有限公司内部传阅，禁止外泄以及用于其他的商业用途。
 */
package com.suixingpay.cloud.demo.provider.mvc;

import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

/**
 * TODO
 * 
 * @author: renjinhao[ren_jh@suixingpay.com]
 * @date: 2019年10月23日 上午11:48:35
 * @version: V1.0
 * @review: renjinhao[ren_jh@suixingpay.com]/2019年10月23日 上午11:48:35
 */
public class DateMessageConverter implements HttpMessageConverter<Date> {

    private ThreadLocal<SimpleDateFormat> formats = new ThreadLocal<>();

    @Override
    public boolean canRead(Class<?> clazz, MediaType mediaType) {
        return false;
    }

    @Override
    public boolean canWrite(Class<?> clazz, MediaType mediaType) {
        return clazz.equals(Date.class);
    }

    @Override
    public List<MediaType> getSupportedMediaTypes() {
        return Collections.singletonList(MediaType.ALL);
    }

    @Override
    public Date read(Class<? extends Date> clazz, HttpInputMessage inputMessage)
        throws IOException, HttpMessageNotReadableException {
        return null;
    }

    @Override
    public void write(Date t, MediaType contentType, HttpOutputMessage outputMessage)
        throws IOException, HttpMessageNotWritableException {
        SimpleDateFormat format = formats.get();
        if (format == null) {
            format = new SimpleDateFormat("yyyy-MM-dd");
            formats.set(format);
        }
        OutputStream os = outputMessage.getBody();
        os.write(format.format(t).getBytes());
        os.flush();
    }

}
