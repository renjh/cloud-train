# 随行付Spring cloud 实现

## 研发专用统一门户

  已经将配置中心、注册中心、中台网关等系统接入到研发专用统一门户，访问地址如下：
  
  * 开发环境：[https://fd-portal-dev.suixingpay.com](https://fd-portal-dev.suixingpay.com) 
  
    172.16.138.138:9450
    
  * 测试环境：[https://fd-portal-test.suixingpay.com](https://fd-portal-test.suixingpay.com) 注意： 开发、测试、RC共用配置中心从此进入
    
    172.16.138.138:9451
  
  * RC环境：[https://fd-portal-rc.suixingpay.com](https://fd-portal-rc.suixingpay.com) 
  
  * 生产环境：[https://fd-portal.suixingpay.com](https://fd-portal.suixingpay.com) 

## 注册中心后端：

* 开发环境： 用户名：admin 密码：123456

  * [http://172.16.138.162:8761](http://172.16.138.162:8761)

  * [http://172.16.138.162:8762/](http://172.16.138.162:8762/)

  * [http://172.16.138.162:8763/](http://172.16.138.162:8763/)

* 测试环境 用户名：admin 密码：123456

  * [http://172.16.138.138:8761/](http://172.16.138.138:8761/)

  * [http://172.16.138.138:8762/](http://172.16.138.138:8762/)

  * [http://172.16.138.138:8763/](http://172.16.138.138:8763/)

* RC环境 用户名：admin 密码：123456

  * [http://172.16.157.148:8761/](http://172.16.157.148:8761/)

  * [http://172.16.157.149:8761/](http://172.16.157.149:8761/)

  * [http://172.16.157.150:8761/](http://172.16.157.150:8761/)

* 生产环境 用户名：admin 密码：root123

  * [http://10.1.5.138:8080/](http://10.1.5.138:8080/)

  * [http://10.1.5.139:8080/](http://10.1.5.139:8080/)

  * [http://10.1.5.140:8080/](http://10.1.5.140:8080/)


## 注册中心前端：

  * 开发环境： [https://eureka-dev.suixingpay.com/](https://eureka-dev.suixingpay.com/) 
  * 测试环境： [https://eureka-test.suixingpay.com/](https://eureka-test.suixingpay.com/) 
  * RC环境： 
   
     IP: 172.16.157.152 
     [http://eureka-rc.suixingpay.com/](http://eureka-rc.suixingpay.com/) 
  * 生产环境  通过[https://fd-portal.suixingpay.com](https://fd-portal.suixingpay.com) 进行访问
    
      1. [http://10.1.5.136](http://10.1.5.136)
      2. [http://10.1.5.137](http://10.1.5.137)
      

## 中台网关管理后台后端：

* 开发环境：[http://172.16.138.139:8761/swagger-ui.html](http://172.16.138.139:8761/swagger-ui.html)
* 测试环境：[http://172.16.138.139:8762/swagger-ui.html](http://172.16.138.139:8762/swagger-ui.html)
* RC环境：[http://172.16.157.154:8080/swagger-ui.html](http://172.16.157.154:8080/swagger-ui.html)
* 生产环境：

   1. [http://10.1.5.128:8080](http://10.1.5.128:8080)
   2. [http://10.1.5.129:8080](http://10.1.5.129:8080)
   3. [http://10.1.5.130:8080](http://10.1.5.130:8080)
  
## 中台网关管理后台前端：

* 开发环境：[https://gateway-admin-dev.suixingpay.com/](https://gateway-admin-dev.suixingpay.com/) 
* 测试环境：[https://gateway-admin-test.suixingpay.com/](https://gateway-admin-test.suixingpay.com/) 
* RC环境：172.16.157.151 [http://gateway-admin-rc.suixingpay.com/](http://gateway-admin-rc.suixingpay.com/)
* 生产环境 通过[https://fd-portal.suixingpay.com](https://fd-portal.suixingpay.com) 进行访问

     [https://gwadmin.suixingpay.com/](https://gwadmin.suixingpay.com/) 
    
      1. [http://10.1.5.134](http://10.1.5.134)
      2. [http://10.1.5.135](http://10.1.5.135)

## 中台网关：

* 开发环境: [http://172.16.138.162:8888/](http://172.16.138.162:8888/)
* 测试环境: [http://172.16.138.138:8888/](http://172.16.138.138:8888/)
* RC环境：

   * [http://172.16.157.155:8888/](http://172.16.157.155:8888/)
   * [http://172.16.157.156:8888/](http://172.16.157.156:8888/)
   * [http://172.16.157.157:8888/](http://172.16.157.157:8888/)
   
   域名：http://gw-rc.suixingpay.com

* 生产环境：

   1. [http://10.1.5.131:8080](http://10.1.5.131:8080)
   2. [http://10.1.5.132:8080](http://10.1.5.132:8080)
   3. [http://10.1.5.133:8080](http://10.1.5.133:8080)
   
   域名：https://gw.suixingpay.com F5 VS地址：10.1.2.64:443


## Spring Cloud Edgware新特性之六：Artifact ID变更

1. spring-cloud-starter-eureka-server —> spring-cloud-starter-netflix-eureka-server
2. spring-cloud-starter-eureka —> spring-cloud-starter-netflix-eureka-client
3. spring-cloud-starter-ribbon —> spring-cloud-starter-netflix-ribbon
4. spring-cloud-starter-hystrix —>spring-cloud-starter-netflix-hystrix
5. spring-cloud-starter-hystrix-dashboard —> spring-cloud-starter-netflix-hystrix-dashboard
6. spring-cloud-starter-turbine —> spring-cloud-starter-netflix-turbine
7. spring-cloud-starter-turbine-stream –> spring-cloud-starter-netflix-turbine-stream
8. spring-cloud-starter-feign —> spring-cloud-starter-openfeign
9. spring-cloud-starter-zuul —> spring-cloud-starter-netflix-zuul
# cloud-train
# cloud-train
