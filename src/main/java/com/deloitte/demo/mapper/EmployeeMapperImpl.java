package com.deloitte.demo.mapper;

import java.util.ArrayList;
import java.util.List;

import com.deloitte.demo.domain.Employee;
import com.deloitte.demo.dto.EmployeeDTO;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

@Component
public class EmployeeMapperImpl implements EmployeeMapper {

	@Override
	public EmployeeDTO employeeToEmployeeDTO(Employee employee) {
		if (employee != null) {
			EmployeeDTO employeeDto = new EmployeeDTO();

			employeeDto.setId(employee.getId());
			employeeDto.setFirstName(employee.getFirstName());
			employeeDto.setLastName(employee.getLastName());
			employeeDto.setDepartment(employee.getDepartment());
			employeeDto.setRole(employee.getRole());

			return employeeDto;
		}
		return null;
	}

	@Override
	public List<EmployeeDTO> employeeToEmployeeDTOList(List<Employee> employeeList) {
		if (!CollectionUtils.isEmpty(employeeList)) {
			List<EmployeeDTO> employeeDtoList = new ArrayList<>(employeeList.size());

			for (Employee employee : employeeList) {
				employeeDtoList.add(employeeToEmployeeDTO(employee));
			}
			return employeeDtoList;
		}
		return null;
	}

}
