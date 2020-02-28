package com.testproj.dockertest;

import com.testproj.dockertest.entity.Department;
import com.testproj.dockertest.entity.Employee;
import com.testproj.dockertest.repository.DepartmentRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@DataJpaTest
class DockertestApplicationTests {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private DepartmentRepository departmentRepository;

	@Test
	public void testFindById() {
		entityManager.persist(new Department("title", "descr"));
		List<Department> departments = departmentRepository.findByTitle("title");
		assertEquals(1, departments.size());
		assertNotNull(departments);
	}

}
