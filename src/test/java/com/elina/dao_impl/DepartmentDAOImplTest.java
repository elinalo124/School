package com.elina.dao_impl;

import com.elina.model.Course;
import com.elina.model.Department;
import com.elina.util.JPASessionUtil;
import com.elina.util.Utility;
import org.junit.jupiter.api.*;

import javax.persistence.EntityManager;
import java.util.LinkedList;
import java.util.List;

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

}