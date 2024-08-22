package com.deloitte.demo.controller;

import com.deloitte.demo.domain.Employee;
import com.deloitte.demo.dto.EmployeeDTO;
import com.deloitte.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping()
    public ResponseEntity<Mono<EmployeeDTO>> createEmployee(@RequestBody Employee employee) {
        return new ResponseEntity<>(employeeService.createEmployee(employee), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mono<EmployeeDTO>> getEmployeeById(@PathVariable(value = "id") Long id) {
        return new ResponseEntity<>(employeeService.getEmployeeById(id), HttpStatus.OK);
    }

    @GetMapping("/department/{departmentName}")
    public ResponseEntity<Flux<EmployeeDTO>> getEmployeeByDepartment(@PathVariable(value = "departmentName") String departmentName) {
        return new ResponseEntity<>(employeeService.getEmployeeByDepartment(departmentName), HttpStatus.OK);
    }

}
