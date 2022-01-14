package com.vinit.feedback.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Optional;

@Entity
@Table
public class Period {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private LocalDate start;
    private LocalDate end;
    private PeriodDeadline deadline = new PeriodDeadline();
    private boolean active = true;
    private String createdBy;
    private String modifiedBy;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;


    public static Period EMPTY() {
        return new Period();
    }

    public static Period starts(LocalDate date) {
        Period period = new Period();
        period.setStart(date);
        return period;
    }

    public static Period starts(Date date) {
        Period period = new Period();
        period.setStart(LocalDate.ofEpochDay(date.getTime()));
        return period;
    }

    public Period() {
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getStart() {
        return start;
    }

    //public void setStart(LocalDate start) { this.start = Date.from(start.atStartOfDay().atOffset(ZoneOffset.UTC).toInstant()); }
    public void setStart(final LocalDate start) {
        this.start = start;
    }

    public LocalDate getEnd() {
        return end;
    }

    //public void setEnd(LocalDate end) { this.end = Date.from(end.atStartOfDay().atOffset(ZoneOffset.UTC).toInstant()); }
    public void setEnd(final LocalDate end) {
        this.end = end;
    }

    public PeriodDeadline getDeadline() {
        if (deadline == null) {
            this.deadline = new PeriodDeadline();
        }
        return deadline;
    }

    public void setDeadline(PeriodDeadline deadline) {
        this.deadline = deadline;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
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

    public Period ends(LocalDate date) {
        this.setEnd(date);
        return this;
    }

    public Period ends(Date date) {
        this.setEnd(LocalDate.ofEpochDay(date.getTime()));
        return this;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Period other = (Period) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return Optional.ofNullable(start).map(start -> start.format(DateTimeFormatter.ISO_DATE)).orElse("") +
                " - " +
                Optional.ofNullable(end).map(end -> end.format(DateTimeFormatter.ISO_DATE)).orElse("");
    }
}
