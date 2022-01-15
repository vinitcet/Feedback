package com.vinit.feedback.controller;

import com.vinit.feedback.entity.Assessment;
import com.vinit.feedback.entity.AssessmentStatus;
import com.vinit.feedback.entity.User;
import com.vinit.feedback.service.AssessmentService;
import com.vinit.feedback.service.MailService;
import com.vinit.feedback.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/assessment", produces = {MediaType.APPLICATION_JSON_VALUE})
public class AssessmentController {
    @Autowired
    public AssessmentService assessmentService;
    @Autowired
    private UserService userService;

    @Autowired
    private MailService mailService;

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

    @GetMapping(value = "/listAssessmentByAssignee/{userId}")
    public List<Assessment> findAssesmentByAssignee(@PathVariable Long userId) {
        return assessmentService.getUserAssignedRequest(userId);
    }

    @PostMapping(value = "/addFeedbackRequest")
    //, consumes = "application/json", produces = "application/json")
    public String addFeedbackRequest(@RequestBody Assessment assessment) {
        assessment.setStatus(String.valueOf(AssessmentStatus.Created));
        User user = userService.getUser(assessment.getEmployeeId()).get();
        assessment.setManagerId(user.getReportsTo());
        assessment.setCreatedDate(LocalDateTime.now());
        assessment.setModifiedDate(LocalDateTime.now());
        assessment.setCreatedBy(user.getFullName());
        assessment.setActive(true);
        try {
            assessmentService.createAssesment(assessment);
        } catch (Exception e) {
            return "Error";
        }
        //Sending mail logic
        try {
            //mailService.sendSimpleMessage(assessment, user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Success";
    }

    @PutMapping(value = "/completeFeedback/{id}")
    public String completeFeedback(@RequestBody Assessment newAssessment, @PathVariable Long id) {
        Assessment assessment = assessmentService.findAssessmentById(id).get();
        assessment.setFeedback(newAssessment.getFeedback());
        assessment.setStatus(String.valueOf(AssessmentStatus.AccessorCompleted));
        assessment.setModifiedDate(LocalDateTime.now());
        assessment.setModifiedBy(userService.getUser(assessment.getAccessorId()).get().getFullName());
        try {
            assessmentService.completeAssesment(assessment);
        } catch (Exception e) {
            return "fail";
        }
        return "Success";
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
        assessment.setStatus(String.valueOf(AssessmentStatus.Created));
        try {
            assessmentService.createAssesment(assessment);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
