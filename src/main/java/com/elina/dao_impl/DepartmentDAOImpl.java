package com.elina.dao_impl;

import com.elina.dao.DepartmentDAO;
import com.elina.model.Course;
import com.elina.model.Department;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class DepartmentDAOImpl implements DepartmentDAO{

    private EntityManager entityManager;
    public DepartmentDAOImpl(EntityManager entityManager)
    {
        this.entityManager = entityManager;
    }

    /*-----------------------------CRUD---------------------------------------*/
    /*============CREATE============*/
    public void saveElement(Department department)
    {
        entityManager.getTransaction().begin();
        entityManager.persist(department);
        entityManager.getTransaction().commit();
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
        entityManager.getTransaction().begin();
        Department departmentToUpdate = entityManager.find(Department.class, department.getId());
        entityManager.merge(departmentToUpdate);
        entityManager.getTransaction().commit();
    }
    public void addCourse(Integer id, Course course)
    {
        entityManager.getTransaction().begin();
        Department departmentToUpdate = entityManager.find(Department.class, id);
        departmentToUpdate.getCourses().add(course);
        entityManager.getTransaction().commit();
    }

    /*============DELETE============*/
    public void deleteElement(Department department)
    {
        entityManager.getTransaction().begin();
        Department departmentToDelete = entityManager.find(Department.class, department.getId());
        System.out.print(departmentToDelete);
        entityManager.remove(departmentToDelete);
        entityManager.getTransaction().commit();
    }

}

