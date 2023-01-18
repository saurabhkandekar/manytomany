package com.crossasyst.manyTomany.mapper;

import com.crossasyst.manyTomany.entity.DepartmentEntity;
import com.crossasyst.manyTomany.entity.EmployeeEntity;
import com.crossasyst.manyTomany.model.DepartmentRequest;
import com.crossasyst.manyTomany.model.EmployeeRequest;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-13T15:54:13+0530",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 11.0.9 (Oracle Corporation)"
)
@Component
public class EmployeeMapperImpl implements EmployeeMapper {

    @Override
    public EmployeeEntity modelToEntity(EmployeeRequest employeeRequest) {
        if ( employeeRequest == null ) {
            return null;
        }

        EmployeeEntity employeeEntity = new EmployeeEntity();

        employeeEntity.setFirstName( employeeRequest.getFirstName() );
        employeeEntity.setLastName( employeeRequest.getLastName() );
        employeeEntity.setDepartment( departmentRequestListToDepartmentEntityList( employeeRequest.getDepartment() ) );

        return employeeEntity;
    }

    @Override
    public EmployeeRequest entityToModel(EmployeeEntity employeeEntity) {
        if ( employeeEntity == null ) {
            return null;
        }

        EmployeeRequest employeeRequest = new EmployeeRequest();

        employeeRequest.setFirstName( employeeEntity.getFirstName() );
        employeeRequest.setLastName( employeeEntity.getLastName() );
        employeeRequest.setDepartment( departmentEntityListToDepartmentRequestList( employeeEntity.getDepartment() ) );

        return employeeRequest;
    }

    @Override
    public List<EmployeeRequest> entityToModels(List<EmployeeEntity> employeeEntity) {
        if ( employeeEntity == null ) {
            return null;
        }

        List<EmployeeRequest> list = new ArrayList<EmployeeRequest>( employeeEntity.size() );
        for ( EmployeeEntity employeeEntity1 : employeeEntity ) {
            list.add( entityToModel( employeeEntity1 ) );
        }

        return list;
    }

    protected DepartmentEntity departmentRequestToDepartmentEntity(DepartmentRequest departmentRequest) {
        if ( departmentRequest == null ) {
            return null;
        }

        DepartmentEntity departmentEntity = new DepartmentEntity();

        departmentEntity.setDeptName( departmentRequest.getDeptName() );

        return departmentEntity;
    }

    protected List<DepartmentEntity> departmentRequestListToDepartmentEntityList(List<DepartmentRequest> list) {
        if ( list == null ) {
            return null;
        }

        List<DepartmentEntity> list1 = new ArrayList<DepartmentEntity>( list.size() );
        for ( DepartmentRequest departmentRequest : list ) {
            list1.add( departmentRequestToDepartmentEntity( departmentRequest ) );
        }

        return list1;
    }

    protected DepartmentRequest departmentEntityToDepartmentRequest(DepartmentEntity departmentEntity) {
        if ( departmentEntity == null ) {
            return null;
        }

        DepartmentRequest departmentRequest = new DepartmentRequest();

        departmentRequest.setDeptName( departmentEntity.getDeptName() );

        return departmentRequest;
    }

    protected List<DepartmentRequest> departmentEntityListToDepartmentRequestList(List<DepartmentEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<DepartmentRequest> list1 = new ArrayList<DepartmentRequest>( list.size() );
        for ( DepartmentEntity departmentEntity : list ) {
            list1.add( departmentEntityToDepartmentRequest( departmentEntity ) );
        }

        return list1;
    }
}
