package com.carefirst.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
	
	private long employeeId;
	
	private String firstName;

	private String lastName;

	private String email;
	
	private Date hireDate;	

    private String jobId;    

	private Integer salary;

}
