package uruchi.employeeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient

public class EmployeeServiceApplication {
	//RestTemplate is used to make calls to other microservices
//	@Bean
//	public RestTemplate restTemplate() {
//		return new RestTemplate();
//	}


 //WebClient is used to make calls to other microservices
//@Bean
//public WebClient webClient() {
//	return WebClient.builder().build();
//}
	public static void main(String[] args) {

		SpringApplication.run(EmployeeServiceApplication.class, args);
	}

}
