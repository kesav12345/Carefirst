package com.carefirst.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.carefirst.dto.EmployeeDto;
import com.carefirst.service.EmployeeService;

@RestController
@RequestMapping("/carefirst")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/{id}")
	public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable Long id) {
		return new ResponseEntity<>(employeeService.getEmployeeById(id), HttpStatus.OK);
	}

	@GetMapping("/employees")
	public ResponseEntity<List<EmployeeDto>> getEmployees(@RequestParam(name = "id", required = false) Long id) {
		if (id == null) {
			return new ResponseEntity<>(employeeService.getEmployees(), HttpStatus.OK);
		}
		List<EmployeeDto> list = new ArrayList<EmployeeDto>();
		list.add(employeeService.getEmployeeById(id));
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@GetMapping("/employeesByHireDateDesc")
	public ResponseEntity<List<EmployeeDto>> getEmployeesHireDateDesd() {
		return new ResponseEntity<>(employeeService.getEmployeesHireDateDesd(), HttpStatus.OK);
	}

	@PostMapping()
	public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDTO) throws Exception {		
		return new ResponseEntity<>(employeeService.createEmployee(employeeDTO), HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable Long id, @RequestBody EmployeeDto employee) {
		return new ResponseEntity<>(employeeService.updateEmployee(id, employee), HttpStatus.OK);
	}

}
