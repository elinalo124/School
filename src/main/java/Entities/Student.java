package Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity @Access(AccessType.FIELD) //persistance at the level of the fields
@NamedQueries({
        @NamedQuery(name = "Student.findByName",
                query = "SELECT s FROM Student s WHERE s.name = :name"),
        @NamedQuery(name = "Student.findAll",
                query = "SELECT s FROM Student s")
})
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Student{
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String major;
    @ManyToMany
    @JoinTable(
            name = "STUDENT_COURSES",
            joinColumns = @JoinColumn(name = "STUDENT_ID"),
            inverseJoinColumns = @JoinColumn(name = "COURSE_ID"))
    private List<Course> courses;


    @Override
    public String toString() {
        return "Student(id=" + id +
                ", name=" + name +
                ", major=" + major +
                ", courses=" + courses.toString() + ")";
    }
}
