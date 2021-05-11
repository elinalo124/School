package com.elina.dao_impl;

import com.elina.dao.TeacherDAO;
import com.elina.model.Student;
import com.elina.model.Teacher;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class TeacherDAOImpl implements TeacherDAO {
    private EntityManager entityManager;
    public TeacherDAOImpl(EntityManager entityManager)
    {
        this.entityManager = entityManager;
    }

    /*-----------------------------CRUD---------------------------------------*/
    /*============CREATE============*/
    public void saveElement(Teacher teacher)
    {
        entityManager.getTransaction().begin();
        entityManager.persist(teacher.getCourse());
        entityManager.persist(teacher);
        entityManager.getTransaction().commit();
    }
    /*============RETRIEVE============*/
    public List<Teacher> retrieveAllElements()
    {
        return entityManager.createQuery("from Teacher").getResultList();
    }

    public Optional<Teacher> retrieveElementByID(int id)
    {
        Teacher teacher = entityManager.find(Teacher.class, id);
        return teacher != null ? Optional.of(teacher) : Optional.empty();
    }

    /*============UPDATE============*/

    public void updateElement(Teacher teacher)
    {
        entityManager.getTransaction().begin();
        Teacher teacherToUpdate = entityManager.find(Teacher.class, teacher.getId());
        entityManager.merge(teacherToUpdate);
        entityManager.getTransaction().commit();
    }


    /*============DELETE============*/
    public void deleteElement(Teacher teacher)
    {
        entityManager.getTransaction().begin();
        Teacher teacherToDelete = entityManager.find(Teacher.class, teacher.getId());
        System.out.print(teacherToDelete);
        entityManager.remove(teacherToDelete);
        entityManager.getTransaction().commit();
    }
}
