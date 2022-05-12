package com.vinit.feedback.service;

import com.vinit.feedback.dao.AssessmentDao;
import com.vinit.feedback.entity.Assessment;
import com.vinit.feedback.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class AssessmentService {
    @Autowired
    public AssessmentDao assessmentDao;
    @Autowired
    public UserUtil userUtil;

    public List<Assessment> getUserAssessment(Long userId) {
        List<Assessment> ass = assessmentDao.findAllByEmployeeId(userId);
        ass.stream().forEach(s -> {
                    s.setAccessorName(userUtil.getUserName(s.getAccessorId()).getFullName());
                    s.setEmployeeName(userUtil.getUserName(s.getEmployeeId()).getFullName());
                    s.setManagerName(userUtil.getUserName(s.getManagerId()).getFullName());
                }
        );
        ass.sort(Comparator.comparing(Assessment::getCreatedDate).reversed());
        return ass;

    }

    public List<Assessment> getUserAssignedRequest(Long userId) {
        List<Assessment> ass = assessmentDao.findAllByAccessorId(userId);
        ass.stream().forEach(s -> {
                    s.setAccessorName(userUtil.getUserName(s.getAccessorId()).getFullName());
                    s.setEmployeeName(userUtil.getUserName(s.getEmployeeId()).getFullName());
                    s.setManagerName(userUtil.getUserName(s.getManagerId()).getFullName());
                }
        );
        ass.sort(Comparator.comparing(Assessment::getCreatedDate).reversed());
        return ass;

    }

    public List<Assessment> findAllAssessment() {
        List<Assessment> ass = assessmentDao.findAll();
        ass.stream().forEach(s -> {
                    s.setAccessorName(userUtil.getUserName(s.getAccessorId()).getFullName());
                    s.setEmployeeName(userUtil.getUserName(s.getEmployeeId()).getFullName());
                    s.setManagerName(userUtil.getUserName(s.getManagerId()).getFullName());
                }
        );
        ass.sort(Comparator.comparing(Assessment::getCreatedDate).reversed());
        return ass;
    }

    public List<Assessment> getUserReporteeAssessment(Long userId) {
        List<Assessment> ass = assessmentDao.findAllByManagerId(userId);
        ass.stream().forEach(s -> {
                    s.setAccessorName(userUtil.getUserName(s.getAccessorId()).getFullName());
                    s.setEmployeeName(userUtil.getUserName(s.getEmployeeId()).getFullName());
                    s.setManagerName(userUtil.getUserName(s.getManagerId()).getFullName());
                }
        );
        ass.sort(Comparator.comparing(Assessment::getCreatedDate).reversed());
        return ass;
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
