package org.DerekCo.CaptainsLog;

import javafx.scene.paint.*;
import javafx.stage.*;
import javafx.stage.Window;

import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.*;
import java.awt.event.WindowEvent;
import java.io.File;

/**
 * Created by Mastermind on 12/24/16.
 */
public class GuiMain {
    JFrame frame;
    JPanel toolbar;
    MainLogPanel mainLogPanel;
    JTabbedPane tabbedPane;


    public GuiMain() {
        frame = new JFrame("Captain's Log");
        Color bgColor = new Color(130,130,130);
        frame.setBackground(bgColor);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.setSize(480, 400);
        frame.addWindowListener(new ExitListener());
        frame.setLayout(new FlowLayout());

        initToolbar();

        tabbedPane = new JTabbedPane();
        tabbedPane.setTabLayoutPolicy(JTabbedPane.WRAP_TAB_LAYOUT);
        frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);

        mainLogPanel = new MainLogPanel();
        tabbedPane.addTab("Today", mainLogPanel);

        //not sure how this works; I cribbed it from the tutorial. I'll come back to it.
        tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);

        frame.setVisible(true);
    }

    void initToolbar() {
        toolbar = new JPanel();
        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(new SaveButtonListener());

        JButton timestampButton = new JButton("Timestamp");
        timestampButton.addActionListener(new TimestampButtonListener());

        JButton newEntryButton = new JButton("New Entry");
        newEntryButton.addActionListener(new NewEntryButtonListener());

        JButton loadEntryButton = new JButton("Archives");
        loadEntryButton.addActionListener(new LoadEntryButtonListener());


        toolbar.add(saveButton);
        toolbar.add(timestampButton);
        toolbar.add(newEntryButton);
        toolbar.add(loadEntryButton);

        frame.getContentPane().add(toolbar, BorderLayout.NORTH);
    }

    void addTab(EntryPanel entryPanel) {
        tabbedPane.addTab(entryPanel.getTitle(), entryPanel);
        int index = tabbedPane.indexOfTab(entryPanel.getTitle());
        tabbedPane.setTabComponentAt(index, new ButtonTabComponent(tabbedPane));
    }

    private class ExitListener extends WindowAdapter {
        public void windowClosing(WindowEvent event) {
            frame.setVisible(false);
            mainLogPanel.save("LOGS");
            System.exit(0);
        }
    }

    private class tabCloseButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            Component selected = tabbedPane.getSelectedComponent();
            if (selected != null) {
                tabbedPane.remove(selected);
            }
        }
    }

    private class SaveButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            mainLogPanel.save("LOGS");
        }
    }

    private class TimestampButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            tabbedPane.getSelectedComponent();
            mainLogPanel.timestamp();
        }
    }

    private class NewEntryButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            //create popup with a text input for the note's title
            String entryName = (String)JOptionPane.showInputDialog(
                    frame,
                    "Enter a Name for New Entry",
                    "New Entry",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    null,
                    null
            );
            if (entryName.length() > 0) {
                EntryPanel ep = new EntryPanel(entryName);
                tabbedPane.addTab(entryName, ep);
            }
        }
    }

    private class LoadEntryButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            File currentDir = new File(System.getProperty("user.home") + File.separator + ".captainsLog");
            final JFileChooser chooser = new JFileChooser(currentDir);
            int returnVal = chooser.showOpenDialog(frame);

            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File archive = chooser.getSelectedFile();

                EntryPanel ep = new EntryPanel(archive);
                addTab(ep);
            }
        }
    }
}
