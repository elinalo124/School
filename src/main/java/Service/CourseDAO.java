package Service;

import Entities.Course;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class CourseDAO {

    private EntityManager entityManager;
    public CourseDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Optional<Course> findById(Integer id) {
        Course course = entityManager.find(Course.class, id);
        return course != null ? Optional.of(course) : Optional.empty();
    }

    public List<Course> findAll() {
        return entityManager.createQuery("from Course").getResultList();
    }

    public Optional<Course> findByName(String name) {
        Course course = entityManager.createQuery("SELECT c FROM Course c WHERE c.name = :name", Course.class)
                .setParameter("name", name)
                .getSingleResult();
        return course != null ? Optional.of(course) : Optional.empty();
    }

    public Optional<Course> findByNameNamedQuery(String name) {
        Course course = entityManager.createNamedQuery("Course.findByName", Course.class)
                .setParameter("name", name)
                .getSingleResult();
        return course != null ? Optional.of(course) : Optional.empty();
    }

    public Optional<Course> save(Course course) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(course);
            entityManager.getTransaction().commit();
            return Optional.of(course);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }
}
