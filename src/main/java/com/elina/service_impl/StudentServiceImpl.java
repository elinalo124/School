package com.elina.service_impl;

import com.elina.dao.StudentDAO;
import com.elina.dao_impl.StudentDAOImpl;
import com.elina.model.Student;
import com.elina.util.JPASessionUtil;

import java.util.List;
import java.util.Optional;

public class StudentServiceImpl {
    StudentDAO studentDAOImpl = new StudentDAOImpl(JPASessionUtil.getEntityManager("Elina"));

    /*-----CREATE-----*/
    public void saveStudent(Student student)
    {
        studentDAOImpl.saveElement(student);
    }
    /*-----RETRIEVE-----*/
    public List<Student> retrieveAllStudents()
    {
        return studentDAOImpl.retrieveAllElements();
    }
    public Optional<Student> retrieveStudentByID (int id)
    {
        return studentDAOImpl.retrieveElementByID(id);
    }
    /*-----UPDATE-----*/
    public void updateStudent(Student student)
    {
        studentDAOImpl.updateElement(student);
    }
    /*-----DELETE-----*/
    public void deleteStudent(Student student)
    {
        studentDAOImpl.deleteElement(student);
    }
    /*-----OTHER-----*/
    public void changeMajor(Integer id, String major)
    {
        studentDAOImpl.changeMajor(id, major);
    }

}
