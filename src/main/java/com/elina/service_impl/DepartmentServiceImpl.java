package com.elina.service_impl;

import com.elina.dao.DepartmentDAO;
import com.elina.dao_impl.DepartmentDAOImpl;
import com.elina.model.Course;
import com.elina.model.Department;
import com.elina.service.DepartmentService;
import com.elina.util.JPASessionUtil;

import java.util.List;
import java.util.Optional;

public class DepartmentServiceImpl implements DepartmentService {

    DepartmentDAO departmentDAOImpl = new DepartmentDAOImpl(JPASessionUtil.getEntityManager("Elina"));

    /*-----CREATE-----*/
    public void saveDepartment(Department department){
        departmentDAOImpl.saveElement(department);
    }
    /*-----RETRIEVE-----*/
    public List<Department> retrieveAllDepartments(){
        return departmentDAOImpl.retrieveAllElements();
    }
    public Optional<Department> retrieveDepartmentByID (int id){
        return departmentDAOImpl.retrieveElementByID(id);
    }
    /*-----UPDATE-----*/
    public void updateDepartment(Department department){
        departmentDAOImpl.updateElement(department);
    }
    /*-----DELETE-----*/
    public void deleteDepartment(Department department) {
        departmentDAOImpl.deleteElement(department);
    }
    /*-----OTHER-----*/
    public Optional<Department> getDepartmentByName(String name){
        return departmentDAOImpl.getDepartmentByName(name);
    }
    public void addCourse(Integer id, Course course){
        departmentDAOImpl.addCourse(id,course);
    }

}
