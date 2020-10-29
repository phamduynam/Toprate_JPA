package com.toprate.demo.service.serviceImplement;


import com.toprate.demo.dto.StudentDto;
import com.toprate.demo.entity.Course;
import com.toprate.demo.entity.Student;
import com.toprate.demo.repository.ICourseRepository;
import com.toprate.demo.repository.IStudentRepository;
import com.toprate.demo.service.ICourseService;
import com.toprate.demo.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.*;

@Service
@Transactional
public class CourseService implements ICourseService {
    @Autowired
    private ICourseRepository courseRepository;

    @Autowired
    private IStudentService iStudentService;

    @Override
    public List<Course> getAllCourse() {
        return courseRepository.findAll();
    }

    @Override
    public Course getCourseById(Integer id) {
        return courseRepository.findById(id).get();
    }

    @Override
    public Course saveCourse(Course course) {
        courseRepository.save(course);
        return getCourseById(course.getId());
    }

    @Override
    public void registryClass(Integer id_Course, Integer id_Student) {
        // Tìm khóa học chứa id = id_Course
        Course course = getCourseById(id_Course);
        Student student = iStudentService.getStudentById(id_Student);
        // Tìm Student có id = id_Student
//        Student student = iStudentService.getStudentById(id_Student);
        // add Student vào listStudent của Course.
        course.addStudent(student);
        student.addCourse(course);
        // Lưu vào db
        courseRepository.save(course);
        iStudentService.saveStudent(student);
    }

    public void updateClass(Integer id_Course, Integer id_Student){
        Course course = getCourseById(id_Course);
        Student student = iStudentService.getStudentById(id_Student);
        // Neu khong tim thay course hoac student
        if(course == null || student == null ){
            System.out.println("Student hoac Course khong tim thay");
        }
        // Lay danh sach cua course va student
        Set<Student> studentSet = course.getStudentSet();
        Set<Course> courseSet = student.getCourseSet();
        // xoa student va course trong set
        studentSet.remove(student);
        courseSet.remove(course);
        // cap nhat lai

        course.setStudentSet(studentSet);
        student.setCourseSet(courseSet);
        courseRepository.save(course);
        iStudentService.saveStudent(student);
    }

}
