package com.elina.dao.impl;

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

    /*
    @Test
    @DisplayName("C")
    public void saveStudentTest()
    {
        // Create our entity manager
        EntityManager entityManager = JPASessionUtil.getEntityManager("Elina");
        // Create repository
        StudentDAOImpl studentDAOImpl = new StudentDAOImpl(entityManager);
        // Create two department and add 2 courses to their list of courses
        Student student1 = Utility.createStudent1();
        Student student2 = Utility.createStudent2();
        studentDAOImpl.saveElement(student1);
        studentDAOImpl.saveElement(student2);
        List<Student> students = studentDAOImpl.retrieveAllElements();
        assertEquals(student1.getFirstName(), students.get(0).getFirstName());
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
        Student student1 = Utility.createStudent1();
        Student student2 = Utility.createStudent2();
        studentDAOImpl.saveElement(student1);
        studentDAOImpl.saveElement(student2);
        List<Student> savedStudents= new LinkedList<>();
        savedStudents.add(student1);
        savedStudents.add(student2);
        List<Student> retrievedStudents = studentDAOImpl.retrieveAllElements();
        assertEquals(savedStudents, retrievedStudents);
        assertEquals(student1, studentDAOImpl.retrieveElementByID(1).get());
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
        Student student1 = Utility.createStudent1();
        Student student2 = Utility.createStudent2();
        studentDAOImpl.saveElement(student1);
        studentDAOImpl.saveElement(student2);
        String newMajor = "Fashion design";
        studentDAOImpl.changeMajor(1, newMajor);
        assertEquals(newMajor, studentDAOImpl.retrieveElementByID(1).get().getMajor());
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
        Student student1 = Utility.createStudent1();
        Student student2 = Utility.createStudent2();
        studentDAOImpl.saveElement(student1);
        studentDAOImpl.saveElement(student2);
        studentDAOImpl.deleteElement(student1);
        List<Student> retrievedStudents = studentDAOImpl.retrieveAllElements();
        assertEquals(1, retrievedStudents.size());
        entityManager.close();
    }

     */
}