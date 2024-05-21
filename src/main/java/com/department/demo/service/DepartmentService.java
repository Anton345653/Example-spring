package com.department.demo.service;

import com.department.demo.dto.DepartmentDto;
import com.department.demo.mapper.DepartmentMapper;
import com.department.demo.model.Department;
import com.department.demo.repositiry.DepartmentRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final DepartmentMapper departmentMapper;

    @Transactional(readOnly = true)
    public DepartmentDto getDepartment(Long id) {
        Department department = departmentRepository.findById(id).orElseThrow(() -> new EntityNotFoundException());
        log.info("сущность найдена в бд");
        return departmentMapper.toDto(department);
    }

    @Transactional
    public Long saveOrUpdateDepartment(DepartmentDto dto) {
        if (dto.getId() == null) {
            Department department = departmentRepository.save(departmentMapper.toEntity(dto));
            log.info("сущность сохранена");
            return department.getId();
        } else {
            Department department = departmentRepository.findById(dto.getId()).orElseThrow(() -> new EntityNotFoundException());
            department.setName(dto.getName());
            department.setAdress(dto.getAdress());
            log.info("сущность перезаписана");
            return dto.getId();
        }
    }

    @Transactional
    public void deleteDepartment(Long id){
        departmentRepository.deleteById(id);
        log.info("сущность удалена");
    }
}
