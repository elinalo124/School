package com.elina.util;

import com.elina.model.Course;
import com.elina.model.Department;

public class Utility {
    public static Department createDepartment1()
    {
        Department department1 = new Department(1,"Department 1");
        department1.addCourse(new Course(1,"Course 1", "Maths"));
        department1.addCourse(new Course(2,"Course 2", "Physics"));
        return department1;
    }
    public static Department createDepartment2(){
        Department department2 = new Department(2,"Department 2");
        department2.addCourse(new Course(3,"Course 3", "Electronics"));
        return department2;
    }

    public static Course createCourse1() {
        return new Course(1,"Course 1", "Maths");
    }

    public static Course createCourse2() {
        return new Course(2,"Course 2", "Physics");
    }
}
