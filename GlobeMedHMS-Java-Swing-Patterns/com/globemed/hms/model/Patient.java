package com.globemed.hms.model;

import java.util.ArrayList;
import java.util.List;
import com.globemed.hms.composite.RecordComponent;
import com.globemed.hms.visitor.Visitable;
import com.globemed.hms.visitor.ReportVisitor;

public class Patient implements Visitable {
    private String id;
    private String name;
    private int age;
    private List<Appointment> appointments = new ArrayList<>();
    private RecordComponent recordRoot; // Composite root

    public Patient(String id, String name, int age, RecordComponent recordRoot) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.recordRoot = recordRoot;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public List<Appointment> getAppointments() { return appointments; }
    public RecordComponent getRecordRoot() { return recordRoot; }

    @Override
    public void accept(ReportVisitor visitor) {
        visitor.visit(this);
        if (recordRoot != null) recordRoot.accept(visitor);
        for (Appointment a : appointments) a.accept(visitor);
    }

    @Override
    public String toString() {
        return "Patient{" + id + ", " + name + ", " + age + "}";
    }
}
