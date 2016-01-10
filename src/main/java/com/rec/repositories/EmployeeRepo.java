package com.rec.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rec.models.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {

}
