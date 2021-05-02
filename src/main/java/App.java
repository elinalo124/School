import Entities.Course;
import Entities.Department;
import Service.CourseService;
import Service.DepartmentService;

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
        CourseService courseService = new CourseService(entityManager);
        DepartmentService departmentService = new DepartmentService(entityManager);
        //-----------------------------------------------------------------------------------------

        // Create an department and add 3 courses to his list of courses
        Department department1 = new Department("Department 1");
        department1.addCourse(new Course("Course 1","Maths"));
        department1.addCourse(new Course("Course 2","Physics"));
        department1.addCourse(new Course("Course 3","Electronics"));
        Optional<Department> savedDepartment = departmentService.save(department1);
        System.out.println("Saved department: " + savedDepartment.get());

        // Find all departments
        List<Department> departments = departmentService.findAll();
        System.out.println("Departments:");
        departments.forEach(System.out::println);
        // Find department by name
        Optional<Department> departmentByName = departmentService.findByName("Department 1");
        System.out.println("Searching for an department by name: ");
        departmentByName.ifPresent(System.out::println);
        //-----------------------------------------------------------------------------------------
        // Search for a course by ID
        Optional<Course> foundCourse = courseService.findById(2);
        foundCourse.ifPresent(System.out::println);
        // Search for a course with an invalid ID
        Optional<Course> notFoundCourse = courseService.findById(99);
        notFoundCourse.ifPresent(System.out::println);
        // List all courses
        List<Course> courses = courseService.findAll();
        System.out.println("Courses in database:");
        courses.forEach(System.out::println);
        // Find a course by name
        Optional<Course> queryCourse1 = courseService.findByName("Course 2");
        System.out.println("Query for course 2:");
        queryCourse1.ifPresent(System.out::println);
        // Find a course by name using a named query
        Optional<Course> queryCourse2 = courseService.findByNameNamedQuery("Course 3");
        System.out.println("Query for course 3:");
        queryCourse2.ifPresent(System.out::println);
        // Add a course to department 1
        Optional<Department> department2 = departmentService.findById(1);
        department2.ifPresent(a -> {
            a.addCourse(new Course("Course 4","Circuit Design"));
            System.out.println("Saved author: " + departmentService.save(a));
        });
        // Close the entity manager and associated factory
        //-----------------------------------------------------------------------------------------
        entityManager.close();
        entityManagerFactory.close();

    }
}
