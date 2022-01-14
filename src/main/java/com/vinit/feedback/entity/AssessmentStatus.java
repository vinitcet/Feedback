package com.vinit.feedback.entity;

import org.apache.commons.lang3.StringUtils;

import javax.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public enum AssessmentStatus {
    Creating("Creating", true),
    Created("Created", false),
    EmployeeCompleted("Employee Completed", false),
    AccessorCompleted("Accessor Completed", false),
    Reviewed("Reviewed", false),
    All("All", false);

    private final String description;
    private final boolean allowEditing;

    private AssessmentStatus(final String description, final boolean allowEditing) {
        this.description = description;
        this.allowEditing = allowEditing;
    }

    public String getDescription() {
        return description;
    }

    public boolean isEditingAllowed() {
        return this.allowEditing;
    }

    /**
     * Returns the status that follows the current status in the assessment progression
     */
    public AssessmentStatus getNextStatus() {
        switch (this) {
            case Creating:
                return Created;
            case Created:
                return EmployeeCompleted;
            case EmployeeCompleted:
                return AccessorCompleted;
            case AccessorCompleted:
                return Reviewed;
            case Reviewed:
                return Reviewed;
            default:
                return this;
        }
    }

    public static AssessmentStatus fromString(@NotNull final String description) {
        if (StringUtils.isBlank(description)) {
            throw new IllegalArgumentException("The assessment status description cannot be null");
        }

        switch (description) {
            case "Created":
                return Created;
            case "Employee Completed":
            case "EmployeeCompleted":
                return EmployeeCompleted;
            case "Manager Completed":
            case "ManagerCompleted":
                return AccessorCompleted;
            case "Reviewed":
                return Reviewed;
            default:
                throw new IllegalArgumentException("The assessment status " + description + " is unknown.");
        }
    }

    public static List<AssessmentStatus> list() {
        return Arrays.asList(All, Creating, Created, EmployeeCompleted, AccessorCompleted, Reviewed);
    }

    public static Stream<AssessmentStatus> stream() {
        return list().stream();
    }

    public String toString() {
        return this.description;
    }
}
