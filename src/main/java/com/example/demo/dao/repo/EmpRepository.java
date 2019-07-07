package com.example.demo.dao.repo;

import com.example.demo.dao.EmpEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by sarojraj on 6/29/2019.
 */
public interface EmpRepository extends JpaRepository<EmpEntity,Long>{
}
