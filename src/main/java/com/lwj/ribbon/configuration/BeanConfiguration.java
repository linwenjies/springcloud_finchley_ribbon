package com.lwj.ribbon.configuration;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
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
		SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();  
		requestFactory.setConnectTimeout(500);// 设置超时  
		requestFactory.setReadTimeout(500);  

		//利用复杂构造器可以实现超时设置，内部实际实现为 HttpClient  
		return new RestTemplate(requestFactory);
	}
	
}
