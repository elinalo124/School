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

    /*-----CREATE-----*/
    public void saveDepartment(Department department)
    {
        em.getTransaction().begin();
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
    public List<Department> retrieveAllDepartments()
    {
        em.getTransaction().begin();
        DepartmentDAOImpl departmentDAOImpl = DepartmentDAOImpl.createDAO(em);
        return departmentDAOImpl.retrieveAllElements();
    }


    /*-----RETRIEVE-----*/
    /*public List<Department> retrieveAllDepartments()
    {
        return departmentDAOImpl.retrieveAllElements();
    }
    public Optional<Department> retrieveDepartmentByID (int id)
    {
        return departmentDAOImpl.retrieveElementByID(id);
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
