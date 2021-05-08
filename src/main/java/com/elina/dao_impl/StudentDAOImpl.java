package com.elina.dao_impl;

import com.elina.model.Student;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class StudentDAO {

    private EntityManager entityManager;
    public StudentDAO(EntityManager entityManager)
    {
        this.entityManager = entityManager;
    }

    /*-----------------------------CRUD---------------------------------------*/
    /*============CREATE============*/
    public void saveStudent(Student student)
    {
        entityManager.getTransaction().begin();
        entityManager.persist(student);
        entityManager.getTransaction().commit();
    }
    /*============RETRIEVE============*/
    public List<Student> getAllStudents()
    {
        return entityManager.createQuery("from Student").getResultList();
    }

    public Optional<Student> getStudentById(Integer id)
    {
        Student student = entityManager.find(Student.class, id);
        return student != null ? Optional.of(student) : Optional.empty();
    }

    /*============UPDATE============*/
    public void changeMajor(Integer id, String major)
    {
        entityManager.getTransaction().begin();
        Student studentToUpdate = entityManager.find(Student.class, id);
        studentToUpdate.setMajor(major);
        entityManager.getTransaction().commit();
    }

    /*============DELETE============*/
    public void deleteStudent(Student student)
    {
        entityManager.getTransaction().begin();
        Student studentToDelete = entityManager.find(Student.class, student.getId());
        System.out.print(studentToDelete);
        entityManager.remove(studentToDelete);
        entityManager.getTransaction().commit();
    }


}
