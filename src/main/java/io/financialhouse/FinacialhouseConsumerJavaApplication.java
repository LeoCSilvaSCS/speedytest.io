package io.financialhouse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class FinacialhouseConsumerJavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinacialhouseConsumerJavaApplication.class, args);
	}

}
