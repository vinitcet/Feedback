package com.vinit.feedback.service;

import com.vinit.feedback.dao.AssessmentDao;
import com.vinit.feedback.entity.Assessment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AssessmentService {
    @Autowired
    public AssessmentDao assessmentDao;

    public List<Assessment> getUserAssessment(Long userId) {
        return assessmentDao.findAllByEmployeeId(userId);

    }

    public List<Assessment> getUserAssignedRequest(Long userId) {
        return assessmentDao.findAllByAccessorId(userId);

    }

    public List<Assessment> findAllAssessment() {
        return assessmentDao.findAll();
    }

    public List<Assessment> getUserReporteeAssessment(Long userId) {
        return assessmentDao.findAllByManagerId(userId);
    }

    public Assessment createAssesment(Assessment assessment) {
        return assessmentDao.save(assessment);
    }

    public Assessment completeAssesment(Assessment assessment) {
        return assessmentDao.save(assessment);
    }

    public Optional<Assessment> findAssessmentById(Long id) {
        return assessmentDao.findById(id);
    }

}
