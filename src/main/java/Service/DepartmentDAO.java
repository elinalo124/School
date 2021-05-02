package Service;

import Entities.Course;
import Entities.Department;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class DepartmentDAO {
    private EntityManager entityManager;
    public DepartmentDAO(EntityManager entityManager)
    {
        this.entityManager = entityManager;
    }

    /*-----------------------------CRUD---------------------------------------*/
    /*============CREATE============*/
    public void saveDepartment(Department department) {
        entityManager.getTransaction().begin();
        entityManager.persist(department);
        entityManager.getTransaction().commit();
    }
    /*============RETRIEVE============*/
    public List<Department> getAllDepartments()
    {
        return entityManager.createQuery("from Department").getResultList();
    }
    public Optional<Department> getDepartmentById(Integer id)
    {
        Department department = entityManager.find(Department.class, id);
        return department != null ? Optional.of(department) : Optional.empty();
    }

    public Optional<Department> getDepartmentByName(String name)
    {
        Department department = entityManager.createNamedQuery("Department.findByName", Department.class)
                .setParameter("name", name)
                .getSingleResult();
        return department != null ? Optional.of(department) : Optional.empty();
    }
    /*============UPDATE============*/
    public void addCourse(Integer id, Course course)
    {
        entityManager.getTransaction().begin();
        Department departmentToUpdate = entityManager.find(Department.class, id);
        departmentToUpdate.addCourse(course);
        entityManager.getTransaction().commit();
    }

    /*============DELETE============*/
    public void deleteDepartment(Department department)
    {
        entityManager.getTransaction().begin();
        Department departmentToDelete = entityManager.find(Department.class, department.getId());
        System.out.print(departmentToDelete);
        entityManager.remove(departmentToDelete);
        entityManager.getTransaction().commit();
    }

}
