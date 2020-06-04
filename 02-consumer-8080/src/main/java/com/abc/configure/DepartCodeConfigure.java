package com.abc.configure;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

//容器类
@Controller
public class DepartCodeConfigure {

    // 哪怕只有一个提供者，也需要负载均衡 （涉及 Ribbon）
    @LoadBalanced
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
