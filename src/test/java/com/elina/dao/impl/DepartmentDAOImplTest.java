package com.elina.dao.impl;

import com.elina.model.Course;
import com.elina.model.Department;
import com.elina.util.JPASessionUtil;
import com.elina.util.Utility;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DepartmentDAOImplTest {

    /*
    @Test
    @DisplayName("C")
    public void saveDepartmentTest()
    {
        // Create our entity manager
        EntityManager entityManager = JPASessionUtil.getEntityManager("Elina");
        // Create repository
        DepartmentDAOImpl departmentDAOImpl = new DepartmentDAOImpl(entityManager);
        // Create two department and add 2 courses to their list of courses
        Department department1 = Utility.createDepartment1();
        Department department2 = Utility.createDepartment2();
        departmentDAOImpl.saveElement(department1);
        departmentDAOImpl.saveElement(department2);
        List<Department> departments = departmentDAOImpl.retrieveAllElements();
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
        DepartmentDAOImpl departmentDAOImpl = new DepartmentDAOImpl(entityManager);
        // Create two department and add 2 courses to their list of courses
        Department department1 = Utility.createDepartment1();
        Department department2 = Utility.createDepartment2();
        List<Department> savedDepartments = new LinkedList<>();
        savedDepartments.add(department1);
        savedDepartments.add(department2);
        departmentDAOImpl.saveElement(department1);
        departmentDAOImpl.saveElement(department2);
        List<Department> retrievedDepartments = departmentDAOImpl.retrieveAllElements();
        assertEquals(savedDepartments, retrievedDepartments);
        assertEquals(department1, departmentDAOImpl.retrieveElementByID(1).get());
        assertEquals(department1, departmentDAOImpl.retrieveDepartmentByName("Department 1").get());
        entityManager.close();
    }
    @Test
    @DisplayName("U")
    public void addCourseTest()
    {
        // Create our entity manager
        EntityManager entityManager = JPASessionUtil.getEntityManager("Elina");
        // Create repository
        DepartmentDAOImpl departmentDAOImpl = new DepartmentDAOImpl(entityManager);
        // Create two department and add 2 courses to their list of courses
        Department department1 = Utility.createDepartment1();
        Department department2 = Utility.createDepartment2();
        departmentDAOImpl.saveElement(department1);
        departmentDAOImpl.saveElement(department2);
        departmentDAOImpl.addCourse(1, new Course(4,"Course 4", "Classic Control"));
        assertEquals(department1.getCourses(), departmentDAOImpl.retrieveElementByID(1).get().getCourses());
        entityManager.close();
    }

    @Test
    @DisplayName("D")
    public void deleteDepartmentTest()
    {
        // Create our entity manager
        EntityManager entityManager = JPASessionUtil.getEntityManager("Elina");
        // Create repository
        DepartmentDAOImpl departmentDAOImpl = new DepartmentDAOImpl(entityManager);
        // Create two department and add 2 courses to their list of courses
        Department department1 = Utility.createDepartment1();
        Department department2 = Utility.createDepartment2();
        departmentDAOImpl.saveElement(department1);
        departmentDAOImpl.saveElement(department2);
        departmentDAOImpl.deleteElement(department1);
        List<Department> retrievedDepartments = departmentDAOImpl.retrieveAllElements();
        assertEquals(1, retrievedDepartments.size());
        entityManager.close();
    }

     */

}