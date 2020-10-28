package com.toprate.demo.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.*;

@Entity
@Table(name = "student")

public class Student extends BaseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")

    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "address")
    private String address;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "class_room",                                //Tạo bảng mới với tên là student_course
            joinColumns = @JoinColumn(name = "id_student"),     // Khóa ngoại đầu tiên tham chiếu tới class hiện tại
            inverseJoinColumns = @JoinColumn(name = "id_course") // Khóa ngoại thứ 2 tham chiếu đến Course bên dưới.
    )
    @EqualsAndHashCode.Exclude
    private Set<Course> courseSet = new HashSet<>();

    public Student(Integer id, String name, String email, String address, Set<Course> courseSet) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.courseSet = courseSet;
    }

    public Student() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<Course> getCourseSet() {
        return courseSet;
    }

    public void setCourseSet(Set<Course> courseSet) {
        this.courseSet = courseSet;
    }

    public void addCourse(Course course){
        this.courseSet.add(course);
    }

}
