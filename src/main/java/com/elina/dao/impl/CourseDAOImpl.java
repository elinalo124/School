package com.elina.dao.impl;

import com.elina.dao.CourseDAO;
import com.elina.model.Course;
import com.elina.model.Department;
import com.elina.model.Student;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class CourseDAOImpl {

    private EntityManager entityManager;
    public CourseDAOImpl(EntityManager entityManager)
    {
        this.entityManager = entityManager;
    }
    static private CourseDAOImpl singletonInstance = null;
    public static CourseDAOImpl createDAO(EntityManager entityManager)
    {
        if (singletonInstance == null) singletonInstance = new CourseDAOImpl(entityManager);
        return singletonInstance;
    }

    public void updateElement(Course course)
    {
        Course courseToUpdate = entityManager.find(Course.class, course.getId());
        entityManager.merge(courseToUpdate);
    }

    /*-----------------------------CRUD---------------------------------------*/
    /*============CREATE============*/
    /*
    public void saveElement(Course course)
    {
        entityManager.getTransaction().begin();
        entityManager.persist(course);
        entityManager.getTransaction().commit();
    }

    /*============RETRIEVE============*/
    /*
    public List<Course> retrieveAllElements()
    {
        return entityManager.createQuery("from Course").getResultList();
    }

    public Optional<Course> retrieveElementByID(int id)
    {
        Course course = entityManager.find(Course.class, id);
        return course != null ? Optional.of(course) : Optional.empty();
    }

    public Optional<Course> retrieveCourseByName(String name)
    {
        Course course = entityManager.createQuery("SELECT c FROM Course c WHERE c.name = :name", Course.class)
                .setParameter("name", name)
                .getSingleResult();
        return course != null ? Optional.of(course) : Optional.empty();
    }
    /*============UPDATE============*/
    /*
    public void updateElement(Course course)
    {
        entityManager.getTransaction().begin();
        Course courseToUpdate = entityManager.find(Course.class, course.getId());
        entityManager.merge(courseToUpdate);
        entityManager.getTransaction().commit();
    }
    public void addStudent(int id, Student student)
    {
        entityManager.getTransaction().begin();
        Course courseToUpdate = entityManager.find(Course.class, id);
        courseToUpdate.getStudents().add(student);
        entityManager.getTransaction().commit();
    }
    /*============DELETE============*/
    /*
    public void deleteElement(Course course)
    {
        System.out.println("Course passed to deleteDAO:"+course);
        entityManager.getTransaction().begin();
        Course courseToDelete = entityManager.find(Course.class, course.getId());
        System.out.println("Course to delete:"+courseToDelete);
        entityManager.remove(courseToDelete);
        entityManager.getTransaction().commit();
    }

     */


}
