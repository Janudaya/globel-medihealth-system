package com.globemed.hms.visitor;

import com.globemed.hms.model.Patient;
import com.globemed.hms.model.Appointment;
import com.globemed.hms.model.Invoice;
import com.globemed.hms.composite.RecordComponent;
import com.globemed.hms.composite.RecordLeaf;

public class TextReportVisitor implements ReportVisitor {
    private StringBuilder sb = new StringBuilder();

    @Override public void visit(Patient p){ sb.append("Patient: ").append(p.getName()).append(" (").append(p.getId()).append(")\n"); }
    @Override public void visit(Appointment a){ sb.append("  Appointment: ").append(a.toString()).append("\n"); }
    @Override public void visit(Invoice i){ sb.append("  Invoice: ").append(i.toString()).append("\n"); }
    @Override public void visit(RecordComponent rc){ sb.append("  Record Folder: ").append(rc.getTitle()).append("\n"); }
    @Override public void visit(RecordLeaf leaf){ sb.append("    Record Item: ").append(leaf.getTitle()).append(" -> ").append(leaf.getContent()).append("\n"); }

    @Override public String getOutput(){ return sb.toString(); }
}
