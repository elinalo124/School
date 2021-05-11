package com.elina.util;

import com.elina.model.Course;
import com.elina.model.Department;
import com.elina.model.Student;

import java.util.LinkedList;
import java.util.List;

public class Utility {
    public static Department createDepartment1()
    {
        List<Course> courses1 = new LinkedList<>();
        courses1.add(new Course(1,"Course 1", "Maths"));
        courses1.add(new Course(2,"Course 2", "Physics"));
        Department department1 = new Department(1,"Department 1",courses1);
        return department1;
    }
    public static Department createDepartment2()
    {
        List<Course> courses2 = new LinkedList<>();
        courses2.add(new Course(3,"Course 3", "Electronics"));
        Department department2 = new Department(2,"Department 2",courses2);
        return department2;
    }

    public static Course createCourse1()
    {
        return new Course(1,"Course 1", "Maths");
    }

    public static Course createCourse2()
    {
        return new Course(2,"Course 2", "Physics");
    }

    public static Student createStudent1()
    {
        return new Student(1, "Elina", "Lo", 1, "Electronic engineering");
    }
    public static Student createStudent2()
    {
        return new Student(2, "Elisa", "Lo", 2, "Geophysics");
    }
}
