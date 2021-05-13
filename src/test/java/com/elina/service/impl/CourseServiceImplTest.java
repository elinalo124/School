package com.elina.service.impl;

import com.elina.model.Course;
import com.elina.model.Student;
import com.elina.util.Utility;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CourseServiceImplTest {

    @Test
    @DisplayName("C")
    public void saveCourseTest()
    {
        CourseServiceImpl courseService = new CourseServiceImpl();
        // Create two department and add 2 courses to their list of courses
        Course course1 = Utility.createCourse1();
        Course course2 = Utility.createCourse2();
        courseService.saveCourse(course1);
        courseService.saveCourse(course2);
        List<Course> courses = courseService.retrieveAllCourses();
        assertEquals(course1.getName(), courses.get(0).getName());
    }


    @Test
    @DisplayName("R")
    public void getCourseTest()
    {
        CourseServiceImpl courseService = new CourseServiceImpl();
        // Create two department and add 2 courses to their list of courses
        Course course1 = Utility.createCourse1();
        Course course2 = Utility.createCourse2();
        courseService.saveCourse(course1);
        courseService.saveCourse(course2);

        List<Course> savedCourses= new LinkedList<>();
        savedCourses.add(course1);
        savedCourses.add(course2);

        List<Course> retrievedCourses = courseService.retrieveAllCourses();
        assertEquals(savedCourses, retrievedCourses);
        assertEquals(course1, courseService.retrieveCourseByID(1).get());
        assertEquals(course1, courseService.retrieveCourseByName("Course 1").get());
    }


    @Test
    @DisplayName("U")
    public void addStudentTest()
    {
        CourseServiceImpl courseService = new CourseServiceImpl();
        // Create two department and add 2 courses to their list of courses
        Course course1 = Utility.createCourse1();
        Course course2 = Utility.createCourse2();
        courseService.saveCourse(course1);
        courseService.saveCourse(course2);
        courseService.addStudent(1, new Student(1, "Elina", "Lo", 1, "Electronic engineering"));
        assertEquals(course1.getStudents(), courseService.retrieveCourseByID(1).get().getStudents());
    }

    @Test
    @DisplayName("D")
    public void deleteCourseTest()
    {
        CourseServiceImpl courseService = new CourseServiceImpl();
        // Create two department and add 2 courses to their list of courses
        Course course1 = Utility.createCourse1();
        Course course2 = Utility.createCourse2();
        courseService.saveCourse(course1);
        courseService.saveCourse(course2);
        courseService.deleteCourse(course1);
        List<Course> retrievedCourses = courseService.retrieveAllCourses();
        assertEquals(1, retrievedCourses.size());
    }

}