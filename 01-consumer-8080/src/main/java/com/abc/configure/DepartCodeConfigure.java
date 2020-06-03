package com.abc.configure;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

//容器类
@Controller
public class DepartCodeConfigure {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
