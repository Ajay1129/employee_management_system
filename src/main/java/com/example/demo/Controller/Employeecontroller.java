package com.example.demo.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Employee;
import com.example.demo.Service.ServiceImpl;

@RestController
@RequestMapping("/employee_manage")
public class Employeecontroller 
{
	@Autowired
	private  ServiceImpl service;
	@PostMapping("/post")
	@PreAuthorize("hasRole('ADMIN')")
	public Employee createEmployee( @RequestBody Employee employee)
	{
		 
		return service.addEmployee(employee);
	}

	@GetMapping("/allemp")
	
	public List<Employee> AllEmployee()
	{
		return  service.getAllEmployee();
	}
	@GetMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public Employee getEmployeebyId(@PathVariable Long id)
	{
		return service.getEmployeeId(id);
	}
	@PutMapping("/update")
	@PreAuthorize("hasRole('ADMIN')")
	public Employee update(@PathVariable long id,@Validated @RequestBody Employee employee)
	{
		return service.updateEmployee(id, employee);
	}
	@DeleteMapping("delete/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public void deleteEmployee(@PathVariable Long id)
	{
		 service.deleteEmployee(id);
	}
}
