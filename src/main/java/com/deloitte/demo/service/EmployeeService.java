package com.deloitte.demo.service;

import com.deloitte.demo.domain.Employee;
import com.deloitte.demo.dto.EmployeeDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface EmployeeService {

    Mono<EmployeeDTO> createEmployee(Employee employee);

    Mono<EmployeeDTO> getEmployeeById(Long id);

    Flux<EmployeeDTO> getEmployeeByDepartment(String department);

}
