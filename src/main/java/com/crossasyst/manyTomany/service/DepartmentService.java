//package com.crossasyst.manyTomany.service;
//
//import com.crossasyst.manyTomany.entity.DepartmentEntity;
//import com.crossasyst.manyTomany.mapper.EmployeeMapper;
//import com.crossasyst.manyTomany.model.DepartmentRequest;
//import com.crossasyst.manyTomany.model.DepartmentResponse;
//import com.crossasyst.manyTomany.repository.DepartmentRepository;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class DepartmentService {
//    private final DepartmentRepository departmentRepository;
//    private  final EmployeeMapper employeeMapper;
//
//    public DepartmentService(DepartmentRepository departmentRepository, EmployeeMapper employeeMapper) {
//        this.departmentRepository = departmentRepository;
//        this.employeeMapper = employeeMapper;
//    }
//
//    public List<DepartmentRequest> getAllDepartments() {
//        List<DepartmentEntity> departmentEntities =departmentRepository.findAll();
//        List<DepartmentRequest>departmentRequests =employeeMapper.entityToDeptModels(departmentEntities);
//        return departmentRequests;
//    }
//
//    public DepartmentRequest getByDeptId(Long deptId) {
//        DepartmentEntity departmentEntity = departmentRepository.findById(deptId).get();
//        DepartmentRequest departmentRequest = employeeMapper.entityToDeptModel(departmentEntity);
//        return  departmentRequest;
//    }
//
//
//    public DepartmentResponse createDepartment(DepartmentRequest departmentRequest) {
//        DepartmentEntity departmentEntity =departmentRepository.save(employeeMapper.DeptModelToEntity(departmentRequest));
//        DepartmentResponse departmentResponse = new DepartmentResponse();
//        departmentResponse.setDeptId(departmentEntity.getDeptId());
//        return  departmentResponse;
//    }
//
//    public void deleteDepartment(Long deptId) {
//        departmentRepository.deleteById(deptId);
//    }
//}
//
//
//
