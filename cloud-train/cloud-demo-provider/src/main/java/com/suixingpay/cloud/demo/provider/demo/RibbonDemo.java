/**  
 * All rights Reserved, Designed By Suixingpay.
 * @author: renjinhao[ren_jh@suixingpay.com] 
 * @date: 2019年10月21日 上午11:30:06   
 * @Copyright ©2019 Suixingpay. All rights reserved. 
 * 注意：本内容仅限于随行付支付有限公司内部传阅，禁止外泄以及用于其他的商业用途。
 */
package com.suixingpay.cloud.demo.provider.demo;

import java.io.IOException;
import java.net.URI;
import java.util.List;
import java.util.Map;

import org.springframework.cloud.netflix.ribbon.StaticServerList;

import com.netflix.client.AbstractLoadBalancerAwareClient;
import com.netflix.client.ClientException;
import com.netflix.client.ClientRequest;
import com.netflix.client.IResponse;
import com.netflix.client.RequestSpecificRetryHandler;
import com.netflix.client.config.DefaultClientConfigImpl;
import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.DynamicServerListLoadBalancer;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;
import com.netflix.loadbalancer.Server;
import com.netflix.loadbalancer.ServerList;
import com.netflix.loadbalancer.ServerListFilter;

/**
 * client模板
 * @formatter:off
 * public class ClientDemo extends AbstractLoadbalancerAwareClient {
 *      
 *      public T executeWithLoadBalancer(final S request, final IClientConfig requestConfig) {
 *          ILoadBalancer loadBalancer = ...;
 *          Server server = loadBalancer.chooseServer(key);
 *          URI finalUri = reconstructURIWithServer(server, request.getUri());
            S requestForServer = (S) request.replaceUri(finalUri);
            return execute(requestForServer, requestConfig);
 *      }
 * }
 * @formatter:on
 * 
 * @author: renjinhao[ren_jh@suixingpay.com]
 * @date: 2019年10月21日 上午11:30:06
 * @version: V1.0
 * @review: renjinhao[ren_jh@suixingpay.com]/2019年10月21日 上午11:30:06
 */
public class RibbonDemo {

    public static void main(String[] args) {
        //@formatter:off
        ServerList<Server> serverList = new StaticServerList<Server>(
            new Server("http", "localhost", 1111),
            new Server("http", "localhost", 2222), 
            new Server("http", "localhost", 3333));
        //@formatter:on
        IPing ping = new IPing() {

            @Override
            public boolean isAlive(Server server) {
                System.out.println("判断" + server.getHostPort() + "是否存活");
                return true;
            }
        };
        IRule rule = new RoundRobinRule();
        ServerListFilter<Server> filter = new ServerListFilter<Server>() {

            @Override
            public List<Server> getFilteredListOfServers(List<Server> servers) {
                return servers;
            }
        };
        @SuppressWarnings("deprecation")
        DynamicServerListLoadBalancer<Server> loadBalancer = new DynamicServerListLoadBalancer<Server>(
            new DefaultClientConfigImpl(), rule, ping, serverList, filter);
        loadBalancer.setPingInterval(5);

        for (int i = 0; i < 10; i++) {
            Server server = loadBalancer.chooseServer(null);
            System.out.println("选择server:" + server.getHostPort());
        }
        ClientDemo demo = new ClientDemo(loadBalancer);
        ClientRequest request = new ClientRequest(URI.create("http:///test/11"));
        for (int i = 0; i < 10; i++) {
            try {
                demo.executeWithLoadBalancer(request);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        loadBalancer.shutdown();
    }

    private static class ClientDemo extends AbstractLoadBalancerAwareClient<ClientRequest, ResponseDemo> {

        public ClientDemo(ILoadBalancer lb) {
            super(lb);
        }

        @Override
        public ResponseDemo execute(ClientRequest request, IClientConfig requestConfig) throws Exception {
            System.out.println("发送请求：" + request.getUri().toString());
            return null;
        }

        @Override
        public RequestSpecificRetryHandler getRequestSpecificRetryHandler(ClientRequest request,
            IClientConfig requestConfig) {
            return null;
        }

    }

    private static class ResponseDemo implements IResponse {

        @Override
        public void close() throws IOException {}

        @Override
        public Object getPayload() throws ClientException {
            return null;
        }

        @Override
        public boolean hasPayload() {
            return false;
        }

        @Override
        public boolean isSuccess() {
            return false;
        }

        @Override
        public URI getRequestedURI() {
            return null;
        }

        @Override
        public Map<String, ?> getHeaders() {
            return null;
        }

    }
}
