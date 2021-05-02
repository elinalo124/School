import Entities.Course;
import Entities.Department;
import Service.CourseDAO;
import Service.DepartmentDAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Optional;

public class App {
    public static void main(String[] args){
        // Create our entity manager
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Elina");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        //-----------------------------------------------------------------------------------------
        // Create our repositories
        CourseDAO courseDAO = new CourseDAO(entityManager);
        DepartmentDAO departmentDAO = new DepartmentDAO(entityManager);
        //-----------------------------------------------------------------------------------------

        // Create an department and add 3 courses to his list of courses
        Department department1 = new Department("Department 1");
        department1.addCourse(new Course("Course 1","Maths"));
        department1.addCourse(new Course("Course 2","Physics"));
        department1.addCourse(new Course("Course 3","Electronics"));
        Optional<Department> savedDepartment = departmentDAO.save(department1);
        System.out.println("Saved department: " + savedDepartment.get());

        // Find all departments
        List<Department> departments = departmentDAO.findAll();
        System.out.println("Departments:");
        departments.forEach(System.out::println);
        // Find department by name
        Optional<Department> departmentByName = departmentDAO.findByName("Department 1");
        System.out.println("Searching for an department by name: ");
        departmentByName.ifPresent(System.out::println);
        //-----------------------------------------------------------------------------------------
        // Search for a course by ID
        Optional<Course> foundCourse = courseDAO.findById(2);
        foundCourse.ifPresent(System.out::println);
        // Search for a course with an invalid ID
        Optional<Course> notFoundCourse = courseDAO.findById(99);
        notFoundCourse.ifPresent(System.out::println);
        // List all courses
        List<Course> courses = courseDAO.findAll();
        System.out.println("Courses in database:");
        courses.forEach(System.out::println);
        // Find a course by name
        Optional<Course> queryCourse1 = courseDAO.findByName("Course 2");
        System.out.println("Query for course 2:");
        queryCourse1.ifPresent(System.out::println);
        // Find a course by name using a named query
        Optional<Course> queryCourse2 = courseDAO.findByNameNamedQuery("Course 3");
        System.out.println("Query for course 3:");
        queryCourse2.ifPresent(System.out::println);
        // Add a course to department 1
        Optional<Department> department2 = departmentDAO.findById(1);
        department2.ifPresent(a -> {
            a.addCourse(new Course("Course 4","Circuit Design"));
            System.out.println("Saved author: " + departmentDAO.save(a));
        });
        // Close the entity manager and associated factory
        //-----------------------------------------------------------------------------------------
        entityManager.close();
        entityManagerFactory.close();

    }
}
