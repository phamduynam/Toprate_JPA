package com.toprate.demo.repository;

import com.toprate.demo.dto.StudentDto;
import com.toprate.demo.entity.Course;
import com.toprate.demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICourseRepository extends JpaRepository<Course,Integer> {


}