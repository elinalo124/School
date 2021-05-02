package Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity @Access(AccessType.FIELD)
@NamedQueries({
        @NamedQuery(name = "Teacher.findByName",
                query = "SELECT t FROM Teacher t WHERE t.name = :name"),
        @NamedQuery(name = "Teacher.findAll",
                query = "SELECT t FROM Teacher t")
})
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Teacher{
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String education;
    @OneToOne
    private Course course;

    public Teacher(String name, String education) {
        this.name = name;
        this.education = education;
    }
    public Teacher(int id, String name, String education) {
        this.id = id;
        this.name = name;
        this.education = education;
    }

    @Override
    public String toString() {
        return "Teacher(id=" + id +
                ", name=" + name +
                ", education=" + education +
                ", course=" + course + ")";
    }
}
