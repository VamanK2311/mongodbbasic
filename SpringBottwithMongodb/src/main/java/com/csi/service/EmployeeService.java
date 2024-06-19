package com.csi.service;

import com.csi.exception.RecordNotFoud;
import com.csi.model.Employee;
import com.csi.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements IEmployeeService {

    @Autowired
    EmployeeRepo employeeRepo;

    @Override
    public Employee signup(Employee employee) {
        return employeeRepo.save(employee);
    }

    @Override
    public Boolean signin(String empEmailId, String empPassword) {
        return findAll().stream().anyMatch(employee -> employee.getEmpEmailId().equals(empEmailId) && employee.getEmpPassword().equals(empPassword));
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepo.findAll();
    }

    @Override
    public Optional<Employee> findById(int empId) {
        return employeeRepo.findById(empId);
    }

    @Override
    public List<Employee> sortBySalary() {
        return findAll().stream().sorted(Comparator.comparing(Employee::getEmpSalary)).toList();
    }

    @Override
    public List<Employee> sortByDob() {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-mm-yyyy");

        return findAll().stream().sorted(Comparator.comparing(Employee::getEmpDOB)).toList();
    }

}
