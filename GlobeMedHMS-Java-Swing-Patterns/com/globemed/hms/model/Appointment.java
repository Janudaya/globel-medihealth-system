package com.globemed.hms.model;

import java.time.LocalDateTime;
import com.globemed.hms.visitor.Visitable;
import com.globemed.hms.visitor.ReportVisitor;

public class Appointment implements Visitable {
    private String id;
    private String doctor;
    private LocalDateTime when;

    public Appointment(String id, String doctor, LocalDateTime when) {
        this.id = id;
        this.doctor = doctor;
        this.when = when;
    }
    public String getId() { return id; }
    public String getDoctor() { return doctor; }
    public LocalDateTime getWhen() { return when; }

    @Override
    public void accept(ReportVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String toString() {
        return "Appointment{" + id + ", Dr." + doctor + ", " + when + "}";
    }
}
