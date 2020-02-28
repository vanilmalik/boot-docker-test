package com.testproj.dockertest.repository;

import com.testproj.dockertest.entity.Department;
import com.testproj.dockertest.entity.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

    Employee findByEmployeeId(Integer employeeId);

    List<Employee> findByAge(int age);

    List<Employee> findByDepartment(Department department);
}
