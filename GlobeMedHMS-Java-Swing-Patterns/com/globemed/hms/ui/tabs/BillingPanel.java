package com.globemed.hms.ui.tabs;

import javax.swing.*;
import java.awt.*;
import com.globemed.hms.cor.*;

public class BillingPanel extends JPanel {
    private JTextArea out = new JTextArea(18,60);
    private JTextField patientId = new JTextField("P-001");
    private JTextField amount = new JTextField("2500");
    private JCheckBox eligible = new JCheckBox("Eligible", true);
    private JCheckBox covered = new JCheckBox("Covered", true);
    private JCheckBox supervisor = new JCheckBox("Supervisor Approved", true);

    public BillingPanel(){
        setLayout(new BorderLayout(10,10));
        out.setEditable(false);
        add(new JScrollPane(out), BorderLayout.CENTER);

        JPanel form = new JPanel(new GridLayout(0,2,5,5));
        form.add(new JLabel("Patient Id")); form.add(patientId);
        form.add(new JLabel("Amount")); form.add(amount);
        form.add(new JLabel("Flags:")); form.add(new JLabel(" "));
        form.add(eligible); form.add(covered); form.add(supervisor);

        JButton run = new JButton("Run Claims Pipeline (Chain of Responsibility)");
        JPanel east = new JPanel(new BorderLayout(5,5));
        east.add(form, BorderLayout.NORTH);
        east.add(run, BorderLayout.SOUTH);
        add(east, BorderLayout.EAST);

        run.addActionListener(e -> runChain());
    }

    private void runChain(){
        ClaimHandler chain = new EligibilityCheckHandler();
        chain.linkWith(new PolicyCoverageHandler())
             .linkWith(new SupervisorApprovalHandler())
             .linkWith(new PaymentProcessingHandler());

        ClaimRequest req = new ClaimRequest(patientId.getText(), Double.parseDouble(amount.getText()));
        req.eligible = eligible.isSelected();
        req.covered = covered.isSelected();
        req.supervisorApproved = supervisor.isSelected();

        String res = chain.handle(req);
        out.setText(res + "\n\nPaid = " + req.paid);
    }
}
