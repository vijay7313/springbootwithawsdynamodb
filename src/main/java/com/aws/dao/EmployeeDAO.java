package com.aws.dao;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.aws.model.EmployeeModel;

@Repository
@EnableScan
public interface EmployeeDAO extends CrudRepository<EmployeeModel, String>{

}
