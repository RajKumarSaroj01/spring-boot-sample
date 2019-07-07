package com.example.demo.dao.repo;

import com.example.demo.dao.Department;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by sarojraj on 6/29/2019.
 */
public interface DepartmentRepository extends JpaRepository<Department,Long> {
}
