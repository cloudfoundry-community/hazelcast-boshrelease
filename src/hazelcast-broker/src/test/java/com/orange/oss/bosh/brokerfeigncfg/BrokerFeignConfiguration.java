package com.orange.oss.bosh.brokerfeigncfg;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Logger;
import feign.auth.BasicAuthRequestInterceptor;
import feign.slf4j.Slf4jLogger;


/**
 * Specific feign configuration for bosh deployer client broker test
 * @author poblin-orange
 *
 */
@Configuration
public class BrokerFeignConfiguration {

	private static org.slf4j.Logger logger=LoggerFactory.getLogger(BrokerFeignConfiguration.class.getName());
	
	
	@Value("${test.broker.proxyHost}")
	private String proxyHost;
	
	@Value("${test.broker.proxyPort}")	
	private int proxyPort;
	
	
	@Value("${broker.user}")
	String brokerUser;

	@Value("${broker.password}")
	String brokerPassword;


	@Bean
	public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
		return new BasicAuthRequestInterceptor(brokerUser, brokerPassword);
	}
	

	@Bean
	Logger.Level customFeignLoggerLevel() {
		return Logger.Level.FULL;
	}
	@Bean
	Logger customFeignLogger(){
		return new Slf4jLogger();
	}
}
