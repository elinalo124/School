package Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity @Access(AccessType.FIELD)
@NamedQueries({
        @NamedQuery(name = "Department.findByName",
                query = "SELECT d FROM Department d WHERE d.name = :name"),
        @NamedQuery(name = "Department.findAll",
                query = "SELECT d FROM Department d")
})
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Department {
    @Id
    private int id;
    private String name;
    @OneToMany(mappedBy = "department",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Course> courses = new LinkedList<>();

    public void addCourse(Course course) {courses.add(course);course.setDepartment(this);}
    public void removeCourse(Course course) {courses.remove(course);course.setDepartment(null);}

    public Department(String name) {
        this.name = name;
    }
    public Department(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Department(id=" + id +
                ", name=" + name +
                ", courses="+courses.toString()+")";
    }
}
