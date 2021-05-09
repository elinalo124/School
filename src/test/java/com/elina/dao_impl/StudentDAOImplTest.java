package com.elina.dao_impl;

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

class StudentDAOImplTest {

    @Test
    @DisplayName("C")
    public void saveStudentTest()
    {
        // Create our entity manager
        EntityManager entityManager = JPASessionUtil.getEntityManager("Elina");
        // Create repository
        CourseDAOImpl courseDAOImpl = new CourseDAOImpl(entityManager);
        // Create two department and add 2 courses to their list of courses
        Course course1 = Utility.createCourse1();
        Course course2 = Utility.createCourse2();
        courseDAOImpl.saveCourse(course1);
        courseDAOImpl.saveCourse(course2);
        List<Course> courses = courseDAOImpl.getAllCourses();
        assertEquals(course1.getName(), courses.get(0).getName());
        entityManager.close();
    }


    @Test
    @DisplayName("R")
    public void getStudentTest()
    {
        // Create our entity manager
        EntityManager entityManager = JPASessionUtil.getEntityManager("Elina");
        // Create repository
        StudentDAOImpl studentDAOImpl = new StudentDAOImpl(entityManager);
        // Create two department and add 2 courses to their list of courses
        Student student1 = new Student(1, "Elina", "Lo", 1, "Electronic engineering");
        Student student2 = new Student(2, "Elisa", "Lo", 2, "Geophysics");
        studentDAOImpl.saveStudent(student1);
        studentDAOImpl.saveStudent(student2);
        List<Student> savedStudents= new LinkedList<>();
        savedStudents.add(student1);
        savedStudents.add(student2);
        List<Student> retrievedStudents = studentDAOImpl.getAllStudents();
        assertEquals(savedStudents, retrievedStudents);
        assertEquals(student1, studentDAOImpl.getStudentById(1).get());
        entityManager.close();
    }

    @Test
    @DisplayName("U")
    public void changeMajorTest()
    {
        // Create our entity manager
        EntityManager entityManager = JPASessionUtil.getEntityManager("Elina");
        // Create repository
        StudentDAOImpl studentDAOImpl = new StudentDAOImpl(entityManager);
        // Create two department and add 2 courses to their list of courses
        Student student1 = new Student(1, "Elina", "Lo", 1, "Electronic engineering");
        Student student2 = new Student(2, "Elisa", "Lo", 2, "Geophysics");
        studentDAOImpl.saveStudent(student1);
        studentDAOImpl.saveStudent(student2);
        String newMajor = "Fashion design";
        studentDAOImpl.changeMajor(1, newMajor);
        assertEquals(newMajor, studentDAOImpl.getStudentById(1).get().getMajor());
        entityManager.close();
    }

    @Test
    @DisplayName("D")
    public void deleteCourseTest()
    {
        // Create our entity manager
        EntityManager entityManager = JPASessionUtil.getEntityManager("Elina");
        // Create repository
        StudentDAOImpl studentDAOImpl = new StudentDAOImpl(entityManager);
        // Create two department and add 2 courses to their list of courses
        Student student1 = new Student(1, "Elina", "Lo", 1, "Electronic engineering");
        Student student2 = new Student(2, "Elisa", "Lo", 2, "Geophysics");
        studentDAOImpl.saveStudent(student1);
        studentDAOImpl.saveStudent(student2);
        studentDAOImpl.deleteStudent(student1);
        List<Student> retrievedStudents = studentDAOImpl.getAllStudents();
        assertEquals(1, retrievedStudents.size());
        entityManager.close();
    }
}