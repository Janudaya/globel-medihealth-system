package com.globemed.hms.ui.tabs;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;
import com.globemed.hms.visitor.*;
import com.globemed.hms.model.*;
import com.globemed.hms.composite.*;

public class ReportsPanel extends JPanel {
    private JEditorPane html = new JEditorPane("text/html","");
    private JTextArea text = new JTextArea(18,60);

    public ReportsPanel(){
        setLayout(new GridLayout(1,2,8,8));
        html.setEditable(false);
        text.setEditable(false);
        add(new JScrollPane(text));
        add(new JScrollPane(html));

        JButton gen = new JButton("Generate Reports (Visitor)");
        add(gen);
        gen.addActionListener(e -> generate());
    }

    private void generate(){
        // sample data
        RecordFolder root = new RecordFolder("Root");
        root.add(new RecordLeaf("Allergy", "Peanut"));
        root.add(new RecordLeaf("Note", "BP slightly high"));

        Patient p = new Patient("P-007", "Diana", 31, root);
        p.getAppointments().add(new Appointment("A-1", "Ahmed", LocalDateTime.now().plusDays(2)));
        Invoice inv = new Invoice("INV-1", 4200.0);

        ReportVisitor textV = new TextReportVisitor();
        ReportVisitor htmlV = new HtmlReportVisitor();

        p.accept(textV); inv.accept(textV);
        p.accept(htmlV); inv.accept(htmlV);

        text.setText(textV.getOutput());
        html.setText(htmlV.getOutput());
    }
}
