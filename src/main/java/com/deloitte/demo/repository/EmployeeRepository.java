package com.deloitte.demo.repository;

import com.deloitte.demo.domain.Employee;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface EmployeeRepository extends ReactiveMongoRepository<Employee, Long> {

    Flux<Employee> findByDepartment(String department);

}
