package com.example.demo.Service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.demo.Repository.Dao;
import com.example.demo.Entity.Employee;
import java.util.List;
import java.util.Random;

public class TestService {

	
	
	
	

	
	    private ServiceImpl employeeService;
	    private Dao employeeRepository;
	    private Random random;

	    @BeforeEach
	    public void setUp() {
	    	Dao employeeRepository ;
	        employeeService = new ServiceImpl();
	        random = new Random(); // For generating random test data
	    }

	    @Test
	    public void testCreateEmployee() {
	        Employee employee = createRandomEmployee();

	        Employee created = employeeService.addEmployee(employee);
	        assertNotNull(created);
	        assertEquals(employee.getName(), created.getName());
	        assertEquals(employee.getEmail(), created.getEmail());
	    }

	    @Test
	    public void testGetAllEmployees() {
	        int numberOfEmployees = 5;
	        for (int i = 0; i < numberOfEmployees; i++) {
	            employeeService.addEmployee(createRandomEmployee());
	        }

	        List<Employee> employees = employeeService.getAllEmployee();
	        assertEquals(numberOfEmployees, employees.size());
	    }

	    @Test
	    public void testGetEmployeeById() {
	        Employee employee = createRandomEmployee();
	        Employee created = employeeService.addEmployee(employee);

	        Employee fetched = employeeService.getEmployeeId(created.getId());
	        assertNotNull(fetched);
	        assertEquals(employee.getName(), fetched.getName());
	    }

	    @Test
	    public void testUpdateEmployee() {
	        Employee employee = createRandomEmployee();
	        Employee created = employeeService.addEmployee(employee);

	        // Create updated details
	        Employee updatedDetails = new Employee();
	        updatedDetails.setId(created.getId());
	        updatedDetails.setName("Updated " + employee.getName());
	        updatedDetails.setEmail("updated." + employee.getEmail());

	        Employee updatedEmployee = employeeService.updateEmployee(created.getId(), updatedDetails);

	        assertNotNull(updatedEmployee);
	        assertEquals(updatedDetails.getName(), updatedEmployee.getName());
	    }

	    @Test
	    public void testDeleteEmployee() {
	        Employee employee = createRandomEmployee();
	        Employee created = employeeService.addEmployee(employee);
	        employeeService.deleteEmployee(created.getId());

	        assertNull(employeeService.getEmployeeId(created.getId())); // Should be null after deletion
	    }

	    private Employee createRandomEmployee() {
	        Employee employee = new Employee();
	        employee.setName("Employee " + random.nextInt(1000)); // Random name
	        employee.setEmail("employee" + random.nextInt(1000) + "@example.com"); // Random email
	        employee.setDateofBirth(java.time.LocalDate.now().minusYears(random.nextInt(30) + 20)); // Random date of birth
	        employee.setDepartment("Department " + random.nextInt(5)); // Random department
	        return employee;
	    }
	

}
