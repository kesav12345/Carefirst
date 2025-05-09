package com.carefirst.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.carefirst.dto.EmployeeDto;
import com.carefirst.entity.Employee;

@Mapper(componentModel = "spring")
public interface EmployeeMapper{
	
	EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);		

	Employee dtoToEntity(EmployeeDto employeeDTO);
	
	EmployeeDto entityToEmployee(Employee employee);
}
