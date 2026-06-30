package com.example.demo.consumer;

import java.security.Provider.Service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
public class CartRestConsumer {
	@Autowired
	private DiscoveryClient discoveryClient;
	public String getData()
	{
		//find cart service instance from eureka
		List<ServiceInstance>instances=discoveryClient.getInstances("CART-SERVICE");
		if(instances==null||instances.isEmpty())
		{
			return "Cart service not found";
		}
		//pick first available instance
		ServiceInstance instance=instances.get(0);
		//create url to call cart-service
		String url=instance.getUri()+"/cart/getData";
		//call cart services
		RestTemplate restTemplate=new RestTemplate();
		return restTemplate.getForObject(url, String.class);//data from the cart service come here
				
	}
	
	
}
