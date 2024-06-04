package com.Jabes.EMS.service.impl;

import com.Jabes.EMS.dto.EmployeeDto;
import com.Jabes.EMS.entity.Employee;
import com.Jabes.EMS.exception.ResourceNotFoundException;
import com.Jabes.EMS.mapper.EmployeeMapper;
import com.Jabes.EMS.repository.EmployeeRespository;
import com.Jabes.EMS.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRespository employeeRespository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRespository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRespository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("User with id: " +employeeId + " does not exist"));

        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees = employeeRespository.findAll();
        return employees.stream().map((employee) -> EmployeeMapper.mapToEmployeeDto(employee))
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee) {
        Employee employee = employeeRespository.findById(employeeId).orElseThrow(() ->
                new ResourceNotFoundException("Employee with given Id does not exist" + employeeId));

        employee.setFirstName(updatedEmployee.getFirstName());
        employee.setLastName(updatedEmployee.getLastName());
        employee.setEmail(updatedEmployee.getEmail());

        Employee updatedEmployeeObj= employeeRespository.save(employee);

        return EmployeeMapper.mapToEmployeeDto(updatedEmployeeObj);
    }

    @Override
    public void deleteEmployee(Long employeeId) {
        Employee employee = employeeRespository.findById(employeeId).orElseThrow(()-> new ResourceNotFoundException("Employee with provided id does not exist" + employeeId));
        employeeRespository.delete(employee);
    }
}
