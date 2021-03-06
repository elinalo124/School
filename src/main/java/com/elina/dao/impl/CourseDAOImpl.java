package com.elina.dao.impl;

import com.elina.dao.CourseDAO;
import com.elina.model.Course;
import com.elina.model.Department;
import com.elina.model.Student;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class CourseDAOImpl implements CourseDAO{

    private EntityManager entityManager;
    public CourseDAOImpl(EntityManager entityManager)
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
    public void saveElement(Course course)
    {
        begin();
        if (entityManager.contains(course)) {
            entityManager.merge(course);
        } else {
            entityManager.persist(course);
        }
        entityManager.getTransaction().commit();
    }
    /*============RETRIEVE============*/
    public List<Course> retrieveAllElements()
    {
        begin();
        return entityManager.createQuery("from Course").getResultList();
    }
    public Optional<Course> retrieveElementByID(int id)
    {
        begin();
        Course course = entityManager.find(Course.class, id);
        return course != null? Optional.of(course): Optional.empty();
    }
    public Optional<Course> retrieveCourseByName(String name)
    {
        begin();
        Course course = entityManager.createNamedQuery("Course.findByName", Course.class)
                .setParameter("name", name)
                .getSingleResult();
        return course != null ? Optional.of(course) : Optional.empty();
    }
    /*============UPDATE============*/
    public void updateElement(Course course)
    {
        begin();
        Course courseToUpdate = entityManager.find(Course.class, course.getId());
        entityManager.merge(courseToUpdate);
        entityManager.getTransaction().commit();
    }
    public void addStudent(int id, Student student)
    {
        begin();
        Course courseToUpdate = entityManager.find(Course.class, id);
        courseToUpdate.getStudents().add(student);
        entityManager.getTransaction().commit();
    }
    /*============DELETE============*/
    public void deleteElement(Course course)
    {
        begin();
        Course courseToDelete = entityManager.find(Course.class, course.getId());
        entityManager.remove(courseToDelete);
        entityManager.getTransaction().commit();
    }

}
