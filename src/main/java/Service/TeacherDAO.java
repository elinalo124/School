package Service;

import Entities.Student;
import Entities.Teacher;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class TeacherDAO {
    private EntityManager entityManager;
    public TeacherDAO(EntityManager entityManager)
    {
        this.entityManager = entityManager;
    }

    /*-----------------------------CRUD---------------------------------------*/
    /*============CREATE============*/
    public void saveTeacher(Teacher teacher)
    {
        entityManager.getTransaction().begin();
        entityManager.persist(teacher);
        entityManager.getTransaction().commit();
    }
    /*============RETRIEVE============*/
    public List<Teacher> getAllTeachers()
    {
        return entityManager.createQuery("from Teacher").getResultList();
    }

    public Optional<Teacher> getTeacherById(Integer id)
    {
        Teacher teacher = entityManager.find(Teacher.class, id);
        return teacher != null ? Optional.of(teacher) : Optional.empty();
    }

    /*============UPDATE============*/
    public void changeCourse(Integer id, String major)
    {
        entityManager.getTransaction().begin();
        Student studentToUpdate = entityManager.find(Student.class, id);
        studentToUpdate.setMajor(major);
        entityManager.getTransaction().commit();
    }

    /*============DELETE============*/
    public void deleteStudent(Student student)
    {
        entityManager.getTransaction().begin();
        Student studentToDelete = entityManager.find(Student.class, student.getId());
        System.out.print(studentToDelete);
        entityManager.remove(studentToDelete);
        entityManager.getTransaction().commit();
    }
}
