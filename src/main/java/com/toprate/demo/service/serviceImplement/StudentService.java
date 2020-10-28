package com.toprate.demo.service.serviceImplement;

import com.toprate.demo.dto.StudentDto;
import com.toprate.demo.entity.Student;
import com.toprate.demo.repository.IStudentRepository;
import com.toprate.demo.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class StudentService implements IStudentService {
    @Autowired
    private IStudentRepository iStudentRepository;
    @Override
    public List<Student> getAllStudent() {
        return iStudentRepository.findAll();
    }

    @Override
    public Student getStudentById(Integer id) {
        return iStudentRepository.findById(id).get();
    }

    @Override
    public Student saveStudent(Student student) {
        iStudentRepository.save(student);
        return null;
    }

    @Override
    public List<StudentDto> getAllStudentByCourseId(Integer id) {
        List<Student> studentList = iStudentRepository.findStudentByCourseId(id);
        List<StudentDto> studentDtotList = new ArrayList<>();
        for (Student o : studentList) {
            studentDtotList.add(new StudentDto(o.getId(),o.getName(),o.getEmail(),o.getAddress()));
        }
        return studentDtotList;
    }

}
