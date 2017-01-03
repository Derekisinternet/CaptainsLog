package org.DerekCo.CaptainsLog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by Mastermind on 12/24/16.
 */
public class GuiMain {
    JFrame frame;
    Log todayLog;

    public GuiMain() {
        frame = new JFrame("Captain's Log");
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.setSize(480, 270);
        frame.addWindowListener(new ExitListener());
        frame.setLayout(new FlowLayout());

        todayLog = new Log();

        frame.setVisible(true);
    }

    private class ExitListener extends WindowAdapter {
        public void windowClosing(WindowEvent event) {
            System.exit(0);
        }
    }
}
