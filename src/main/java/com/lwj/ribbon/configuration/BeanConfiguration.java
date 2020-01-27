package com.lwj.ribbon.configuration;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * RestTemplate初始化时加上@LoadBalanced可以达到负载均衡以及通过服务名去请求的效果
 * 主要的逻辑就是在请求之前对请求地址进行了替换，或者根据具体的负载均衡策略选择服务地址，然后再去调用
 * 
 * @author linwenjie
 *
 */
@Configuration
public class BeanConfiguration {
	
	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
}
