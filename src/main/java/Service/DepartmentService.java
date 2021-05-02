package Service;

import Entities.Department;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class DepartmentService {
    private EntityManager entityManager;
    public DepartmentService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Optional<Department> findById(Integer id) {
        Department department = entityManager.find(Department.class, id);
        return department != null ? Optional.of(department) : Optional.empty();
    }

    public List<Department> findAll() {
        return entityManager.createQuery("from Department").getResultList();
    }

    public Optional<Department> findByName(String name) {
        Department department = entityManager.createNamedQuery("Department.findByName", Department.class)
                .setParameter("name", name)
                .getSingleResult();
        return department != null ? Optional.of(department) : Optional.empty();
    }
    public Optional<Department> save(Department department) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(department);
            entityManager.getTransaction().commit();
            return Optional.of(department);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }
}
