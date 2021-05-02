package Service;

import Entities.Course;
import Entities.Department;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class CourseDAO {

    private EntityManager entityManager;
    public CourseDAO(EntityManager entityManager)
    {
        this.entityManager = entityManager;
    }

    /*-----------------------------CRUD---------------------------------------*/
    /*============CREATE============*/
    public void saveCourse(Course course)
    {
        entityManager.getTransaction().begin();
        entityManager.persist(course);
        entityManager.getTransaction().commit();
    }

    /*============RETRIEVE============*/
    public List<Course> getAllCourses()
    {
        return entityManager.createQuery("from Course").getResultList();
    }

    public Optional<Course> getCourseById(Integer id)
    {
        Course course = entityManager.find(Course.class, id);
        return course != null ? Optional.of(course) : Optional.empty();
    }

    public Optional<Course> getCourseByName(String name)
    {
        Course course = entityManager.createQuery("SELECT c FROM Course c WHERE c.name = :name", Course.class)
                .setParameter("name", name)
                .getSingleResult();
        return course != null ? Optional.of(course) : Optional.empty();
    }


}
