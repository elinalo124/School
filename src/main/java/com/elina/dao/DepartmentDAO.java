package com.elina.dao;

import com.elina.model.Course;
import com.elina.model.Department;

import java.util.List;
import java.util.Optional;

public interface DepartmentDAO extends CRUD<Department>{
    Optional<Department> getDepartmentByName(String name);
    void addCourse(Integer id, Course course);
}