package com.csi.service;


import com.csi.model.Employee;

import java.util.List;
import java.util.Optional;

public interface IEmployeeService {

    Employee signup(Employee employee);

    Boolean signin(String empEmailId,String empPassword);

    List<Employee> findAll();

    Optional<Employee> findById(int empId);

    List<Employee> sortBySalary();

    List<Employee> sortByDob();

}
