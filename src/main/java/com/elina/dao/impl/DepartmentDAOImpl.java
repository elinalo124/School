package com.elina.dao.impl;

import com.elina.dao.DepartmentDAO;
import com.elina.model.Course;
import com.elina.model.Department;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class DepartmentDAOImpl{

    private EntityManager entityManager;
    public DepartmentDAOImpl(EntityManager entityManager)
    {
        this.entityManager = entityManager;
    }

    /*static private DepartmentDAOImpl singletonInstance = null;
    public static DepartmentDAOImpl createDAO(EntityManager entityManager)
    {
        if (singletonInstance == null) singletonInstance = new DepartmentDAOImpl(entityManager);
        return singletonInstance;
    }*/


    /*-----------------------------CRUD---------------------------------------*/
    /*============CREATE============*/
    public void saveElement(Department department)
    {
        if (entityManager.contains(department)) {
            entityManager.merge(department);
        } else {
            entityManager.persist(department);
        }

    }

    /*============RETRIEVE============*/
    public List<Department> retrieveAllElements()
    {
        return entityManager.createQuery("from Department").getResultList();
    }

    public Optional<Department> retrieveElementByID(int id)
    {
        Department department = entityManager.find(Department.class, id);
        return department != null? Optional.of(department): Optional.empty();
    }


    public Optional<Department> retrieveDepartmentByName(String name)
    {
        Department department = entityManager.createNamedQuery("Department.findByName", Department.class)
                .setParameter("name", name)
                .getSingleResult();
        return department != null ? Optional.of(department) : Optional.empty();
    }
    /*============UPDATE============*/
    public void updateElement(Department department)
    {
        Department departmentToUpdate = entityManager.find(Department.class, department.getId());
        entityManager.merge(departmentToUpdate);
    }
    public void addCourse(Integer id, Course course)
    {
        Department departmentToUpdate = entityManager.find(Department.class, id);
        departmentToUpdate.getCourses().add(course);
    }

    /*============DELETE============*/
    public void deleteElement(Department department)
    {
        Department departmentToDelete = entityManager.find(Department.class, department.getId());
        entityManager.remove(departmentToDelete);
    }






}

