package uruchi.employeeservice.service.Impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import uruchi.employeeservice.dto.APIResponseDto;
import uruchi.employeeservice.dto.DepartmentDto;
import uruchi.employeeservice.dto.EmployeeDto;
import uruchi.employeeservice.entity.Employee;
import uruchi.employeeservice.repository.EmployeeRepository;
import uruchi.employeeservice.service.APIClient;
import uruchi.employeeservice.service.EmployeeService;

@Service
@AllArgsConstructor
@Slf4j

public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;

   // private RestTemplate restTemplate;

   // private WebClient webClient;
   private APIClient apiClient;
    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
       log.info("Inside saveEmployee of EmployeeServiceImpl");
        Employee employee = new Employee(
        employeeDto.getId(),
        employeeDto.getFirstName(),
        employeeDto.getLastName(),
        employeeDto.getEmail(),
                employeeDto.getDepartmentCode()
        );
        Employee saveDEmployee = employeeRepository.save(employee);

        EmployeeDto saveDEmployeeDto = new EmployeeDto(
        saveDEmployee.getId(),
        saveDEmployee.getFirstName(),
        saveDEmployee.getLastName(),
        saveDEmployee.getEmail(),
                saveDEmployee.getDepartmentCode()
        );
        return saveDEmployeeDto;
    }
    @Override
    public APIResponseDto getEmployeeById(Long employeeId) {
       Employee employee = employeeRepository.findById(employeeId).get();

       // Microservice communication using RestTemplate
//
//        ResponseEntity<DepartmentDto> responseEntity = restTemplate.getForEntity("http://localhost:9001/departments/"+employee.getDepartmentCode(),
//                DepartmentDto.class);

     //   DepartmentDto departmentDto = responseEntity.getBody();

        // Microservice communication using WebClient

//
        DepartmentDto departmentDto = apiClient.getDepartment(employee.getDepartmentCode());
        log.info("the called department {}", departmentDto);

        EmployeeDto employeeDto = new EmployeeDto(
        employee.getId(),
        employee.getFirstName(),
        employee.getLastName(),
        employee.getEmail(),
                employee.getDepartmentCode()
        );

        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setEmployeeDto(employeeDto);
        apiResponseDto.setDepartmentDto(departmentDto);

        return apiResponseDto;
    }
}
