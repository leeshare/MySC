package com.abc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// @EnableEurekaClient			//仅限于注册中心是Eureka
// @EnableDiscoveryClient		//注册中心可以是任意的类型
//上面2个注入，是仅限于 Sprint Boot
@SpringBootApplication
public class ApplicationProvider8081 {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationProvider8081.class, args);
	}

}
