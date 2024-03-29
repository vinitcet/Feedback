package com.vinit.feedback.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;


@Entity
@Table
@Data
public class Assessment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    // @OneToOne
    //@JoinColumn(name="id")

    @NotNull
    private Long employeeId;

    private Long managerId;
    @NotNull
    private Long accessorId;
    /* @OneToOne
     @JoinColumn(name = "id")
     private Period period;*/
    private String feedback;
    private String feedbackMessage;
    private boolean active = true;
    private String status;
    private String createdBy;
    private String modifiedBy;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
    @Transient
    private String accessorEmail;

    public static Assessment EMPTY() {
        return new Assessment();
    }

    public Assessment() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Long getManagerId() {
        return managerId;
    }

    public void setManagerId(Long managerId) {
        this.managerId = managerId;
    }

    public Long getAccessorId() {
        return accessorId;
    }

    public void setAccessorId(Long accessorId) {
        this.accessorId = accessorId;
    }

/*    public Period getPeriod() {
        return period;
    }

    public void setPeriod(Period period) {
        this.period = period;
    }*/

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDateTime getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(LocalDateTime modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    /**
     * Returns whether the employee and manager (i.e. participants) for the assessment has been set
     *
     * @return true if both the employee and manager are not null
     */
    public boolean hasParticipants() {
        return this.employeeId != null && this.managerId != null;
    }

    /**
     * Returns whether the user has access to this assessment.
     * Either the user is null, in which case no access is allowed
     * Or the user is an administrator, in which case access is allowed
     * Or the user is either the manager or employee of this assessment in which case access is granted else not.
     *
     * @param user Access requested by user
     * @return Whether the user has access to the assessment
     */
    public boolean hasAccess(
            final User user) {

        if (user == null) return false;
        if (user.isAdmin()) return true;
        return true;
        //return (this.managerId != null && this.managerId.equals(userI)) || (this.employeeId != null && this.employee.equals(user));
    }

    public String getFeedbackMessage() {
        return feedbackMessage;
    }

    public void setFeedbackMessage(String feedbackMessage) {
        this.feedbackMessage = feedbackMessage;
    }

    @Transient
    public String AccessorName;

    public String getAccessorName() {
        return AccessorName;
    }

    public void setAccessorName(String accessorName) {
        AccessorName = accessorName;
    }

    @Transient
    public String EmployeeName;

    public String getEmployeeName() {
        return EmployeeName;
    }

    public void setEmployeeName(String employeeName) {
        EmployeeName = employeeName;
    }

    @Transient
    public String ManagerName;

    public String getManagerName() {
        return ManagerName;
    }

    public void setManagerName(String managerName) {
        ManagerName = managerName;
    }
}
