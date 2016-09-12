package com.orange.oss.bosh.deployer.cfbroker.swagger;

import io.swagger.model.CatalogServices;

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
public class CatalogApiController implements CatalogApi {

    public ResponseEntity<CatalogServices> catalog() {
        // do some magic!
        return new ResponseEntity<CatalogServices>(HttpStatus.OK);
    }

}
