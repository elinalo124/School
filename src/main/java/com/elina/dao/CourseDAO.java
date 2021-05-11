package com.elina.dao;

import com.elina.model.Course;
import com.elina.model.Student;

import java.util.Optional;

public interface CourseDAO extends CRUD<Course>{

    Optional<Course> retrieveCourseByName(String name);
    void addStudent(int id, Student student);


}
