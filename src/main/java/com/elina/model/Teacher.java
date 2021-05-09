package com.elina.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
@NamedQueries({
        @NamedQuery(name = "Teacher.findByID",
                query = "SELECT t FROM Teacher t WHERE t.id = :id"),
        @NamedQuery(name = "Teacher.findAll",
                query = "SELECT t FROM Teacher t")
})
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Teacher extends User{
    @Id
    private int id;
    private String education;
    @OneToOne
    private Course course;

    public Teacher(String name, String education) {
        this.education = education;
    }
    public Teacher(int id, String name, String education) {
        this.id = id;
        this.education = education;
    }

    @Override
    public String toString() {
        return "Teacher(id=" + id +
                ", education=" + education +
                ", course=" + course + ")";
    }
}
