package Service;

import Entities.Course;
import Entities.Student;
import Util.JPASessionUtil;
import Util.Utility;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CourseDAOTest {


    @Test
    @DisplayName("C")
    public void saveCourseTest()
    {
        // Create our entity manager
        EntityManager entityManager = JPASessionUtil.getEntityManager("Elina");
        // Create repository
        CourseDAO courseDAO = new CourseDAO(entityManager);
        // Create two department and add 2 courses to their list of courses
        Course course1 = Utility.createCourse1();
        Course course2 = Utility.createCourse2();
        courseDAO.saveCourse(course1);
        courseDAO.saveCourse(course2);
        List<Course> courses = courseDAO.getAllCourses();
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
        CourseDAO courseDAO = new CourseDAO(entityManager);
        // Create two department and add 2 courses to their list of courses
        Course course1 = Utility.createCourse1();
        Course course2 = Utility.createCourse2();
        courseDAO.saveCourse(course1);
        courseDAO.saveCourse(course2);
        List savedCourses= new LinkedList();
        savedCourses.add(course1);
        savedCourses.add(course2);
        List<Course> retrievedCourses = courseDAO.getAllCourses();
        assertEquals(savedCourses, retrievedCourses);
        assertEquals(course1,courseDAO.getCourseById(1).get());
        assertEquals(course1,courseDAO.getCourseByName("Course 1").get());
        //assertEquals(course1,courseDAO.getCourseByNameNamedQuery("Course 1").get());
        entityManager.close();
    }


    @Test
    @DisplayName("U")
    public void addStudentTest()
    {
        // Create our entity manager
        EntityManager entityManager = JPASessionUtil.getEntityManager("Elina");
        // Create repository
        CourseDAO courseDAO = new CourseDAO(entityManager);
        // Create two department and add 2 courses to their list of courses
        Course course1 = Utility.createCourse1();
        Course course2 = Utility.createCourse2();
        courseDAO.saveCourse(course1);
        courseDAO.saveCourse(course2);
        courseDAO.addStudent(1, new Student(1, "Elina", "Lo", 1, "Electronic engineering"));
        assertEquals(course1.getStudents(), courseDAO.getCourseById(1).get().getStudents());
        entityManager.close();
    }


}