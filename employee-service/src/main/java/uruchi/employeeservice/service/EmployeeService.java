package uruchi.employeeservice.service;

import uruchi.employeeservice.dto.APIResponseDto;
import uruchi.employeeservice.dto.EmployeeDto;

public interface EmployeeService {
    EmployeeDto saveEmployee(EmployeeDto employeeDto);
    APIResponseDto getEmployeeById(Long employeeId);
}
