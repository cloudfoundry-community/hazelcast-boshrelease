package com.orange.oss.bosh.deployer.cfbroker.db;

import org.springframework.data.repository.CrudRepository;

public interface ServiceRepository extends CrudRepository<Instance,String> {


}