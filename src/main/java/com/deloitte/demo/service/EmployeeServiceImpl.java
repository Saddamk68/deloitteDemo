package com.deloitte.demo.service;

import com.deloitte.demo.domain.Employee;
import com.deloitte.demo.dto.EmployeeDTO;
import com.deloitte.demo.exception.DBAccessException;
import com.deloitte.demo.exception.ResourceNotFoundException;
import com.deloitte.demo.mapper.EmployeeMapper;
import com.deloitte.demo.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeMapper mapper;

    @Override
    public Mono<EmployeeDTO> createEmployee(Employee employeeDetails) {
        Employee employee = employeeRepository.save(employeeDetails).block();
        return Mono.just(mapper.employeeToEmployeeDTO(employee));
    }

    @Override
    public Mono<EmployeeDTO> getEmployeeById(Long id) {
        return employeeRepository.findById(id)
                .map(mapper::employeeToEmployeeDTO)
                .switchIfEmpty(Mono.error(new ResourceNotFoundException(String.format("Employee details not found for given id : %s", id))))
                .onErrorMap(e -> new DBAccessException("Error occurred while accessing the repository : " + e.getMessage()));
    }

    @Override
    public Flux<EmployeeDTO> getEmployeeByDepartment(String department) {
        return employeeRepository.findByDepartment(department)
                .switchIfEmpty(Flux.error(new ResourceNotFoundException(String.format("Employee details not found for given department : %s", department))))
                .map(mapper::employeeToEmployeeDTO)
                .onErrorMap(e -> new DBAccessException("Error occurred while accessing the repository : " + e.getMessage()));
    }

}
