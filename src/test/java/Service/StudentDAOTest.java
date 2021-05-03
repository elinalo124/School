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

class StudentDAOTest {


    @Test
    @DisplayName("C")
    public void saveStudentTest()
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
    public void getStudentTest()
    {
        // Create our entity manager
        EntityManager entityManager = JPASessionUtil.getEntityManager("Elina");
        // Create repository
        StudentDAO studentDAO = new StudentDAO(entityManager);
        // Create two department and add 2 courses to their list of courses
        Student student1 = new Student(1, "Elina", "Lo", 1, "Electronic engineering");
        Student student2 = new Student(2, "Elisa", "Lo", 2, "Geophysics");
        studentDAO.saveStudent(student1);
        studentDAO.saveStudent(student2);
        List<Student> savedStudents= new LinkedList();
        savedStudents.add(student1);
        savedStudents.add(student2);
        List<Student> retrievedStudents = studentDAO.getAllStudents();
        assertEquals(savedStudents, retrievedStudents);
        assertEquals(student1,studentDAO.getStudentById(1).get());
        entityManager.close();
    }

    @Test
    @DisplayName("U")
    public void changeMajorTest()
    {
        // Create our entity manager
        EntityManager entityManager = JPASessionUtil.getEntityManager("Elina");
        // Create repository
        StudentDAO studentDAO = new StudentDAO(entityManager);
        // Create two department and add 2 courses to their list of courses
        Student student1 = new Student(1, "Elina", "Lo", 1, "Electronic engineering");
        Student student2 = new Student(2, "Elisa", "Lo", 2, "Geophysics");
        studentDAO.saveStudent(student1);
        studentDAO.saveStudent(student2);
        String newMajor = "Fashion design";
        studentDAO.changeMajor(1, newMajor);
        assertEquals(newMajor, studentDAO.getStudentById(1).get().getMajor());
        entityManager.close();
    }

    @Test
    @DisplayName("D")
    public void deleteCourseTest()
    {
        // Create our entity manager
        EntityManager entityManager = JPASessionUtil.getEntityManager("Elina");
        // Create repository
        StudentDAO studentDAO = new StudentDAO(entityManager);
        // Create two department and add 2 courses to their list of courses
        Student student1 = new Student(1, "Elina", "Lo", 1, "Electronic engineering");
        Student student2 = new Student(2, "Elisa", "Lo", 2, "Geophysics");
        studentDAO.saveStudent(student1);
        studentDAO.saveStudent(student2);
        studentDAO.deleteStudent(student1);
        List<Student> retrievedStudents = studentDAO.getAllStudents();
        assertEquals(1, retrievedStudents.size());
        entityManager.close();
    }
}