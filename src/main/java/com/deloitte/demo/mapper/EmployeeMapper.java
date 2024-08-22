package com.deloitte.demo.mapper;

import com.deloitte.demo.domain.Employee;
import com.deloitte.demo.dto.EmployeeDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface EmployeeMapper {

	EmployeeDTO employeeToEmployeeDTO(Employee employee);
	
	List<EmployeeDTO> employeeToEmployeeDTOList(List<Employee> employeeList);
	
}
