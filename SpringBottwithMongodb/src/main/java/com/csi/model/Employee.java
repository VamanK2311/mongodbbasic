package com.csi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import nonapi.io.github.classgraph.json.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Employee {

    @Id
    private int empId;

    private String empName;

    private double empSalary;

    private long empContact;

    @JsonFormat(pattern = "dd-mm-yyyy")
    private Date empDOB;

    private String empEmailId;

    private String empPassword;

}
