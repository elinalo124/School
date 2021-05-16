package com.elina.service.impl;

import com.elina.model.Student;
import com.elina.util.Utility;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudentServiceImplTest {

    /*
    @Test
    @DisplayName("C")
    public void saveStudentTest()
    {
        StudentServiceImpl studentService = new StudentServiceImpl();
        // Create two department and add 2 courses to their list of courses
        Student student1 = Utility.createStudent1();
        Student student2 = Utility.createStudent2();
        studentService.saveStudent(student1);
        studentService.saveStudent(student2);
        List<Student> students = studentService.retrieveAllStudents();
        assertEquals(student1.getFirstName(), students.get(0).getFirstName());
    }


    @Test
    @DisplayName("R")
    public void getStudentTest()
    {
        StudentServiceImpl studentService = new StudentServiceImpl();
        // Create two department and add 2 courses to their list of courses
        Student student1 = Utility.createStudent1();
        Student student2 = Utility.createStudent2();
        studentService.saveStudent(student1);
        studentService.saveStudent(student2);
        List<Student> savedStudents= new LinkedList<>();
        savedStudents.add(student1);
        savedStudents.add(student2);
        List<Student> retrievedStudents = studentService.retrieveAllStudents();
        assertEquals(savedStudents, retrievedStudents);
        assertEquals(student1, studentService.retrieveStudentByID(1).get());
    }

    @Test
    @DisplayName("U")
    public void changeMajorTest()
    {
        StudentServiceImpl studentService = new StudentServiceImpl();
        // Create two department and add 2 courses to their list of courses
        Student student1 = Utility.createStudent1();
        Student student2 = Utility.createStudent2();
        studentService.saveStudent(student1);
        studentService.saveStudent(student2);
        String newMajor = "Fashion design";
        studentService.changeMajor(1, newMajor);
        assertEquals(newMajor, studentService.retrieveStudentByID(1).get().getMajor());
    }

    @Test
    @DisplayName("D")
    public void deleteCourseTest()
    {
        StudentServiceImpl studentService = new StudentServiceImpl();
        // Create two department and add 2 courses to their list of courses
        Student student1 = Utility.createStudent1();
        Student student2 = Utility.createStudent2();
        studentService.saveStudent(student1);
        studentService.saveStudent(student2);
        studentService.deleteStudent(student1);
        List<Student> retrievedStudents = studentService.retrieveAllStudents();
        assertEquals(1, retrievedStudents.size());
    }

     */

}