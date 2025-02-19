package me.alsesn.SecurityAPI.repository;

import me.alsesn.SecurityAPI.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}