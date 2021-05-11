package com.elina.dao_impl;

import com.elina.model.Course;
import com.elina.model.Student;
import com.elina.model.Teacher;
import com.elina.util.JPASessionUtil;
import com.elina.util.Utility;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TeacherDAOImplTest {

    @Test
    @DisplayName("C")
    public void saveStudentTest()
    {
        // Create our entity manager
        EntityManager entityManager = JPASessionUtil.getEntityManager("Elina");
        // Create repository
        TeacherDAOImpl teacherDAOImpl = new TeacherDAOImpl(entityManager);
        // Create two department and add 2 courses to their list of courses
        Teacher teacher1 = Utility.createTeacher1();
        Teacher teacher2 = Utility.createTeacher2();
        teacherDAOImpl.saveElement(teacher1);
        teacherDAOImpl.saveElement(teacher2);
        List<Teacher> teachers = teacherDAOImpl.retrieveAllElements();
        assertEquals(teacher1.getEducation(), teachers.get(0).getEducation());
        entityManager.close();
    }


    @Test
    @DisplayName("R")
    public void getStudentTest()
    {
        // Create our entity manager
        EntityManager entityManager = JPASessionUtil.getEntityManager("Elina");
        // Create repository
        TeacherDAOImpl teacherDAOImpl = new TeacherDAOImpl(entityManager);
        // Create two department and add 2 courses to their list of courses
        Teacher teacher1 = Utility.createTeacher1();
        Teacher teacher2 = Utility.createTeacher2();
        teacherDAOImpl.saveElement(teacher1);
        teacherDAOImpl.saveElement(teacher2);
        List<Teacher> savedTeachers= new LinkedList<>();
        savedTeachers.add(teacher1);
        savedTeachers.add(teacher2);
        List<Teacher> retrievedTeachers = teacherDAOImpl.retrieveAllElements();
        assertEquals(savedTeachers, retrievedTeachers);
        assertEquals(teacher1, teacherDAOImpl.retrieveElementByID(1).get());
        entityManager.close();
    }

    @Test
    @DisplayName("U")
    public void changeMajorTest()
    {
        // Create our entity manager
        EntityManager entityManager = JPASessionUtil.getEntityManager("Elina");
        // Create repository
        TeacherDAOImpl teacherDAOImpl = new TeacherDAOImpl(entityManager);
        // Create two department and add 2 courses to their list of courses
        Teacher teacher1 = Utility.createTeacher1();
        Teacher teacher2 = Utility.createTeacher2();
        teacherDAOImpl.saveElement(teacher1);
        teacherDAOImpl.saveElement(teacher2);

        CourseDAOImpl courseDAOImpl = new CourseDAOImpl(entityManager);
        Course newCourse= new Course(3,"Course 3", "Electronic Machines");
        courseDAOImpl.saveElement(newCourse);

        teacher1.setCourse(newCourse);
        teacherDAOImpl.updateElement(teacher1);
        assertEquals(newCourse, teacherDAOImpl.retrieveElementByID(1).get().getCourse());
        entityManager.close();
    }

    @Test
    @DisplayName("D")
    public void deleteCourseTest()
    {
        // Create our entity manager
        EntityManager entityManager = JPASessionUtil.getEntityManager("Elina");
        // Create repository
        TeacherDAOImpl teacherDAOImpl = new TeacherDAOImpl(entityManager);
        // Create two department and add 2 courses to their list of courses
        Teacher teacher1 = Utility.createTeacher1();
        Teacher teacher2 = Utility.createTeacher2();
        teacherDAOImpl.saveElement(teacher1);
        teacherDAOImpl.saveElement(teacher2);
        teacherDAOImpl.deleteElement(teacher1);
        List<Teacher> retrievedTeachers = teacherDAOImpl.retrieveAllElements();
        assertEquals(1, retrievedTeachers.size());
        entityManager.close();
    }

}