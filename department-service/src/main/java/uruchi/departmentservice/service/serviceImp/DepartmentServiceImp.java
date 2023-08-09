package uruchi.departmentservice.service.serviceImp;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uruchi.departmentservice.dto.DepartmentDto;
import uruchi.departmentservice.entity.Department;
import uruchi.departmentservice.repository.DepartmentRepo;
import uruchi.departmentservice.service.DepartmentService;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor

public class DepartmentServiceImp implements DepartmentService {
    private DepartmentRepo departmentRepo;
    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {

        //convert department dto to department entity

        Department department = new Department(
                departmentDto.getId(),
                departmentDto.getDepartmentName(),
                departmentDto.getDepartmentDescription(),
                departmentDto.getDepartmentCode()
        );

        Department savedDepartment = departmentRepo.save(department);

        DepartmentDto savedDepartmentDto = new DepartmentDto(
                savedDepartment.getId(),
                savedDepartment.getDepartmentName(),
                savedDepartment.getDepartmentDescription(),
                savedDepartment.getDepartmentCode()
        );

        return savedDepartmentDto;
    }

    @Override
    public Optional <Department> getDepartmentByCode(String departmentCode) {
        Optional<Department> departments = departmentRepo.findByDepartmentCode(departmentCode);

//                department.getId(),
//                department.getDepartmentName(),
//                department.getDepartmentDescription(),
//                department.getDepartmentCode()
//        );
      return departments;
    }
}
