package com.crossasyst.manyTomany.service;

import com.crossasyst.manyTomany.entity.DepartmentEntity;
import com.crossasyst.manyTomany.entity.EmployeeEntity;
import com.crossasyst.manyTomany.mapper.EmployeeMapper;
import com.crossasyst.manyTomany.model.EmployeeRequest;
import com.crossasyst.manyTomany.model.EmployeeResponse;
import com.crossasyst.manyTomany.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository, EmployeeMapper employeeMapper) {
        this.employeeRepository = employeeRepository;
        this.employeeMapper = employeeMapper;
    }

    public  EmployeeRequest updateEmployee(Long empId, EmployeeRequest employeeRequest) {
        EmployeeEntity employeeEntity = employeeRepository.findById(empId).get();

        employeeEntity=employeeMapper.modelToEntity(employeeRequest);
       employeeRepository.save(employeeEntity);
       return employeeRequest;
    }

    public List<EmployeeRequest> getAllEmployee() {
        List<EmployeeEntity> employeeEntities = employeeRepository.findAll();
        List<EmployeeRequest> employeeRequest = employeeMapper.entityToModels(employeeEntities);
        return employeeRequest;
    }

    public EmployeeRequest getById(Long empId) {
        EmployeeEntity employeeEntity = employeeRepository.findById(empId).get();
        EmployeeRequest employeeRequest = employeeMapper.entityToModel(employeeEntity);
        return employeeRequest;

    }

    public EmployeeResponse createEmployee(EmployeeRequest employeeRequest) {
        EmployeeEntity employeeEntity = employeeRepository.save(employeeMapper.modelToEntity(employeeRequest));
        EmployeeResponse employeeResponse = new EmployeeResponse();
        employeeResponse.setEmpId(employeeEntity.getEmpId());
        return employeeResponse;

    }

    public void deleteEmployee(Long empId) {
        employeeRepository.deleteById(empId);
    }
}
