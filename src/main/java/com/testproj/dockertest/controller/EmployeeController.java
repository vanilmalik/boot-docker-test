package com.testproj.dockertest.controller;

import com.testproj.dockertest.dto.EmployeeDto;
import com.testproj.dockertest.entity.Department;
import com.testproj.dockertest.entity.Employee;
import com.testproj.dockertest.repository.DepartmentRepository;
import com.testproj.dockertest.repository.EmployeeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EmployeeController  {

    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;

    public EmployeeController(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository) {
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
    }

    @GetMapping(value = "/employees/{employeeId}", produces = "application/json")
    public EmployeeDto getEmployee(@PathVariable int employeeId) {
        Employee employee = employeeRepository.findByEmployeeId(employeeId);
        return new EmployeeDto(employee.getEmployeeId(), employee.getName(), employee.getSurname(), employee.getAge(),
                employee.getDepartment().getDepartmentId());
    }

    @DeleteMapping(value = "/employees/{employeeId}")
    public void deleteEmployee(@PathVariable int employeeId) {
        employeeRepository.deleteById(employeeId);
    }

    @GetMapping(value = "/employees")
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees = (List<Employee>) employeeRepository.findAll();
        List<EmployeeDto> employeeDtoList = new ArrayList<>();
        for (Employee employee : employees) {
            employeeDtoList.add(new EmployeeDto(employee.getEmployeeId(), employee.getName(), employee.getSurname(), employee.getAge(),
                    employee.getDepartment().getDepartmentId()));
        }

        return employeeDtoList;
    }

    @PutMapping(value = "/employees/{employeeId}")
    public Employee updateEmployee(@PathVariable int employeeId, @RequestBody EmployeeDto employeeDto) {
        Employee employee = new Employee();
        employee.setEmployeeId(employeeId);
        employee.setName(employeeDto.getName());
        employee.setSurname(employeeDto.getSurname());
        employee.setAge(employeeDto.getAge());
        employee.setDepartment(departmentRepository.findByDepartmentId(employeeDto.getDepartment()));
        employeeRepository.save(employee);
        return employee;
    }
}
