package com.csi.controller;

import com.csi.model.Employee;
import com.csi.service.IEmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@Slf4j
public class EmployeeController {

    @Autowired
    private IEmployeeService employeeService;

    @PostMapping("/signup")
    public ResponseEntity<Employee> signUp(@RequestBody Employee employee){

        log.info("Employee Registered Successfully !");
        return new ResponseEntity<>(employeeService.signup(employee), HttpStatus.CREATED);
    }

    @GetMapping("/signin/{empEmailId}/{empPassword}")
    public ResponseEntity<Boolean> signIn(@PathVariable String empEmailId,@PathVariable String empPassword){

        return new ResponseEntity<>(employeeService.signin(empEmailId,empPassword),HttpStatus.ACCEPTED);
    }

    @GetMapping("/findall")
    public ResponseEntity<List<Employee>> findAll (){

        return new ResponseEntity<>(employeeService.findAll(),HttpStatus.ACCEPTED);
    }

    @GetMapping("/findbyid/{empId}")
    public ResponseEntity<Employee> findById(@PathVariable int empId){

        Employee emp = employeeService.findById(empId).orElseThrow(()->new RuntimeException("Employee Does not Exist"));
        return new ResponseEntity<>(emp,HttpStatus.OK);

       // return ResponseEntity.ok()
    }

    @GetMapping("/sortbysalary")
    public ResponseEntity<List<Employee>> sortBySalary(){

        return new ResponseEntity<>(employeeService.sortBySalary(),HttpStatus.OK);
    }

    @GetMapping("/sortbydob")
    public ResponseEntity<List<Employee>> sortByDob(){

        return new ResponseEntity<>(employeeService.sortByDob(),HttpStatus.OK);
    }
}
