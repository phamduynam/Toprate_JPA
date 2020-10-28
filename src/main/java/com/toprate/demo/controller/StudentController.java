package com.toprate.demo.controller;

import com.toprate.demo.dto.StudentDto;
import com.toprate.demo.entity.Student;
import com.toprate.demo.service.IStudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private IStudentService studentService;


    @GetMapping("/student/listAll")
    public List<Student> getListAllStudent(){
        return null;
    }

    @GetMapping("/course/listStudent/{courseId}")
    public List<StudentDto> getListStudentByCourseId(@PathVariable(name = "courseId") Integer id){
        return studentService.getAllStudentByCourseId(id);
    }

}
