package com.elina.service.impl;

import com.elina.dao.impl.CourseDAOImpl;
import com.elina.dao.impl.DepartmentDAOImpl;
import com.elina.model.Course;
import com.elina.model.Department;
import com.elina.service.DepartmentService;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class DepartmentServiceImpl implements DepartmentService {

    private EntityManager em;
    private DepartmentDAOImpl departmentDAOImpl;
    private CourseDAOImpl courseDAOImpl;

    public DepartmentServiceImpl(EntityManager em) {
        this.em=em;
        departmentDAOImpl = new DepartmentDAOImpl(em);
        courseDAOImpl = new CourseDAOImpl(em);
    }

    /*-----CREATE-----*/
    public void saveDepartment(Department department)
    {
        departmentDAOImpl.saveElement(department);
        for(Course course:department.getCourses())
        {
            course.setDepartment(department);
            courseDAOImpl.updateElement(course);
        }
    }

    /*-----RETRIEVE-----*/
    public List<Department> retrieveAllDepartments()
    {
        return departmentDAOImpl.retrieveAllElements();
    }

    public Optional<Department> retrieveDepartmentByID (int id)
    {
        return departmentDAOImpl.retrieveElementByID(id);
    }
    public Optional<Department> retrieveDepartmentByName (String name)
    {
        return departmentDAOImpl.retrieveDepartmentByName(name);
    }
    /*-----UPDATE-----*/
    public void updateDepartment(Department department)
    {
        departmentDAOImpl.updateElement(department);
    }
    /*-----DELETE-----*/
    public void deleteDepartment(Department department)
    {
        departmentDAOImpl.deleteElement(department);
    }
    /*-----OTHER-----*/
    public void addCourse(Integer id, Course course)
    {
        departmentDAOImpl.addCourse(id,course);
    }

}
