package com.orange.oss.bosh.deployer.cfbroker.swagger;

import io.swagger.model.Empty;
import io.swagger.model.Service;
import io.swagger.model.DashboardUrl;
import io.swagger.model.UnbindParameters;
import io.swagger.model.Binding;
import io.swagger.model.BindingResponse;
import io.swagger.model.ServicePlan;

import io.swagger.annotations.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringBootServerCodegen", date = "2016-06-22T19:08:11.087+02:00")
@Controller
public abstract class ServiceInstancesApiController implements ServiceInstancesApi {

    public ResponseEntity<DashboardUrl> createServiceInstance(@ApiParam(value = "The instance_id of a service instance is provided by the Cloud Controller. This ID will be used for future requests (bind and deprovision), so the broker must use it to correlate the resource it creates.",required=true ) @PathVariable("instanceId") String instanceId,
        @ApiParam(value = "Service information." ,required=true ) @RequestBody Service service) {
        // do some magic!
        return new ResponseEntity<DashboardUrl>(HttpStatus.OK);
    }

    public ResponseEntity<Empty> deprovisionServiceInstance(@ApiParam(value = "The instance_id of a service instance is provided by the Cloud Controller. This ID will be used for future requests (bind and deprovision), so the broker must use it to correlate the resource it creates.",required=true ) @PathVariable("instanceId") String instanceId,
        @ApiParam(value = "Parameters to identify the service to be deprovisioned" ,required=true ) @RequestBody UnbindParameters deprovisionParameters) {
        // do some magic!
        return new ResponseEntity<Empty>(HttpStatus.OK);
    }

    public ResponseEntity<BindingResponse> serviceBind(@ApiParam(value = "The instance_id of a service instance is provided by the Cloud Controller. This ID will be used for future requests (bind and deprovision), so the broker must use it to correlate the resource it creates.",required=true ) @PathVariable("instanceId") String instanceId,
        @ApiParam(value = "The binding_id of a service binding is provided by the Cloud Controller.",required=true ) @PathVariable("bindingId") String bindingId,
        @ApiParam(value = "" ,required=true ) @RequestBody Binding binding) {
        // do some magic!
        return new ResponseEntity<BindingResponse>(HttpStatus.OK);
    }

    public ResponseEntity<Empty> serviceUnbind(@ApiParam(value = "The instance_id of a service instance is provided by the Cloud Controller. This ID will be used for future requests (bind and deprovision), so the broker must use it to correlate the resource it creates.",required=true ) @PathVariable("instanceId") String instanceId,
        @ApiParam(value = "The binding_id of a service binding is provided by the Cloud Controller.",required=true ) @PathVariable("bindingId") String bindingId,
        @ApiParam(value = "" ,required=true ) @RequestBody UnbindParameters unbindParameters) {
        // do some magic!
        return new ResponseEntity<Empty>(HttpStatus.OK);
    }

    public ResponseEntity<Empty> updateServiceInstance(@ApiParam(value = "The instance_id of a service instance is provided by the Cloud Controller. This ID will be used for future requests (bind and deprovision), so the broker must use it to correlate the resource it creates.",required=true ) @PathVariable("instanceId") String instanceId,
        @ApiParam(value = "New Plan information." ,required=true ) @RequestBody ServicePlan plan) {
        // do some magic!
        return new ResponseEntity<Empty>(HttpStatus.OK);
    }

}
