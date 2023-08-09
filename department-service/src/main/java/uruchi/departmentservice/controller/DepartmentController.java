package uruchi.departmentservice.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uruchi.departmentservice.dto.DepartmentDto;
import uruchi.departmentservice.entity.Department;
import uruchi.departmentservice.service.DepartmentService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/departments")
@AllArgsConstructor
public class DepartmentController {
    private DepartmentService departmentService;


    //Build save department API
    @PostMapping
    public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto departmentDto) {
        DepartmentDto savedDepartment = departmentService.saveDepartment(departmentDto);
        return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
    }
        //Build get department API
//    @GetMapping("{department-code}")
//        public ResponseEntity<DepartmentDto> getDepartmentByCode(@PathVariable("department-code") String departmentCode){
//            DepartmentDto departmentDto = departmentService.getDepartmentByCode(departmentCode);
//            return new ResponseEntity<>(departmentDto, HttpStatus.OK);

//        @GetMapping("{department-code}")
//    public ResponseEntity<List<DepartmentDto>> getDepartmentsByCode(@PathVariable("department-code") String departmentCode) {
//      //  List<Department> departments = departmentService.getDepartmentsByCode(departmentCode);
//        List<Department> departments = departmentService.getDepartmentByCode(departmentCode);
//        return new ResponseEntity<>(departments, HttpStatus.OK);

    @GetMapping("{department-code}")
    public ResponseEntity<Optional<Department>> getDepartmentsByCode(@PathVariable("department-code") String departmentCode) {
       // List<Department> departments = departmentService.getDepartmentsByCode(departmentCode);
        Optional<Department> departments = departmentService.getDepartmentByCode(departmentCode);
        return new ResponseEntity<>(departments, HttpStatus.OK);
    }



}


