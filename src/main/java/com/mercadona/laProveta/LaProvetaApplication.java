package com.mercadona.laProveta;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.http.HttpRequest;


import com.mercadona.laProveta.model.Product;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LaProvetaApplication {

	public static void main(String[] args) {
		SpringApplication.run(LaProvetaApplication.class, args);
	}

}
