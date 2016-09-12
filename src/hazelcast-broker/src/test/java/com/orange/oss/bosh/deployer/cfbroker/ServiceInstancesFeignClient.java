package com.orange.oss.bosh.deployer.cfbroker;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.orange.oss.bosh.deployer.cfbroker.swagger.ServiceInstancesApi;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.model.BindingResponse;
import io.swagger.model.Empty;


/**
 * Cf service broker API Feign description
 * @author poblin-orange
 *
 */
@FeignClient(name="services",url="http://localhost:${server.port}/v2",configuration=com.orange.oss.bosh.brokerfeigncfg.BrokerFeignConfiguration.class)
public interface ServiceInstancesFeignClient extends ServiceInstancesApi {

	/**
	 * added to swagger generated 2.5 stub.
	 * 2.8 introduces async service provisionning. Need to implement getLastOperation verb
	 * see: 
	 */
	
    @ApiOperation(value = "Last operation on a service instance.", notes = "When a broker receives a last_operation request from Cloud Controller, ", response = Empty.class)
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Service instance status. The expected response body is  is {}.", response = LastOperationResponse.class),
        @ApiResponse(code = 410, message = "Appropriate only for asynchronous delete requests. Cloud Foundry will consider this response a success and remove the resource from its database. The expected response body is {}.", response = Empty.class) })
    @RequestMapping(value = "/service_instances/{instance_id}/last_operation",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<LastOperationResponse> lastOperation(@ApiParam(value = "The instance_id of a service instance is provided by the Cloud Controller. This ID will be used for future requests (bind and deprovision), so the broker must use it to correlate the resource it creates.",required=true ) @PathVariable("instance_id") String instanceId
        );


    
    @RequestMapping(value = "/service_instances/{instance_id}",
            produces = { "application/json" }, 
            method = RequestMethod.DELETE)
        ResponseEntity<Empty> deprovisionServiceInstance(@ApiParam(value = "The instance_id of a service instance is provided by the Cloud Controller. This ID will be used for future requests (bind and deprovision), so the broker must use it to correlate the resource it creates.",required=true ) @PathVariable("instance_id") String instanceId,
            @ApiParam(value = "Parameters to identify the service_id" ,required=true ) @RequestParam("service_id") String service_id,
            @ApiParam(value = "Parameters to identify the plan_id" ,required=true ) @RequestParam("plan_id") String plan_id,
            @ApiParam(value = "Parameters to identify if accept incomplete" ,required=false ) @RequestParam("accepts_incomplete") Boolean accepts_incomplete
        		);

    //@Override patch for api 2.8
    @ApiOperation(value = "Binds to a service", notes = "When the broker receives a bind request from the Cloud Controller, it should return information which helps an application to utilize the provisioned resource. This information is generically referred to as credentials. Applications should be issued unique credentials whenever possible, so one application access can be revoked without affecting other bound applications. For more information on credentials, [see Binding Credentials](https://docs.cloudfoundry.org/services/binding-credentials.html).", response = BindingResponse.class)
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "May be returned if the binding already exists and the requested parameters are identical to the existing binding.", response = BindingResponse.class),
        @ApiResponse(code = 201, message = "Binding has been created.", response = BindingResponse.class),
        @ApiResponse(code = 409, message = "Should be returned if the requested binding already exists. The expected response body is {}, though the description field can be used to return a user-facing error message, as described in Broker Errors.", response = BindingResponse.class) })
    @RequestMapping(value = "/service_instances/{instance_id}/service_bindings/{binding_id}",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.PUT)
    ResponseEntity<BindingResponse> serviceBind(@ApiParam(value = "The instance_id of a service instance is provided by the Cloud Controller. This ID will be used for future requests (bind and deprovision), so the broker must use it to correlate the resource it creates.",required=true ) @PathVariable("instance_id") String instanceId,
        @ApiParam(value = "The binding_id of a service binding is provided by the Cloud Controller.",required=true ) @PathVariable("binding_id") String bindingId,
        @ApiParam(value = "" ,required=true ) @RequestBody Binding28 binding);

    
    
}
