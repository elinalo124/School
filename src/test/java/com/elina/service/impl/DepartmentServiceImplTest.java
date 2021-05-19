package com.elina.service.impl;

import com.elina.model.Course;
import com.elina.model.Department;
import com.elina.util.Utility;
import org.junit.jupiter.api.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DepartmentServiceImplTest {

    private Department department1;
    private Department department2;
    private List<Department> savedDepartments = new LinkedList<>();
    private List<Department> retrievedDepartments;
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("Elina");
    private DepartmentServiceImpl departmentService;
    private EntityManager em;

    @BeforeEach
    public void init() {
        initDepartments();

        em = emf.createEntityManager();
        em.getTransaction().begin();

        departmentService = new DepartmentServiceImpl(em);
        departmentService.saveDepartment(department1);
        departmentService.saveDepartment(department2);

        retrievedDepartments = departmentService.retrieveAllDepartments();

        em.getTransaction().commit();

    }


    @Test
    @DisplayName("C")
    public void createDepartmentTest()
    {
        assertEquals(department1.getName(), retrievedDepartments.get(0).getName());
        System.out.print("Retrieved\n"+retrievedDepartments);
        System.out.print("Saved\n"+savedDepartments);
    }

    @Test
    @DisplayName("R")
    public void retrieveDepartmentsTest()
    {
        assertEquals(savedDepartments, retrievedDepartments);
        assertEquals(department1, departmentService.retrieveDepartmentByID(1).get());
        assertEquals(department1, departmentService.retrieveDepartmentByName("Department 1").get());
    }

    @Test
    @DisplayName("U")
    public void updateCourseTest()
    {
        departmentService.addCourse(1, new Course(4,"Course 4", "Classic Control"));
        assertEquals(department1.getCourses(), departmentService.retrieveDepartmentByID(1).get().getCourses());
    }

    @Test
    @DisplayName("D")
    public void deleteDepartmentTest()
    {
        departmentService.deleteDepartment(department2);
        List<Department> retrievedDepartments = departmentService.retrieveAllDepartments();
        assertEquals(1, retrievedDepartments.size());
    }

    @AfterEach
    public void dropDown() {
        em.clear();
        em.close();
    }

    private void initDepartments()
    {
        department1 = Utility.createDepartment1();
        department2 = Utility.createDepartment2();
        savedDepartments.add(department1);
        savedDepartments.add(department2);
    }

}