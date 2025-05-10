package com.carefirst.service;

import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.carefirst.dto.EmployeeDto;
import com.carefirst.entity.Employee;
import com.carefirst.mapper.EmployeeMapper;
import com.carefirst.repo.EmployeeRepo;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepo employeeRepo;

	EmployeeMapper employeeMapper = EmployeeMapper.INSTANCE;

	String regexPattern = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
			+ "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";

	public EmployeeDto getEmployeeById(Long id) {
		Optional<Employee> employee = employeeRepo.findById(id);
		if (employee.isEmpty()) {
			return null;
		}
		Employee emp = employee.get();
		return employeeMapper.entityToEmployee(emp);
	}

	public List<EmployeeDto> getEmployees() {
		return employeeRepo.findAll().stream().map(employeeMapper::entityToEmployee).collect(Collectors.toList());
	}

	public EmployeeDto updateEmployee(Long id, EmployeeDto employeeDTO) {
		Optional<Employee> empDB = employeeRepo.findById(id);
		if (empDB.isPresent()) {
			Employee emp = employeeMapper.dtoToEntity(employeeDTO);
			emp.setEmployeeId(id);
			employeeDTO.setEmployeeId(id);
			employeeRepo.save(emp);
		}
		return employeeDTO;
	}

	public EmployeeDto createEmployee(EmployeeDto employeeDTO) throws Exception {
		boolean validEmail = Pattern.compile(regexPattern).matcher(employeeDTO.getEmail()).matches();
		if (validEmail) {
			Employee emp = employeeMapper.dtoToEntity(employeeDTO);
			employeeRepo.save(emp);
			employeeDTO = employeeMapper.entityToEmployee(emp);
			return employeeDTO;
		}
		else 
			throw new Exception("Invalid Email");
	}

}
