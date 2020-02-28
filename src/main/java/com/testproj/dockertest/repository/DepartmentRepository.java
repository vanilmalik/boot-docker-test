package com.testproj.dockertest.repository;

import com.testproj.dockertest.entity.Department;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DepartmentRepository extends CrudRepository<Department, Integer> {

    Department findByDepartmentId(int departmentId);

    List<Department> findByTitle(String title);
}
