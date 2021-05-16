package com.elina.service.impl;

import com.elina.dao.CourseDAO;
import com.elina.dao.TeacherDAO;
import com.elina.dao.impl.CourseDAOImpl;
import com.elina.dao.impl.TeacherDAOImpl;
import com.elina.model.Course;
import com.elina.model.Teacher;
import com.elina.util.JPASessionUtil;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class TeacherServiceImpl {
    EntityManager entityManager = JPASessionUtil.getEntityManager("Elina");
    //TeacherDAO teacherDAOImpl = new TeacherDAOImpl(entityManager);
    //CourseDAO courseDAOImpl = new CourseDAOImpl(entityManager);

    /*-----CREATE-----*/
    /*public void saveTeacher(Teacher teacher)
    {
        teacherDAOImpl.saveElement(teacher);
    }
    /*-----RETRIEVE-----*/
    /*public List<Teacher> retrieveAllTeachers()
    {
        return teacherDAOImpl.retrieveAllElements();
    }
    public Optional<Teacher> retrieveTeacherByID (int id)
    {
        return teacherDAOImpl.retrieveElementByID(id);
    }
    /*-----UPDATE-----*/
    /*public void saveCourse(Course course){
        courseDAOImpl.saveElement(course);
    }
    public void updateTeacher(Teacher teacher)
    {
        teacherDAOImpl.updateElement(teacher);
    }
    /*-----DELETE-----*/
    /*public void deleteTeacher(Teacher teacher)
    {
        teacherDAOImpl.deleteElement(teacher);
    }

     */

}
