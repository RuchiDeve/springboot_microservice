package uruchi.employeeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uruchi.employeeservice.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
