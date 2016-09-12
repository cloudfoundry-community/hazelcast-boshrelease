package com.orange.oss.bosh.deployer;

import javax.net.ssl.HttpsURLConnection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;


@SpringBootApplication
@EnableHystrix
@EnableFeignClients
public class BoshDeployerApplication {

	static {
	    HttpsURLConnection.setDefaultHostnameVerifier((hostname, session) -> hostname.equals("127.0.0.1"));
	}
	
	public static void main(String[] args) {
		SpringApplication.run(BoshDeployerApplication.class, args);
	}
}
