package com.mohsinkd786;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

@SpringBootApplication
public class SpringCloudFunctionApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudFunctionApplication.class, args);
	}

	@Bean
	public Function<String,String> message(){
		return str -> str.concat(".... Spring Cloud");
	}

	@Bean
	public Supplier<Product> product(){
		return ()-> {
			Product product=new Product();
			product.setId(1);
			product.setName("Iphone 12");

			return product;
		};
	}

	@Bean
	public Consumer<String> getMessage(){
		return msg -> System.out.println(msg);
	}
}
