package com.toprate.demo.service;

import com.toprate.demo.dto.StudentDto;
import com.toprate.demo.entity.Course;
import com.toprate.demo.entity.Student;

import java.util.List;
import java.util.Optional;

public interface ICourseService {
    List<Course> getAllCourse();

    Course getCourseById(Integer id) throws NullPointerException;

    Course saveCourse(Course course);

    void registryClass(Integer id_Course, Integer id_Student);

    void updateClass(Integer id_Course, Integer id_Student);
}
