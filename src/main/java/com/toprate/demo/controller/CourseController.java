package com.toprate.demo.controller;

import com.toprate.demo.dto.StudentDto;
import com.toprate.demo.entity.Course;
import com.toprate.demo.entity.Student;
import com.toprate.demo.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CourseController {

    @Autowired
    private ICourseService courseService;

    @GetMapping(path = "/course/list")
    public List<Course> getListAllCourse(){
        List<Course> courseList = courseService.getAllCourse();

        return courseList;
    }

    @GetMapping(path = "/course/{courseId}")
    public Course getCourseById(@PathVariable(name = "courseId") Integer id){
        return courseService.getCourseById(id);
    }

    @PostMapping(path = "/course/create")
    public ResponseEntity createCourse(@RequestBody Course course){
        return  ResponseEntity.ok().body(courseService.saveCourse(course));
    }

    @PostMapping(path = "/registry/{courseId}/{studentId}")
    public String registryCourse(@PathVariable(name = "courseId") Integer courseId,@PathVariable(name = "studentId") Integer studentId){
        courseService.registryClass(courseId,studentId);
        return "OK";
    }
}
