package Service;

import Entities.Course;
import Entities.Department;
import Util.JPASessionUtil;
import Util.Utility;
import org.junit.jupiter.api.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DepartmentDAOTest {

    @Test
    @DisplayName("C")
    public void saveDepartmentTest()
    {
        // Create our entity manager
        EntityManager entityManager = JPASessionUtil.getEntityManager("Elina");
        // Create repository
        DepartmentDAO departmentDAO = new DepartmentDAO(entityManager);
        // Create two department and add 2 courses to their list of courses
        Department department1 = Utility.createDepartment1();
        Department department2 = Utility.createDepartment2();
        departmentDAO.saveDepartment(department1);
        departmentDAO.saveDepartment(department2);
        List<Department> departments = departmentDAO.getAllDepartments();
        assertEquals(department1.getName(), departments.get(0).getName());
        entityManager.close();
    }
    @Test
    @DisplayName("R")
    public void getDepartmentsTest()
    {
        // Create our entity manager
        EntityManager entityManager = JPASessionUtil.getEntityManager("Elina");
        // Create repository
        DepartmentDAO departmentDAO = new DepartmentDAO(entityManager);
        // Create two department and add 2 courses to their list of courses
        Department department1 = Utility.createDepartment1();
        Department department2 = Utility.createDepartment2();
        List savedDepartments = new LinkedList();
        savedDepartments.add(department1);
        savedDepartments.add(department2);
        departmentDAO.saveDepartment(department1);
        departmentDAO.saveDepartment(department2);
        List<Department> retrievedDepartments = departmentDAO.getAllDepartments();
        assertEquals(savedDepartments, retrievedDepartments);
        assertEquals(department1,departmentDAO.getDepartmentById(1).get());
        assertEquals(department1,departmentDAO.getDepartmentByName("Department 1").get());
        entityManager.close();
    }
    @Test
    @DisplayName("U")
    public void addCourseTest()
    {
        // Create our entity manager
        EntityManager entityManager = JPASessionUtil.getEntityManager("Elina");
        // Create repository
        DepartmentDAO departmentDAO = new DepartmentDAO(entityManager);
        // Create two department and add 2 courses to their list of courses
        Department department1 = Utility.createDepartment1();
        Department department2 = Utility.createDepartment2();
        departmentDAO.saveDepartment(department1);
        departmentDAO.saveDepartment(department2);
        departmentDAO.addCourse(1, new Course(4,"Course 4", "Classic Control"));
        assertEquals(department1.getCourses(), departmentDAO.getDepartmentById(1).get().getCourses());
        entityManager.close();
    }

    @Test
    @DisplayName("D")
    public void deleteDepartmentTest()
    {
        // Create our entity manager
        EntityManager entityManager = JPASessionUtil.getEntityManager("Elina");
        // Create repository
        DepartmentDAO departmentDAO = new DepartmentDAO(entityManager);
        // Create two department and add 2 courses to their list of courses
        Department department1 = Utility.createDepartment1();
        Department department2 = Utility.createDepartment2();
        departmentDAO.saveDepartment(department1);
        departmentDAO.saveDepartment(department2);
        departmentDAO.deleteDepartment(department1);
        List<Department> retrievedDepartments = departmentDAO.getAllDepartments();
        assertEquals(1, retrievedDepartments.size());
        entityManager.close();
    }
    /*
    @Test
    public void saveTest(){
        // Create our entity manager
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Elina");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        //-----------------------------------------------------------------------------------------
        // Create repository
        DepartmentDAO departmentDAO = new DepartmentDAO(entityManager);
        // Create two department and add 2 courses to their list of courses
        Department department1 = new Department("Department 1");
        department1.addCourse(new Course("Course 1", "Maths"));
        department1.addCourse(new Course("Course 2", "Physics"));
        Department department2 = new Department("Department 2");
        department2.addCourse(new Course("Course 3", "Electronics"));
        Optional<Department> savedDepartment1 = departmentDAO.save(department1);
        Optional<Department> savedDepartment2 = departmentDAO.save(department2);
        assertEquals("Department(id=1, name=Department 1, " +
                        "courses=[Course(id=2, name=Course 1, description=Maths, department=Department 1), " +
                        "Course(id=3, name=Course 2, description=Physics, department=Department 1)])"
                ,savedDepartment1.get().toString());
    }


     @Test
     @DisplayName("All Tests")
     public void findAllTest() {
         // Create our entity manager
         EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Elina");
         EntityManager entityManager = entityManagerFactory.createEntityManager();
         //-----------------------------------------------------------------------------------------
         // Create repository
         DepartmentDAO departmentDAO = new DepartmentDAO(entityManager);
         // Create two department and add 2 courses to their list of courses
         Department department1 = new Department("Department 1");
         department1.addCourse(new Course("Course 1", "Maths"));
         department1.addCourse(new Course("Course 2", "Physics"));
         Department department2 = new Department("Department 2");
         department2.addCourse(new Course("Course 3", "Electronics"));
         departmentDAO.save(department1);
         departmentDAO.save(department2);
         // Find all departments
         List<Department> departments = departmentDAO.findAll();
         assertEquals("[Department(id=1, name=Department 1, courses=[Course(id=2, name=Course 1, description=Maths, department=Department 1), Course(id=3, name=Course 2, description=Physics, department=Department 1)])" +
                         ", Department(id=4, name=Department 2, courses=[Course(id=5, name=Course 3, description=Electronics, department=Department 2)])]",
                 departments.toString());
     }

    @Test
    @DisplayName("By Name")
    public void findByName(){
        // Create our entity manager
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Elina");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        //-----------------------------------------------------------------------------------------
        // Create repository
        DepartmentDAO departmentDAO = new DepartmentDAO(entityManager);
        // Create two department and add 2 courses to their list of courses
        Department department1 = new Department("Department 1");
        department1.addCourse(new Course("Course 1", "Maths"));
        department1.addCourse(new Course("Course 2", "Physics"));
        Department department2 = new Department("Department 2");
        department2.addCourse(new Course("Course 3", "Electronics"));
        departmentDAO.save(department1);
        departmentDAO.save(department2);
        Optional<Department> departmentByName = departmentDAO.findByName("Department 1");
        assertEquals("Department(id=1, name=Department 1, " +
                        "courses=[Course(id=2, name=Course 1, description=Maths, department=Department 1), " +
                        "Course(id=3, name=Course 2, description=Physics, department=Department 1)])"
                ,departmentByName.get().toString());
    }

    @Test
    @DisplayName("By ID")
    public void findByID(){
        // Create our entity manager
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Elina");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        //-----------------------------------------------------------------------------------------
        // Create repository
        DepartmentDAO departmentDAO = new DepartmentDAO(entityManager);
        // Create two department and add 2 courses to their list of courses
        Department department1 = new Department("Department 1");
        department1.addCourse(new Course("Course 1", "Maths"));
        department1.addCourse(new Course("Course 2", "Physics"));
        Department department2 = new Department("Department 2");
        department2.addCourse(new Course("Course 3", "Electronics"));
        departmentDAO.save(department1);
        departmentDAO.save(department2);
        assertEquals("Department(id=1, name=Department 1, " +
                        "courses=[Course(id=2, name=Course 1, description=Maths, department=Department 1), " +
                        "Course(id=3, name=Course 2, description=Physics, department=Department 1)])"
                , departmentDAO.findById(1).get().toString());
    }

     */

}