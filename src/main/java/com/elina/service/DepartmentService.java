package com.elina.service;

import com.elina.model.Course;
import com.elina.model.Department;

import java.util.List;
import java.util.Optional;

public interface DepartmentService {

    /*-----CREATE-----*/
    void saveDepartment(Department department);
    /*-----RETRIEVE-----*/
    List<Department> retrieveAllDepartments();
    Optional<Department> retrieveDepartmentByID (int id);
    /*-----UPDATE-----*/
    void updateDepartment(Department department);
    /*-----DELETE-----*/
    void deleteDepartment(Department department);
    /*-----OTHER-----*/
    Optional<Department> getDepartmentByName(String name);
    void addCourse(Integer id, Course course);

}
