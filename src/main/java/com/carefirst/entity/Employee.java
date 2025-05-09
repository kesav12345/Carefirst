package com.carefirst.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Employees")
@Data
@NoArgsConstructor
public class Employee {
	
	@Id	
	@GeneratedValue(generator="my_seq")
	@SequenceGenerator(name="my_seq",sequenceName="EMPLOYEES_SEQ", allocationSize=1)
	private long employeeId;
	
	@Column
	private String firstName;

	@Column
	private String lastName;

	@Column
	private String email;
	
	@Column
	private String phoneNumber;
	
    @Temporal(TemporalType.DATE)
    private Date hireDate;
    
    @Column(name = "JOB_ID")
    private String jobId;
	
    @Column
	private Integer salary;
	
}
