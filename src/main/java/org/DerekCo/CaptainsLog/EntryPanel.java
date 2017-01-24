package org.DerekCo.CaptainsLog;

import javax.swing.*;
import javax.swing.text.DefaultCaret;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Mastermind on 12/24/16.
 */
public class EntryPanel {
    private JPanel mainPanel;
    JTextArea textArea;
    JScrollPane scroller;
    Entry entry;
    InputMap inputMap;

    public EntryPanel() {
        mainPanel = new JPanel();
//                              (rows, columns)
        textArea = new JTextArea(17, 35);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        // set the text area to auto-scroll down when appended to:
        DefaultCaret caret = (DefaultCaret)textArea.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
        scroller = new JScrollPane(textArea);

        mainPanel.add(scroller);

        entry = new Entry();

        inputMap = mainPanel.getInputMap();
        setActions();
        setKeyBindings();
    }

    public EntryPanel(Entry arg) {
        this();
        setEntry(arg);
    }

    public EntryPanel(String arg) {
        this();
        setEntry(new Entry(arg));
    }

    public EntryPanel(File archive){
        this();
        setEntry(new Entry(archive));
    }


    public void setEntry(Entry arg) {
        entry = arg;
        textArea.setText(arg.getContent());
    }

    public Entry getEntry() {
        return this.entry;
    }

    public JPanel getMainPanel(){ return mainPanel;}

    public String getContents() {
        return textArea.getText();
    }

    void save(String saveDir) {
        entry.setContent(textArea.getText());
        entry.save(saveDir);
    }

    void timestamp(){
        String timestamp = new SimpleDateFormat("HH:mm:ss").format(new Date());
        timestamp += "-- ";

        textArea.append("\n" + timestamp);
        int caretPosish = textArea.getDocument().getLength();
        textArea.setCaretPosition(caretPosish);
    }

    String getTitle() {
        return entry.title;
    }

    void setActions() {
        mainPanel.getActionMap().put("timestamp", new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                timestamp();
            }
        });
    }

    void setKeyBindings() {
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_T, InputEvent.CTRL_MASK), "timestamp");
    }
}
