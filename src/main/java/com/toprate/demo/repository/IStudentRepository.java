package com.toprate.demo.repository;

import com.toprate.demo.dto.StudentDto;
import com.toprate.demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IStudentRepository extends JpaRepository<Student, Integer> {

    @Query(value = "SELECT *  FROM student s JOIN class_room cr JOIN course c ON(s.id = cr.id_student and cr.id_course = c.id and c.id = :idCourse) ", nativeQuery = true)
    List<Student> findStudentByCourseId(@Param("idCourse") Integer id);

}
