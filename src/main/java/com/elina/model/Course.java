package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity @Access(AccessType.FIELD)
@NamedQueries({
        @NamedQuery(name = "Course.findByName",
                query = "SELECT c FROM Course c WHERE c.name = :name"),
        @NamedQuery(name = "Course.findAll",
                query = "SELECT c FROM Course c")
})
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Course {
    @Id
    private int id;
    private String name;
    private String description;
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;
    @OneToOne(mappedBy = "course")
    private Teacher teacher;
    @ManyToMany(mappedBy = "courses",cascade = CascadeType.ALL)
    private List<Student> students;

    public Course(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Course(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.students = new ArrayList<>();
    }


    public void addStudent(Student student)
    {
        students.add(student);
    }

    @Override
    public String toString() {

        return "Course(id=" + id +
                ", name=" + name +
                ", description=" + description;
    }
}
