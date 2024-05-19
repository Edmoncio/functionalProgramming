package com.functional.programming.dao;

import com.functional.programming.entities.CoursesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoursesDao extends JpaRepository<CoursesEntity, Integer> {

}
