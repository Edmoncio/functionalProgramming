package com.functional.programming.dao;

import com.functional.programming.entities.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoursesDao extends JpaRepository<CourseEntity, Integer> {

}
