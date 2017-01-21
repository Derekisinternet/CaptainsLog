package org.DerekCo.CaptainsLog;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * displays the most recent entries that were viewed.
 */
public class RecentsPanel {
    JPanel mainPanel;

    public RecentsPanel() {
        mainPanel = new JPanel();


    }

    File logDir = new File(System.getProperty("user.home") + File.separator + ".captainsLog" + File.separator + "LOGS");
    File notesDir = new File(System.getProperty("user.home") + File.separator + ".captainsLog" + File.separator + "ENTRIES");
    File[] recentLogs = logDir.listFiles();


    private class LoadButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {

        }
    }
}
