package com.elina.dao.impl;

import com.elina.model.Course;
import com.elina.model.Student;
import com.elina.util.JPASessionUtil;
import com.elina.util.Utility;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CourseDAOImplTest {
    /*
    @Test
    @DisplayName("C")
    public void saveCourseTest()
    {
        // Create our entity manager
        EntityManager entityManager = JPASessionUtil.getEntityManager("Elina");
        // Create repository
        CourseDAOImpl courseDAOImpl = new CourseDAOImpl(entityManager);
        // Create two department and add 2 courses to their list of courses
        Course course1 = Utility.createCourse1();
        Course course2 = Utility.createCourse2();
        courseDAOImpl.saveElement(course1);
        courseDAOImpl.saveElement(course2);
        List<Course> courses = courseDAOImpl.retrieveAllElements();
        assertEquals(course1.getName(), courses.get(0).getName());
        entityManager.close();
    }


    @Test
    @DisplayName("R")
    public void getCourseTest()
    {
        // Create our entity manager
        EntityManager entityManager = JPASessionUtil.getEntityManager("Elina");
        // Create repository
        CourseDAOImpl courseDAOImpl = new CourseDAOImpl(entityManager);
        // Create two department and add 2 courses to their list of courses
        Course course1 = Utility.createCourse1();
        Course course2 = Utility.createCourse2();
        courseDAOImpl.saveElement(course1);
        courseDAOImpl.saveElement(course2);
        List<Course> savedCourses= new LinkedList<>();
        savedCourses.add(course1);
        savedCourses.add(course2);
        List<Course> retrievedCourses = courseDAOImpl.retrieveAllElements();
        assertEquals(savedCourses, retrievedCourses);
        assertEquals(course1, courseDAOImpl.retrieveElementByID(1).get());
        assertEquals(course1, courseDAOImpl.retrieveCourseByName("Course 1").get());
        //assertEquals(course1,courseDAOImpl.getCourseByNameNamedQuery("Course 1").get());
        entityManager.close();
    }


    @Test
    @DisplayName("U")
    public void addStudentTest()
    {
        // Create our entity manager
        EntityManager entityManager = JPASessionUtil.getEntityManager("Elina");
        // Create repository
        CourseDAOImpl courseDAOImpl = new CourseDAOImpl(entityManager);
        // Create two department and add 2 courses to their list of courses
        Course course1 = Utility.createCourse1();
        Course course2 = Utility.createCourse2();
        courseDAOImpl.saveElement(course1);
        courseDAOImpl.saveElement(course2);
        courseDAOImpl.addStudent(1, new Student(1, "Elina", "Lo", 1, "Electronic engineering"));
        assertEquals(course1.getStudents(), courseDAOImpl.retrieveElementByID(1).get().getStudents());
        entityManager.close();
    }

    @Test
    @DisplayName("D")
    public void deleteCourseTest()
    {
        /// Create our entity manager
        EntityManager entityManager = JPASessionUtil.getEntityManager("Elina");
        // Create repository
        CourseDAOImpl courseDAOImpl = new CourseDAOImpl(entityManager);
        // Create two department and add 2 courses to their list of courses
        Course course1 = new Course(1,"Course 1", "Maths");
        Course course2 = new Course(2,"Course 2", "Physics");
        courseDAOImpl.saveElement(course1);
        courseDAOImpl.saveElement(course2);
        courseDAOImpl.deleteElement(course1);
        List<Course> retrievedCourses = courseDAOImpl.retrieveAllElements();
        assertEquals(1, retrievedCourses.size());
        entityManager.close();
    }

     */
}