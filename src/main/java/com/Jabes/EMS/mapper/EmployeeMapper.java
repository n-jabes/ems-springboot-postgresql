package com.Jabes.EMS.mapper;

import com.Jabes.EMS.dto.EmployeeDto;
import com.Jabes.EMS.entity.Employee;

public class EmployeeMapper {
    //maping employee entity to employeeDto
    public static EmployeeDto mapToEmployeeDto(Employee employee){
        return new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail()
        );
    }

    //maping the employeeDto to the employee entity
    public static Employee mapToEmployee(EmployeeDto employeeDto){
        return new Employee(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail()
        );
    }
}
