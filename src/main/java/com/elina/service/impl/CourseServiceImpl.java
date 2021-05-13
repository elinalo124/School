package com.elina.service.impl;

import com.elina.dao.CourseDAO;
import com.elina.dao.impl.CourseDAOImpl;
import com.elina.model.Course;
import com.elina.model.Student;
import com.elina.util.JPASessionUtil;

import java.util.List;
import java.util.Optional;

public class CourseServiceImpl {
    CourseDAO courseDAOImpl = new CourseDAOImpl(JPASessionUtil.getEntityManager("Elina"));

    /*-----CREATE-----*/
    public void saveCourse(Course course)
    {
        courseDAOImpl.saveElement(course);
    }
    /*-----RETRIEVE-----*/
    public List<Course> retrieveAllCourses()
    {
        return courseDAOImpl.retrieveAllElements();
    }
    public Optional<Course> retrieveCourseByID (int id)
    {
        return courseDAOImpl.retrieveElementByID(id);
    }
    /*-----UPDATE-----*/
    public void updateCourse(Course course)
    {
        courseDAOImpl.updateElement(course);
    }
    /*-----DELETE-----*/
    public void deleteCourse(Course department)
    {
        courseDAOImpl.deleteElement(department);
    }
    /*-----OTHER-----*/
    public Optional<Course> retrieveCourseByName(String name)
    {
        return courseDAOImpl.retrieveCourseByName(name);
    }
    public void addStudent(int id, Student student)
    {
        courseDAOImpl.addStudent(id,student);
    }
}
