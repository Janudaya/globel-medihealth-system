package com.globemed.hms;

import javax.swing.SwingUtilities;
import com.globemed.hms.ui.MainFrame;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MainFrame().setVisible(true);
        });
    }
}
