package com.orange.oss.bosh.deployer.cfbroker;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.orange.oss.bosh.deployer.cfbroker.swagger.CatalogApi;


/**
 * Cf service broker API Feign description
 * @author poblin-orange
 *
 */
@FeignClient(name="catalog",url="http://localhost:${server.port}/v2",configuration=com.orange.oss.bosh.brokerfeigncfg.BrokerFeignConfiguration.class)
public interface CatalogFeignClient extends CatalogApi {


}
