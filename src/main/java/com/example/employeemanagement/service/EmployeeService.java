package com.example.employeemanagement.service;

import com.example.employeemanagement.employee.Employee;
import com.example.employeemanagement.employee.EmployeeRequest;
import com.example.employeemanagement.employee.EmployeeResponse;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private final UtilityService utilityService;
    private final ModelMapper modelMapper;

    public EmployeeService(UtilityService utilityService, ModelMapper modelMapper) {
        this.utilityService = utilityService;
        this.modelMapper = modelMapper;
    }

    public EmployeeResponse preview(EmployeeRequest request) {
        Employee employee = modelMapper.map(request, Employee.class);
        employee.setFullName(utilityService.formatName(employee.getFullName()));
        employee.setEmployeeCode(utilityService.generateEmployeeCode(employee.getFullName()));
        return modelMapper.map(employee, EmployeeResponse.class);
    }
}
