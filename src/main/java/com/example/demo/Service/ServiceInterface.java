package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import com.example.demo.Entity.Employee;

public interface ServiceInterface 
{
    public Employee addEmployee(Employee employee);
    public List<Employee> getAllEmployee();
    public Employee getEmployeeId(Long id);
    public Employee updateEmployee(Long id,Employee updateEmployee);
    public void deleteEmployee(Long id);
}
