package com.example.demo.Repository;

import org.hamcrest.Matcher;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.Employee;

public interface Dao extends JpaRepository<Employee, Long>
{

	Object save(Matcher<Employee> matcher);



}
