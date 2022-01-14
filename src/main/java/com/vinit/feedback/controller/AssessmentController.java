package com.vinit.feedback.controller;

import com.vinit.feedback.entity.Assessment;
import com.vinit.feedback.entity.AssessmentStatus;
import com.vinit.feedback.service.AssessmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.PathParam;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(value = "/assessment", produces = {MediaType.APPLICATION_JSON_VALUE})
public class AssessmentController {
    @Autowired
    public AssessmentService assessmentService;

    @GetMapping(value = "/listAssessment")
    public List<Assessment> findAllAssessment() {
        return assessmentService.findAllAssessment();
    }

    @GetMapping(value = "/listAssessmentByManager/{userId}")
    public List<Assessment> findAssesmentBymanagerId(@PathVariable Long userId) {
        return assessmentService.getUserReporteeAssessment(userId);
    }

    @GetMapping(value = "/listAssessmentByUser/{userId}")
    public List<Assessment> findAssesmentByUser(@PathVariable Long userId) {
        return assessmentService.getUserAssessment(userId);
    }

    @GetMapping(value = "/addAssessment")
    public void addAssesment() {
        Assessment assessment = new Assessment();
        assessment.setActive(true);
        assessment.setCreatedBy("Punit");
        assessment.setEmployeeId(2l);
        assessment.setManagerId(1l);
        assessment.setAccessorId(1l);
        assessment.setCreatedDate(LocalDateTime.now());
        assessment.setModifiedDate(LocalDateTime.now());
        assessment.setStatus(AssessmentStatus.Created);
        try {
            assessmentService.createAssesment(assessment);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
