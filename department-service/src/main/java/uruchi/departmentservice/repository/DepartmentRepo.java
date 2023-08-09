package uruchi.departmentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uruchi.departmentservice.entity.Department;

import java.util.List;
import java.util.Optional;

public interface DepartmentRepo extends JpaRepository<Department,Long> {
    //List<Department> findByDepartmentCode(String departmentCode);

    Optional<Department> findByDepartmentCode(String departmentCode);
}
