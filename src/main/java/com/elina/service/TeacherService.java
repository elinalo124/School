package com.elina.service;

import com.elina.model.Teacher;

import java.util.List;
import java.util.Optional;

public interface TeacherService {

    /*-----CREATE-----*/
    void saveTeacher(Teacher teacher);
    /*-----RETRIEVE-----*/
    List<Teacher> retrieveAllTeachers();
    Optional<Teacher> retrieveTeacherByID (int id);
    /*-----UPDATE-----*/
    void updateTeacher(Teacher teacher);
    /*-----DELETE-----*/
    void deleteTeacher(Teacher teacher);

}
