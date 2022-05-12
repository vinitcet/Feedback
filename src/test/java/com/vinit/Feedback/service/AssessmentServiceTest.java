package com.vinit.Feedback.service;

import com.vinit.feedback.dao.AssessmentDao;
import com.vinit.feedback.entity.Assessment;
import com.vinit.feedback.service.AssessmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import java.util.Optional;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
class AssessmentServiceTest {

    public AssessmentService assessmentService;

    @MockBean
    public AssessmentDao assessmentDao;


    @Test
    public void testgetUserAssessment() {
        assessmentService = new AssessmentService();
        Optional<Assessment> assessment = Optional.of(new Assessment());
        when(assessmentDao.findById(any())).thenReturn(assessment);
        Assert.notNull(assessmentService.getUserAssessment(1l));
    }


}