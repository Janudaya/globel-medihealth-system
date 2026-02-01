package com.globemed.hms.ui;

import javax.swing.*;
import java.awt.*;
import com.globemed.hms.ui.tabs.*; 

public class MainFrame extends JFrame {
    public MainFrame(){
        super("GlobeMed HMS — Design Patterns Demo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(950, 650);
        setLocationRelativeTo(null);

        JTabbedPane tabs = new JTabbedPane();
        tabs.addTab("Patients (Composite + Decorator)", new PatientPanel());
        tabs.addTab("Appointments (Command)", new AppointmentPanel());
        tabs.addTab("Billing/Claims (Chain)", new BillingPanel());
        tabs.addTab("Reports (Visitor)", new ReportsPanel());
        tabs.addTab("Security (Decorator)", new SecurityPanel());

        add(tabs, BorderLayout.CENTER);
    }
}
