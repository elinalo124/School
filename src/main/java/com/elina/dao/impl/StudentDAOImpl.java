package com.elina.dao.impl;

import com.elina.dao.StudentDAO;
import com.elina.model.Student;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class StudentDAOImpl implements StudentDAO {

    private EntityManager entityManager;
    public StudentDAOImpl(EntityManager entityManager)
    {
        this.entityManager = entityManager;
    }

    /*-----------------------------CRUD---------------------------------------*/
    /*============CREATE============*/
    public void saveElement(Student student)
    {
        entityManager.getTransaction().begin();
        entityManager.persist(student);
        entityManager.getTransaction().commit();
    }
    /*============RETRIEVE============*/
    public List<Student> retrieveAllElements()
    {
        return entityManager.createQuery("from Student").getResultList();
    }

    public Optional<Student> retrieveElementByID(int id)
    {
        Student student = entityManager.find(Student.class, id);
        return student != null ? Optional.of(student) : Optional.empty();
    }

    /*============UPDATE============*/

    public void updateElement(Student student)
    {
        entityManager.getTransaction().begin();
        Student studentToUpdate = entityManager.find(Student.class, student.getId());
        entityManager.merge(studentToUpdate);
        entityManager.getTransaction().commit();
    }

    public void changeMajor(Integer id, String major)
    {
        entityManager.getTransaction().begin();
        Student studentToUpdate = entityManager.find(Student.class, id);
        studentToUpdate.setMajor(major);
        entityManager.getTransaction().commit();
    }

    /*============DELETE============*/
    public void deleteElement(Student student)
    {
        entityManager.getTransaction().begin();
        Student studentToDelete = entityManager.find(Student.class, student.getId());
        System.out.print(studentToDelete);
        entityManager.remove(studentToDelete);
        entityManager.getTransaction().commit();
    }

}
