package uruchi.departmentservice.service;

import uruchi.departmentservice.dto.DepartmentDto;
import uruchi.departmentservice.entity.Department;

import java.util.List;
import java.util.Optional;

public interface  DepartmentService {
//    DepartmentDto saveDepartment(DepartmentDto departmentDto);
//    List<Department> getDepartmentByCode(String Code);

    //public interface DepartmentService {
        DepartmentDto saveDepartment(DepartmentDto departmentDto);

        Optional<Department> getDepartmentByCode(String code);
    }


