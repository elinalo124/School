package com.elina.service_impl;

import com.elina.model.Course;
import com.elina.model.Teacher;
import com.elina.util.Utility;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TeacherServiceImplTest {
    @Test
    @DisplayName("C")
    public void saveStudentTest()
    {
        TeacherServiceImpl teacherService = new TeacherServiceImpl();
        // Create two department and add 2 courses to their list of courses
        Teacher teacher1 = Utility.createTeacher1();
        Teacher teacher2 = Utility.createTeacher2();
        teacherService.saveTeacher(teacher1);
        teacherService.saveTeacher(teacher2);
        List<Teacher> teachers = teacherService.retrieveAllTeachers();
        assertEquals(teacher1.getEducation(), teachers.get(0).getEducation());
    }


    @Test
    @DisplayName("R")
    public void getStudentTest()
    {
        TeacherServiceImpl teacherService = new TeacherServiceImpl();
        // Create two department and add 2 courses to their list of courses
        Teacher teacher1 = Utility.createTeacher1();
        Teacher teacher2 = Utility.createTeacher2();
        teacherService.saveTeacher(teacher1);
        teacherService.saveTeacher(teacher2);
        List<Teacher> savedTeachers= new LinkedList<>();
        savedTeachers.add(teacher1);
        savedTeachers.add(teacher2);
        List<Teacher> retrievedTeachers = teacherService.retrieveAllTeachers();
        assertEquals(savedTeachers, retrievedTeachers);
        assertEquals(teacher1, teacherService.retrieveTeacherByID(1).get());
    }

    @Test
    @DisplayName("U")
    public void changeMajorTest()
    {
        CourseServiceImpl courseService = new CourseServiceImpl();
        Course newCourse= new Course(4,"Course 4", "Electric Machines");
        courseService.saveCourse(newCourse);

        TeacherServiceImpl teacherService = new TeacherServiceImpl();
        // Create two department and add 2 courses to their list of courses
        Teacher teacher1 = Utility.createTeacher1();
        Teacher teacher2 = Utility.createTeacher2();
        teacherService.saveTeacher(teacher1);
        teacherService.saveTeacher(teacher2);

        teacher1.setCourse(newCourse);
        teacherService.updateTeacher(teacher1);
        assertEquals(newCourse, teacherService.retrieveTeacherByID(1).get().getCourse());
    }

    @Test
    @DisplayName("D")
    public void deleteCourseTest()
    {
        TeacherServiceImpl teacherService = new TeacherServiceImpl();
        // Create two department and add 2 courses to their list of courses
        Teacher teacher1 = Utility.createTeacher1();
        Teacher teacher2 = Utility.createTeacher2();
        teacherService.saveTeacher(teacher1);
        teacherService.saveTeacher(teacher2);
        teacherService.deleteTeacher(teacher1);
        List<Teacher> retrievedTeachers = teacherService.retrieveAllTeachers();
        assertEquals(1, retrievedTeachers.size());
    }

}