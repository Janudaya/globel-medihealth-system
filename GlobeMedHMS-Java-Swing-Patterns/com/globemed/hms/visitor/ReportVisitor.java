package com.globemed.hms.visitor;

import com.globemed.hms.model.Patient;
import com.globemed.hms.model.Appointment;
import com.globemed.hms.model.Invoice;
import com.globemed.hms.composite.RecordComponent;
import com.globemed.hms.composite.RecordLeaf;

public interface ReportVisitor {
    void visit(Patient p);
    void visit(Appointment a);
    void visit(Invoice i);
    void visit(RecordComponent rc);
    void visit(RecordLeaf leaf);
    String getOutput();
}
