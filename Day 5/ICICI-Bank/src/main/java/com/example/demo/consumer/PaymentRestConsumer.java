package com.example.demo.consumer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class PaymentRestConsumer {
	@Autowired
	private DiscoveryClient discoveryClient;
	public String getData()
	{
		//find cart service instance from eureka
		List<ServiceInstance>instances=discoveryClient.getInstances("CART-PAYMENT-SERVICE");
		if(instances==null||instances.isEmpty())
		{
			return "Bank service not found";
		}
		//pick first available instance
		ServiceInstance instance=instances.get(0);
		//create url to call cart-service
		String url=instance.getUri()+"/getPaymentData";
		//call cart services
		RestTemplate restTemplate=new RestTemplate();
		//sync communication
		return restTemplate.getForObject(url, String.class);//data from the cart service come here
				
	}
}
