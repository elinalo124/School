package com.elina.dao_impl;

import com.elina.model.Course;
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

    /*-----------------------------CRUD---------------------------------------*/
    /*============CREATE============*/
    public void saveCourse(Course course)
    {
        entityManager.getTransaction().begin();
        entityManager.persist(course);
        entityManager.getTransaction().commit();
    }

    /*============RETRIEVE============*/
    public List<Course> getAllCourses()
    {
        return entityManager.createQuery("from Course").getResultList();
    }

    public Optional<Course> getCourseById(Integer id)
    {
        Course course = entityManager.find(Course.class, id);
        return course != null ? Optional.of(course) : Optional.empty();
    }

    public Optional<Course> getCourseByName(String name)
    {
        Course course = entityManager.createQuery("SELECT c FROM Course c WHERE c.name = :name", Course.class)
                .setParameter("name", name)
                .getSingleResult();
        return course != null ? Optional.of(course) : Optional.empty();
    }
    /*============UPDATE============*/
    public void addStudent(Integer id, Student student)
    {
        entityManager.getTransaction().begin();
        Course courseToUpdate = entityManager.find(Course.class, id);
        courseToUpdate.addStudent(student);
        entityManager.getTransaction().commit();
    }
    /*============DELETE============*/
    public void deleteCourse(Course course)
    {
        System.out.println("Course passed to deleteDAO:"+course);
        entityManager.getTransaction().begin();
        Course courseToDelete = entityManager.find(Course.class, course.getId());
        System.out.println("Course to delete:"+courseToDelete);
        entityManager.remove(courseToDelete);
        entityManager.getTransaction().commit();
    }


}
