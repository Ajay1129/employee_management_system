package com.example.demo.Service;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Employee;
import com.example.demo.Repository.Dao;
@Service
public class ServiceImpl implements ServiceInterface
{
  @Autowired
	public Dao dao;
	@Override
	public Employee addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return dao.save(employee);
	}

	@Override
	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public Employee getEmployeeId(Long id) {
		// TODO Auto-generated method stub
		 Optional<Employee> emp=dao.findById(id);
		 return emp.get();
	}

	@Override
	public Employee updateEmployee(Long id, Employee updateEmployee) {
		// TODO Auto-generated method stub
		 Employee emply=new Employee();
		 
		 emply.setName(updateEmployee.getName());
		 emply.setDepartment(updateEmployee.getDepartment());
		 emply.setDateofBirth(updateEmployee.getDateofBirth());
		 emply.setEmail(updateEmployee.getEmail());
		  return dao.save(emply);
				
	}

	@Override
	public void deleteEmployee(Long id) 
	{
		// TODO Auto-generated method stub
		dao.deleteById(id);
		
	}

}
