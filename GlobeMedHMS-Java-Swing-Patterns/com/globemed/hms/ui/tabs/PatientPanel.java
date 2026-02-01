package com.globemed.hms.ui.tabs;

import javax.swing.*;
import java.awt.*;
import com.globemed.hms.decorator.*;
import com.globemed.hms.composite.*;
import java.nio.file.*;

public class PatientPanel extends JPanel {
    private JTextArea output = new JTextArea(18, 60);
    private JTextField fileField = new JTextField("./data/patients.dat");

    public PatientPanel(){
        setLayout(new BorderLayout(10,10));
        output.setEditable(false);
        add(new JScrollPane(output), BorderLayout.CENTER);

        JPanel controls = new JPanel(new GridLayout(0,1,5,5));
        JButton saveBtn = new JButton("Save Sample Patient Record (Decorator: Encrypt+Log)");
        JButton loadBtn = new JButton("Load");
        controls.add(new JLabel("Storage file:"));
        controls.add(fileField);
        controls.add(saveBtn);
        controls.add(loadBtn);
        add(controls, BorderLayout.EAST);

        saveBtn.addActionListener(e -> save());
        loadBtn.addActionListener(e -> load());
    }

    private String buildSampleComposite(){
        RecordFolder root = new RecordFolder("Root Record");
        RecordFolder history = new RecordFolder("History");
        RecordFolder meds = new RecordFolder("Medications");
        RecordLeaf note1 = new RecordLeaf("Allergy", "Penicillin");
        RecordLeaf note2 = new RecordLeaf("Surgery", "Appendectomy 2019");
        RecordLeaf rx1 = new RecordLeaf("Amoxicillin", "500mg x 5 days");
        history.add(note1); history.add(note2); meds.add(rx1);
        root.add(history); root.add(meds);
        // Simple text representation
        StringBuilder sb = new StringBuilder();
        sb.append("PatientRecord:\n");
        sb.append(" - History: Allergy(Penicillin), Surgery(Appendectomy 2019)\n");
        sb.append(" - Medications: Amoxicillin 500mg x 5 days\n");
        return sb.toString();
    }

    private void save(){
        try {
            DataSource ds = new FileDataSource(fileField.getText());
            ds = new EncryptionDecorator(new LoggingDecorator(ds));
            String content = buildSampleComposite();
            ds.writeData(content);
            output.setText("Saved patient record to " + Paths.get(fileField.getText()).toAbsolutePath());
        } catch (Exception ex){
            output.setText("Error: " + ex.getMessage());
        }
    }
    private void load(){
        try {
            DataSource ds = new EncryptionDecorator(new LoggingDecorator(new FileDataSource(fileField.getText())));
            String data = ds.readData();
            output.setText("Loaded:\n" + data);
        } catch (Exception ex){
            output.setText("Error: " + ex.getMessage());
        }
    }
}
