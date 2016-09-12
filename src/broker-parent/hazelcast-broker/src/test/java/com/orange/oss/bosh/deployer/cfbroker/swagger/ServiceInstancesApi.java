package com.orange.oss.bosh.deployer.cfbroker.swagger;

import io.swagger.model.Empty;
import io.swagger.model.Service;
import io.swagger.model.DashboardUrl;
import io.swagger.model.UnbindParameters;
import io.swagger.model.Binding;
import io.swagger.model.BindingResponse;
import io.swagger.model.ServicePlan;

import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringBootServerCodegen", date = "2016-06-22T19:08:11.087+02:00")
@Api(value = "service_instances", description = "the service_instances API")
public interface ServiceInstancesApi {

    @ApiOperation(value = "Provisions a service instance", notes = "When the broker receives a provision request from Cloud Controller, it should synchronously take whatever action is necessary to create a new service resource for the developer. The result of provisioning varies by service type, although there are a few common actions that work for many services.", response = DashboardUrl.class)
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "May be returned if the service instance already exists and the requested parameters are identical to the existing service instance. The expected response body is below.", response = DashboardUrl.class),
        @ApiResponse(code = 201, message = "Service instance has been created.", response = DashboardUrl.class),
        @ApiResponse(code = 409, message = "Should be returned if the requested service instance already exists. The expected response body is {}", response = DashboardUrl.class) })
    @RequestMapping(value = "/service_instances/{instance_id}",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.PUT)
    ResponseEntity<DashboardUrl> createServiceInstance(@ApiParam(value = "The instance_id of a service instance is provided by the Cloud Controller. This ID will be used for future requests (bind and deprovision), so the broker must use it to correlate the resource it creates.",required=true ) @PathVariable("instance_id") String instanceId,
        @ApiParam(value = "Service information." ,required=true ) @RequestBody Service service);


    @ApiOperation(value = "Deprovisions a service instance.", notes = "When a broker receives a deprovision request from Cloud Controller, it should delete any resources it created during the provision. Usually this means that all resources are immediately reclaimed for future provisions.", response = Empty.class)
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Service instance was deleted. The expected response body is {}.", response = Empty.class),
        @ApiResponse(code = 410, message = "Should be returned if the binding does not exist. The expected response body is {}.", response = Empty.class) })
    @RequestMapping(value = "/service_instances/{instance_id}",
        produces = { "application/json" }, 
        method = RequestMethod.DELETE)
    ResponseEntity<Empty> deprovisionServiceInstance(@ApiParam(value = "The instance_id of a service instance is provided by the Cloud Controller. This ID will be used for future requests (bind and deprovision), so the broker must use it to correlate the resource it creates.",required=true ) @PathVariable("instance_id") String instanceId,
        @ApiParam(value = "Parameters to identify the service to be deprovisioned" ,required=true ) @RequestBody UnbindParameters deprovisionParameters);


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
        @ApiParam(value = "" ,required=true ) @RequestBody Binding binding);


    @ApiOperation(value = "Unbinds a service", notes = "When a broker receives an unbind request from Cloud Controller, it should delete any resources it created in bind. Usually this means that an application immediately cannot access the resource.", response = Empty.class)
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Binding was deleted. The expected response body is {}.", response = Empty.class),
        @ApiResponse(code = 410, message = "Should be returned if the binding does not exist. The expected response body is {}.", response = Empty.class) })
    @RequestMapping(value = "/service_instances/{instance_id}/service_bindings/{binding_id}",
        produces = { "application/json" }, 
        method = RequestMethod.DELETE)
    ResponseEntity<Empty> serviceUnbind(@ApiParam(value = "The instance_id of a service instance is provided by the Cloud Controller. This ID will be used for future requests (bind and deprovision), so the broker must use it to correlate the resource it creates.",required=true ) @PathVariable("instance_id") String instanceId,
        @ApiParam(value = "The binding_id of a service binding is provided by the Cloud Controller.",required=true ) @PathVariable("binding_id") String bindingId,
        @ApiParam(value = "" ,required=true ) @RequestBody UnbindParameters unbindParameters);


    @ApiOperation(value = "Updating a Service Instance", notes = "Brokers that implement this endpoint can enable users to modify attributes of an existing service instance. The first attribute Cloud Foundry supports users modifying is the service plan. This effectively enables users to upgrade or downgrade their service instance to other plans. To see how users make these requests, [see Managing Services](https://docs.cloudfoundry.org/devguide/services/managing-services.html#update_service).", response = Empty.class)
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "New plan is effective. The expected response body is {}.", response = Empty.class),
        @ApiResponse(code = 422, message = "May be returned if the particular plan change requested is not supported or if the request can not currently be fulfilled due to the state of the instance (eg. instance utilization is over the quota of the requested plan). Broker should include a user-facing message in the body; for details [see Broker Errors](https://docs.cloudfoundry.org/services/api.html#broker-errors).", response = Empty.class) })
    @RequestMapping(value = "/service_instances/{instance_id}",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.PATCH)
    ResponseEntity<Empty> updateServiceInstance(@ApiParam(value = "The instance_id of a service instance is provided by the Cloud Controller. This ID will be used for future requests (bind and deprovision), so the broker must use it to correlate the resource it creates.",required=true ) @PathVariable("instance_id") String instanceId,
        @ApiParam(value = "New Plan information." ,required=true ) @RequestBody ServicePlan plan);

}
