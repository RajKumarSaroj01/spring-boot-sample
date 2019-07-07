package com.example.demo.dao.repo;

/**
 * Created by sarojraj on 6/29/2019.
 */

import com.example.demo.dao.Gender;
import org.springframework.data.jpa.repository.JpaRepository;

public interface   GenderRepository extends JpaRepository<Gender,Long> {
}
