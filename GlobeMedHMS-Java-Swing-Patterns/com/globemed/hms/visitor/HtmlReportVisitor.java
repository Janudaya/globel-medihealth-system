package com.globemed.hms.visitor;

import com.globemed.hms.model.Patient;
import com.globemed.hms.model.Appointment;
import com.globemed.hms.model.Invoice;
import com.globemed.hms.composite.RecordComponent;
import com.globemed.hms.composite.RecordLeaf;

public class HtmlReportVisitor implements ReportVisitor {
    private StringBuilder sb = new StringBuilder("<html><body>");
    @Override public void visit(Patient p){ sb.append("<h2>Patient ").append(p.getName()).append(" (").append(p.getId()).append(")</h2>"); }
    @Override public void visit(Appointment a){ sb.append("<div>Appointment: ").append(a.toString()).append("</div>"); }
    @Override public void visit(Invoice i){ sb.append("<div>Invoice: ").append(i.toString()).append("</div>"); }
    @Override public void visit(RecordComponent rc){ sb.append("<div><b>Folder:</b> ").append(rc.getTitle()).append("</div>"); }
    @Override public void visit(RecordLeaf leaf){ sb.append("<div>Item ").append(leaf.getTitle()).append(": ").append(leaf.getContent()).append("</div>"); }
    @Override public String getOutput(){ return sb.append("</body></html>").toString(); }
}
