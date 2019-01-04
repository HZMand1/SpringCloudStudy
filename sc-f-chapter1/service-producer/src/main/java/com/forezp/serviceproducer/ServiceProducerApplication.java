package com.forezp.serviceproducer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class ServiceProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceProducerApplication.class, args);
	}

	@RequestMapping("/hello")
	public String index(@RequestParam String name) {
		return "hello "+name+"，this is first messge";
	}

	/**
	 * 假如这个客户端要提供一个getUser的方法
	 * @return
	 */
	@GetMapping(value = "/getUser")
	@ResponseBody
	public Map<String,Object> getUser(@RequestParam Integer id){
		Map<String,Object> data = new HashMap<>();
		data.put("id",id);
		data.put("userName","admin");
		data.put("from","provider-B");//改这里是为了让大家更能理解它负载均衡的机制
		return data;
	}
}

