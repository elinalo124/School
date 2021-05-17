package com.elina.service.impl;

import com.elina.dao.DepartmentDAO;
import com.elina.dao.impl.CourseDAOImpl;
import com.elina.dao.impl.DepartmentDAOImpl;
import com.elina.model.Course;
import com.elina.model.Department;
import com.elina.service.DepartmentService;
import com.elina.util.JPASessionUtil;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class DepartmentServiceImpl{

    private EntityManager em = JPASessionUtil.getEntityManager("Elina");

    private void begin(){if(!em.getTransaction().isActive())em.getTransaction().begin();}
    /*-----CREATE-----*/
    public void saveDepartment(Department department)
    {
        begin();
        DepartmentDAOImpl departmentDAOImpl = DepartmentDAOImpl.createDAO(em);
        CourseDAOImpl courseDAOImpl = CourseDAOImpl.createDAO(em);

        departmentDAOImpl.saveElement(department);
        for(Course course:department.getCourses())
        {
            course.setDepartment(department);
            courseDAOImpl.updateElement(course);
        }
        em.getTransaction().commit();
    }

    /*-----RETRIEVE-----*/
    public List<Department> retrieveAllDepartments()
    {
        begin();
        DepartmentDAOImpl departmentDAOImpl = DepartmentDAOImpl.createDAO(em);
        return departmentDAOImpl.retrieveAllElements();
    }

    public Optional<Department> retrieveDepartmentByID (int id)
    {
        begin();
        DepartmentDAOImpl departmentDAOImpl = DepartmentDAOImpl.createDAO(em);
        return departmentDAOImpl.retrieveElementByID(id);
    }
    public Optional<Department> retrieveDepartmentByName (String name)
    {
        begin();
        DepartmentDAOImpl departmentDAOImpl = DepartmentDAOImpl.createDAO(em);
        return departmentDAOImpl.retrieveDepartmentByName(name);
    }
    /*-----UPDATE-----*/
   /* public void updateDepartment(Department department)
    {
        departmentDAOImpl.updateElement(department);
    }
    /*-----DELETE-----*/
   /* public void deleteDepartment(Department department)
    {
        departmentDAOImpl.deleteElement(department);
    }
    /*-----OTHER-----*/
    /*public Optional<Department> retrieveDepartmentByName(String name)
    {
        return departmentDAOImpl.retrieveDepartmentByName(name);
    }
    public void addCourse(Integer id, Course course)
    {
        departmentDAOImpl.addCourse(id,course);
    }

     */

}
