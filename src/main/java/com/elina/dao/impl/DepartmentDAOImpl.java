package com.elina.dao.impl;

import com.elina.dao.DepartmentDAO;
import com.elina.model.Course;
import com.elina.model.Department;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class DepartmentDAOImpl implements DepartmentDAO {

    private EntityManager entityManager;
    public DepartmentDAOImpl(EntityManager entityManager)
    {
        this.entityManager = entityManager;
    }

    private void begin()
    {
        if(!entityManager.getTransaction().isActive())
            entityManager.getTransaction().begin();
    }

    /*-----------------------------CRUD---------------------------------------*/
    /*============CREATE============*/
    public void saveElement(Department department)
    {
        begin();
        if (entityManager.contains(department)) {
            entityManager.merge(department);
        } else {
            entityManager.persist(department);
        }
        entityManager.getTransaction().commit();

    }

    /*============RETRIEVE============*/
    public List<Department> retrieveAllElements()
    {
        begin();
        return entityManager.createQuery("from Department").getResultList();
    }

    public Optional<Department> retrieveElementByID(int id)
    {
        begin();
        Department department = entityManager.find(Department.class, id);
        return department != null? Optional.of(department): Optional.empty();
    }


    public Optional<Department> retrieveDepartmentByName(String name)
    {
        begin();
        Department department = entityManager.createNamedQuery("Department.findByName", Department.class)
                .setParameter("name", name)
                .getSingleResult();
        return department != null ? Optional.of(department) : Optional.empty();
    }
    /*============UPDATE============*/
    public void updateElement(Department department)
    {
        begin();
        Department departmentToUpdate = entityManager.find(Department.class, department.getId());
        entityManager.merge(departmentToUpdate);
        entityManager.getTransaction().commit();
    }
    public void addCourse(Integer id, Course course)
    {
        begin();
        Department departmentToUpdate = entityManager.find(Department.class, id);
        departmentToUpdate.getCourses().add(course);
        entityManager.getTransaction().commit();
    }

    /*============DELETE============*/
    public void deleteElement(Department department)
    {
        begin();
        Department departmentToDelete = entityManager.find(Department.class, department.getId());
        entityManager.remove(departmentToDelete);
        entityManager.getTransaction().commit();
    }


}

