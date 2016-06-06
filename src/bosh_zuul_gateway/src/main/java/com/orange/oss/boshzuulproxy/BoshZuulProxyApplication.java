package com.orange.oss.boshzuulproxy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;



@SpringBootApplication
@EnableZuulProxy
public class BoshZuulProxyApplication   {

	public static void main(String[] args) {
		
		
		//can skip ssl validation.
		//get from https://github.com/pivotal-cf/identity-sample-apps/tree/master/authcode/src/main/java/org/cloudfoundry/identity/samples/authcode
		if ("true".equals(System.getenv("SKIP_SSL_VALIDATION"))) {
			SSLValidationDisabler.disableSSLValidation();
		}

		
		SpringApplication.run(BoshZuulProxyApplication.class, args);
	}
	
	
}
