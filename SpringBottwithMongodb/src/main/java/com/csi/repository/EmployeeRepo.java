package com.csi.repository;


import com.csi.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends MongoRepository<Employee,Integer> {

    Employee findByEmpEmailIdAndEmpPassword(String empName);

}
