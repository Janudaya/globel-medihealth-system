package com.globemed.hms.ui.tabs;

import javax.swing.*;
import java.awt.*;
import com.globemed.hms.security.*;

public class SecurityPanel extends JPanel {
    private JComboBox<Role> roleBox = new JComboBox<>(Role.values());
    private JTextArea out = new JTextArea(18,60);

    public SecurityPanel(){
        setLayout(new BorderLayout(10,10));
        out.setEditable(false);
        add(new JScrollPane(out), BorderLayout.CENTER);

        JPanel actions = new JPanel();
        JButton doGeneral = new JButton("Run general action");
        JButton editRecord = new JButton("Edit patient record (restricted)");
        actions.add(doGeneral); actions.add(editRecord);

        add(roleBox, BorderLayout.NORTH);
        add(actions, BorderLayout.SOUTH);

        doGeneral.addActionListener(e -> runAction("generate monthly stats"));
        editRecord.addActionListener(e -> runAction("edit patient record"));
    }

    private void runAction(String action){
        Role r = (Role) roleBox.getSelectedItem();
        SecureService svc = new SecureServiceDecorator(new BasicService("CoreService"), r);
        out.append("Role " + r + ": " + svc.perform(action) + "\n");
    }
}
