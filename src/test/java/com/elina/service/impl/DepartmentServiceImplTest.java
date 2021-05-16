package com.elina.service.impl;

import com.elina.model.Course;
import com.elina.model.Department;
import com.elina.service.DepartmentService;
import com.elina.util.Utility;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DepartmentServiceImplTest {

    @Test
    @DisplayName("C")
    public void saveDepartmentTest()
    {
        DepartmentServiceImpl departmentService = new DepartmentServiceImpl();
        // Create two department and add 2 courses to their list of courses
        Department department1 = Utility.createDepartment1();
        Department department2 = Utility.createDepartment2();
        departmentService.saveDepartment(department1);
        departmentService.saveDepartment(department2);
        List<Department> departments = departmentService.retrieveAllDepartments();
        assertEquals(department1.getName(), departments.get(0).getName());
    }
    /*
    @Test
    @DisplayName("R")
    public void getDepartmentsTest()
    {
        DepartmentService departmentService = new DepartmentServiceImpl();
        // Create two department and add 2 courses to their list of courses
        Department department1 = Utility.createDepartment1();
        Department department2 = Utility.createDepartment2();
        departmentService.saveDepartment(department1);
        departmentService.saveDepartment(department2);
        List<Department> savedDepartments = new LinkedList<>();
        savedDepartments.add(department1);
        savedDepartments.add(department2);
        List<Department> retrievedDepartments = departmentService.retrieveAllDepartments();
        assertEquals(savedDepartments, retrievedDepartments);
        assertEquals(department1, departmentService.retrieveDepartmentByID(1).get());
        assertEquals(department1, departmentService.retrieveDepartmentByName("Department 1").get());
    }

    @Test
    @DisplayName("U")
    public void addCourseTest()
    {
        DepartmentService departmentService = new DepartmentServiceImpl();
        // Create two department and add 2 courses to their list of courses
        Department department1 = Utility.createDepartment1();
        Department department2 = Utility.createDepartment2();
        departmentService.saveDepartment(department1);
        departmentService.saveDepartment(department2);
        departmentService.addCourse(1, new Course(4,"Course 4", "Classic Control"));
        assertEquals(department1.getCourses(), departmentService.retrieveDepartmentByID(1).get().getCourses());
    }

    @Test
    @DisplayName("D")
    public void deleteDepartmentTest()
    {
        DepartmentService departmentService = new DepartmentServiceImpl();
        // Create two department and add 2 courses to their list of courses
        Department department1 = Utility.createDepartment1();
        Department department2 = Utility.createDepartment2();
        departmentService.saveDepartment(department1);
        departmentService.saveDepartment(department2);
        departmentService.deleteDepartment(department1);
        List<Department> retrievedDepartments = departmentService.retrieveAllDepartments();
        assertEquals(1, retrievedDepartments.size());
    }

     */


}