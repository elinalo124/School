package com.elina.dao;

import com.elina.model.Student;

public interface StudentDAO extends CRUD<Student>{
    public void changeMajor(Integer id, String major);
}
