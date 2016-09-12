package com.orange.oss.bosh.deployer.cfbroker;

import java.util.UUID;

import org.fest.assertions.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.orange.oss.bosh.deployer.BoshDeployerApplication;

import io.swagger.model.BindingResponse;
import io.swagger.model.CatalogServices;
import io.swagger.model.DashboardUrl;
import io.swagger.model.Parameter;
import io.swagger.model.Plan;
import io.swagger.model.Service;
import io.swagger.model.Services;
import io.swagger.model.UnbindParameters;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {BoshDeployerApplication.class})
@WebIntegrationTest({"server.port=8080", "management.port=0"})
@ActiveProfiles("integration")

public class BrokerClientIntegrationTest {
	
	private static Logger logger=LoggerFactory.getLogger(BrokerClientIntegrationTest.class);
	
	
	@Autowired
	CatalogFeignClient catalog;
	
	@Autowired
	ServiceInstancesFeignClient services;
	
	
	
	
	@Test
	public void testBrokerLifecycle() throws InterruptedException{
		
		logger.info("catalog");
		ResponseEntity<CatalogServices> cat2=catalog.catalog();
		Assertions.assertThat(cat2).isNotNull();
		
		Services service=cat2.getBody().getServices().get(0);
		Assertions.assertThat(service).isNotNull();
		Assertions.assertThat(service.getBindable()).isTrue();
		
		Plan plan=service.getPlans().get(0);
		Assertions.assertThat(plan.getId()).isNotEmpty();
		
		
		//now create a service instance
		logger.info("service instance creation");		
		String instanceId=UUID.randomUUID().toString();
		String spaceGuid=UUID.randomUUID().toString();
		String organizationGuid=UUID.randomUUID().toString();		
		
		Service srv=new Service();
		//Parameter parameteres;
		//srv.setParameteres(parameteres);
		srv.setPlanId(plan.getId());
		srv.setServiceId(service.getId());

		srv.setOrganizationGuid(organizationGuid);
		srv.setSpaceGuid(spaceGuid);
		ResponseEntity<DashboardUrl> dashboard=services.createServiceInstance(instanceId, srv);

		String url=dashboard.getBody().getDashboardUrl();
		//Assertions.assertThat(url).isNotEmpty();
		
		HttpStatus statusCode=dashboard.getStatusCode();
		Assertions.assertThat(statusCode).isEqualTo(HttpStatus.ACCEPTED); //ie 202, async processing
		
		//now poll until service ready
		String state=LastOperationState.IN_PROGRESS.toString();
		while (state.equals(LastOperationState.IN_PROGRESS.toString())){
			Thread.sleep(2000);//fixed, cf polling frequency is 30s
			ResponseEntity<LastOperationResponse> stateResponse=services.lastOperation(instanceId);
			logger.info("state is : {} : {}",stateResponse.getBody().getState(),stateResponse.getBody().getDescription());
			state=stateResponse.getBody().getState();
		}
		
		Assertions.assertThat(state).isEqualTo(LastOperationState.SUCCEEDED.toString());
		logger.info("Succeeded provisionning service");
		
		//bind the service
		logger.info("service instance bind");		
		String appGuid=UUID.randomUUID().toString();
		
		String bindingId=UUID.randomUUID().toString();
		Binding28 binding=new Binding28();
		binding.setAppGuid(appGuid);
		Parameter parameters=new Parameter();
//		parameters.setName("");
//		parameters.setValue("");
		binding.setParameters(parameters);
		binding.setPlanId(plan.getId());
		binding.setServiceId(service.getId());
		BindResource bindResource=new BindResource();
		bindResource.setAppGuid(appGuid);
		binding.setBindResource(bindResource);
		
		ResponseEntity<BindingResponse> bindingResponse=services.serviceBind(instanceId, bindingId, binding);
		
		
		//check and assert resulting credentials
		String drain=bindingResponse.getBody().getSyslogDrainUrl();
		
		Object credentials=bindingResponse.getBody().getCredentials();
		
		//check dashboard
		
		
		//unbind the services
		logger.info("service instance unbind");		
		
		UnbindParameters unbindParameters=new UnbindParameters();
		unbindParameters.setPlanId(plan.getId());
		unbindParameters.setServiceId(service.getId());
		
		services.serviceUnbind(instanceId, bindingId, unbindParameters);
		
		
		//delete the service instance
		logger.info("delete service instance");
	
		this.services.deprovisionServiceInstance(instanceId, service.getId(),plan.getId(),false); //why required to resend ?
		
		//poll delete done
	}

}
