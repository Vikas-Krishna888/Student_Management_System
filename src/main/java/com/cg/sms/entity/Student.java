package com.cg.sms.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="STUDENT")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(value= {"id","department"},allowGetters=true)
public class Student {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message="firstName must not be null and empty")
	@Column(name="FIRST_NAME")
	private String firstName;
	
	@NotBlank(message="lastName must not be null and empty")
	@Column(name="LAST_NAME")
	private String lastName;
	
	@Email
	@NotBlank(message="email must not be null and empty")
	@Column(name="EMAIL")
	private String email;
	
	@Pattern(regexp="\\d{3}-\\d{3}-\\d{4}")
	@Column(name="PHONE_NUMBER")
	private String phoneNumber;
	
	/*@NotBlank(message="department must not be null and empty")
	@Column(name="DEPARTMENT_NAME")
	private String departmentName;*/
	
	//@Column(name="DEPARTMENT_ID")
	@OneToOne(cascade=CascadeType.DETACH)
	private Department department;
}
