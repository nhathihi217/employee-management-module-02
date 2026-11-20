package com.example.employeemanagement.employee;

import com.example.employeemanagement.service.EmployeeService;
import com.example.employeemanagement.service.UtilityService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;
    private final UtilityService utilityService;

    public EmployeeController(EmployeeService employeeService, UtilityService utilityService) {
        this.employeeService = employeeService;
        this.utilityService = utilityService;
    }

    @PostMapping("/preview")
    public EmployeeResponse preview(@RequestBody EmployeeRequest request) {
        return employeeService.preview(request);
    }

    @GetMapping("/format-name")
    public String formatName(@RequestParam String name) {
        return utilityService.formatName(name);
    }
}
