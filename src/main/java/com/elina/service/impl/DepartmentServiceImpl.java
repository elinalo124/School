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

    private EntityManager em;

    public DepartmentServiceImpl(EntityManager em) {
        this.em=em;
    }

    private void begin(){if(!em.getTransaction().isActive())em.getTransaction().begin();}
    /*-----CREATE-----*/
    public void saveDepartment(Department department)
    {
        begin();
        //DepartmentDAOImpl departmentDAOImpl = DepartmentDAOImpl.createDAO(em);
        DepartmentDAOImpl departmentDAOImpl = new DepartmentDAOImpl(em);
        //CourseDAOImpl courseDAOImpl = CourseDAOImpl.createDAO(em);
        CourseDAOImpl courseDAOImpl = new CourseDAOImpl(em);

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
        //DepartmentDAOImpl departmentDAOImpl = DepartmentDAOImpl.createDAO(em);
        DepartmentDAOImpl departmentDAOImpl = new DepartmentDAOImpl(em);
        return departmentDAOImpl.retrieveAllElements();
    }

    public Optional<Department> retrieveDepartmentByID (int id)
    {
        begin();
        //DepartmentDAOImpl departmentDAOImpl = DepartmentDAOImpl.createDAO(em);
        DepartmentDAOImpl departmentDAOImpl = new DepartmentDAOImpl(em);
        return departmentDAOImpl.retrieveElementByID(id);
    }
    public Optional<Department> retrieveDepartmentByName (String name)
    {
        begin();
        //DepartmentDAOImpl departmentDAOImpl = DepartmentDAOImpl.createDAO(em);
        DepartmentDAOImpl departmentDAOImpl = new DepartmentDAOImpl(em);
        return departmentDAOImpl.retrieveDepartmentByName(name);
    }
    /*-----UPDATE-----*/
    public void updateDepartment(Department department)
    {
        begin();
        //DepartmentDAOImpl departmentDAOImpl = DepartmentDAOImpl.createDAO(em);
        DepartmentDAOImpl departmentDAOImpl = new DepartmentDAOImpl(em);
        departmentDAOImpl.updateElement(department);
        em.getTransaction().commit();
    }
    /*-----DELETE-----*/
    public void deleteDepartment(Department department)
    {
        begin();
        //DepartmentDAOImpl departmentDAOImpl = DepartmentDAOImpl.createDAO(em);
        DepartmentDAOImpl departmentDAOImpl = new DepartmentDAOImpl(em);
        departmentDAOImpl.deleteElement(department);
        em.getTransaction().commit();
    }
    /*-----OTHER-----*/
    public void addCourse(Integer id, Course course)
    {
        begin();
        //DepartmentDAOImpl departmentDAOImpl = DepartmentDAOImpl.createDAO(em);
        DepartmentDAOImpl departmentDAOImpl = new DepartmentDAOImpl(em);
        departmentDAOImpl.addCourse(id,course);
        em.getTransaction().commit();
    }

}
