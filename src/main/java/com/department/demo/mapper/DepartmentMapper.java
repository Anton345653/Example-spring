package com.department.demo.mapper;

import com.department.demo.dto.DepartmentDto;
import com.department.demo.model.Department;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DepartmentMapper {

    DepartmentDto toDto(Department department);

    Department toEntity(DepartmentDto dto);
}
