package com.toprate.demo.service;

import com.toprate.demo.dto.StudentDto;
import com.toprate.demo.entity.Student;

import java.util.List;
import java.util.Optional;

public interface IStudentService {
    List<Student> getAllStudent();

    Student getStudentById(Integer id) throws NullPointerException;

    Student saveStudent(Student student);

    List<StudentDto> getAllStudentByCourseId(Integer id);

}
