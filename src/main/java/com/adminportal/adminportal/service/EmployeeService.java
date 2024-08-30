package com.adminportal.adminportal.service;

import com.adminportal.adminportal.db.EmployeeRepository;
import com.adminportal.adminportal.exceptions.DataNotFoundException;
import com.adminportal.adminportal.model.Employee;
import com.adminportal.adminportal.entities.EmployeeData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public void createEmployeeData(Employee employee){
        //sanitise inputs here

        System.out.println(employee);

        EmployeeData employeeData = new EmployeeData(
                employee.getOrgId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getUserName(),
                employee.getPassword(),
                employee.getEmail(),
                employee.getTelNo());

        System.out.println(employeeData.getId());

        employeeRepository.save(employeeData);
    }

    public EmployeeData getEmployeeData(long empId) throws DataNotFoundException {
        Optional<EmployeeData> employeeData = employeeRepository.findById(empId);
        if (employeeData.isPresent()){
            return employeeData.get();
        } else {
            throw new DataNotFoundException("No employee found with ID: " + empId);
        }
    }

    public List<EmployeeData> getAllEmployeeDataInOrg(long orgId) {
        return employeeRepository.findAllByOrgId(orgId);
    }

    public List<EmployeeData> getAllEmployeeData(){
        return employeeRepository.findAll();
    }


    public void updateEmployeeData(long empId, Employee empData) throws DataNotFoundException {
        EmployeeData employeeData = getEmployeeData(empId);

        employeeData.setFirstName(empData.getFirstName());
        employeeData.setLastName(empData.getLastName());
        employeeData.setUserName(empData.getUserName());
        employeeData.setPassword(empData.getPassword());
        employeeData.setEmail(empData.getEmail());
        employeeData.setTelNo(empData.getTelNo());

        employeeRepository.save(employeeData);

    }

    public void deleteEmployeeData(long empId){
        employeeRepository.deleteById(empId);
    }
}
