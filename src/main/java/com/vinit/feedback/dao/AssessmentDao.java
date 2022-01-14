package com.vinit.feedback.dao;

import com.vinit.feedback.entity.Assessment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssessmentDao extends JpaRepository<Assessment, Long> {

    List<Assessment> findAllByEmployeeId(Long userId);

    List<Assessment> findAllByManagerId(Long userId);
}
