package com.globemed.hms.ui.tabs;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;
import com.globemed.hms.command.*;

public class AppointmentPanel extends JPanel {
    private AppointmentService service = new AppointmentService();
    private SchedulerInvoker invoker = new SchedulerInvoker();
    private JTextArea log = new JTextArea(18,60);
    private JTextField id = new JTextField("A-1001");
    private JTextField doctor = new JTextField("Fernandez");
    private JTextField time = new JTextField(LocalDateTime.now().plusDays(1).withHour(10).withMinute(0).toString());

    public AppointmentPanel(){
        setLayout(new BorderLayout(10,10));
        log.setEditable(false);
        add(new JScrollPane(log), BorderLayout.CENTER);

        JPanel form = new JPanel(new GridLayout(0,2,5,5));
        form.add(new JLabel("Appointment Id")); form.add(id);
        form.add(new JLabel("Doctor")); form.add(doctor);
        form.add(new JLabel("When (ISO)")); form.add(time);

        JButton book = new JButton("Book (Command)");
        JButton cancel = new JButton("Cancel (Command)");
        JButton history = new JButton("Show History");
        JPanel buttons = new JPanel();
        buttons.add(book); buttons.add(cancel); buttons.add(history);

        JPanel east = new JPanel(new BorderLayout(5,5));
        east.add(form, BorderLayout.NORTH);
        east.add(buttons, BorderLayout.SOUTH);

        add(east, BorderLayout.EAST);

        book.addActionListener(e -> {
            Command cmd = new BookAppointmentCommand(service, id.getText(), doctor.getText(), LocalDateTime.parse(time.getText()));
            log.append(invoker.invoke(cmd) + "\n");
        });
        cancel.addActionListener(e -> {
            Command cmd = new CancelAppointmentCommand(service, id.getText());
            log.append(invoker.invoke(cmd) + "\n");
        });
        history.addActionListener(e -> log.append("--- History ---\n" + invoker.getHistory() + "\n"));
    }
}
