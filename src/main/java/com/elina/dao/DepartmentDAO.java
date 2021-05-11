package com.elina.dao;

import com.elina.model.Course;
import com.elina.model.Department;

import java.util.Optional;

public interface DepartmentDAO extends CRUD<Department> {
    Optional<Department> retrieveDepartmentByName(String name);
    void addCourse(Integer id, Course course);
}