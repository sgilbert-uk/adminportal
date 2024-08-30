package com.adminportal.adminportal.controller;

import com.adminportal.adminportal.exceptions.DataNotFoundException;
import com.adminportal.adminportal.model.Employee;
import com.adminportal.adminportal.entities.EmployeeData;
import com.adminportal.adminportal.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    public EmployeeService employeeService;

    @PostMapping("/emp/create")
    @CrossOrigin
    public void createEmployeeData(@RequestBody Employee employee){
        employeeService.createEmployeeData(employee);
    }

    @GetMapping("/emp/get/{id}")
    @CrossOrigin
    public EmployeeData getEmployeeData(@PathVariable("id") long empId) throws DataNotFoundException {
        return employeeService.getEmployeeData(empId);
    }

    @GetMapping("/emp/get/all")
    @CrossOrigin
    public List<EmployeeData> getEmployeeData(){
        return employeeService.getAllEmployeeData();
    }

    @GetMapping("/emp/get/all/org/{id}")
    @CrossOrigin
    public List<EmployeeData> getAllEmployeesInOrg(@PathVariable("id") long orgId){
        return employeeService.getAllEmployeeDataInOrg(orgId);
    }


    @PutMapping("/emp/update/{id}")
    @CrossOrigin
    public void updateEmployeeData(@PathVariable("id") long empId, @RequestBody Employee employee) throws DataNotFoundException {
        employeeService.updateEmployeeData(empId,employee);
    }

    @DeleteMapping("/emp/delete/{id}")
    @CrossOrigin
    public void deleteEmployeeData(@PathVariable("id") long empId){
        employeeService.deleteEmployeeData(empId);
    }
}
