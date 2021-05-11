package com.elina.service;

import com.elina.model.Course;
import com.elina.model.Department;
import com.elina.model.Student;

import java.util.List;
import java.util.Optional;

public interface CourseService {

    /*-----CREATE-----*/
    void saveCourse(Course course);
    /*-----RETRIEVE-----*/
    List<Course> retrieveAllCourses();
    Optional<Course> retrieveCourseByID (int id);
    /*-----UPDATE-----*/
    void updateCourse(Course course);
    /*-----DELETE-----*/
    void deleteDepartment(Department department);
    /*-----OTHER-----*/
    Optional<Course> retrieveCourseByName(String name);
    void addStudent(int id, Student student);
}
