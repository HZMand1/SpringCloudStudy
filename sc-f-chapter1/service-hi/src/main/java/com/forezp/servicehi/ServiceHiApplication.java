package com.forezp.servicehi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class ServiceHiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceHiApplication.class, args);
	}

	@Value("${server.port}")
	String port;

	@RequestMapping("/hi")
	public String home(@RequestParam(value = "name", defaultValue = "forezp") String name) {
		return "hi " + name + " ,i am from port:" + port;
	}

	/**
	 * 假如这个客户端要提供一个getUser的方法
	 * @return
	 */
	@GetMapping(value = "/getUser")
	@ResponseBody
	public Map<String,Object> getUser(@RequestParam Integer id) {
		Map<String, Object> data = new HashMap<>();
		data.put("id", id);
		data.put("userName", "admin");
		data.put("from", "provider-A");
		return data;
	}
}

