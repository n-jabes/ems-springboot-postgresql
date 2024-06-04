package com.Jabes.EMS.repository;

import com.Jabes.EMS.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRespository extends JpaRepository <Employee, Long> {
}
