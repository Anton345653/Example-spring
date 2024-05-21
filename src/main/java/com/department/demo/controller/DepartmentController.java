package com.department.demo.controller;

import com.department.demo.dto.DepartmentDto;
import com.department.demo.service.DepartmentService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/departments")
@RequiredArgsConstructor
@Slf4j
public class DepartmentController {

    private final DepartmentService departmentService;

    @GetMapping("/{id}")
    @Tag(name = "получение department")
    public DepartmentDto getDepartment(@PathVariable Long id){
        log.info("запрос для получения");
        return departmentService.getDepartment(id);
    }

    @PostMapping
    @Tag(name = "сохранение department")
    public Long saveOrUpdateDepartment(@RequestBody DepartmentDto dto){
        log.info("запрос для сохранения");
        return departmentService.saveOrUpdateDepartment(dto);
    }

    @DeleteMapping("/{id}")
    @Tag(name = "удаление department")
    public void deleteDepartment(@PathVariable Long id){
        log.info("запрос на удаление");
        departmentService.deleteDepartment(id);
    }
}
