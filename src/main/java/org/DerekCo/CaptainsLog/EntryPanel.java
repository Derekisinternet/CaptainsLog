package org.DerekCo.CaptainsLog;

import javax.swing.*;
import javax.swing.text.DefaultCaret;

/**
 * Created by Mastermind on 12/24/16.
 */
public class EntryPanel {
    JPanel mainPanel;
    JTextArea textArea;
    JScrollPane scroller;
    Entry entry;

    public EntryPanel() {
        mainPanel = new JPanel();
        textArea = new JTextArea();
        textArea.setLineWrap(true);
        // set the text area to auto-scroll down when appended to:
        DefaultCaret caret = (DefaultCaret)textArea.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
        scroller = new JScrollPane(textArea);
    }

    public EntryPanel(Entry arg) {

        EntryPanel panel = new EntryPanel();
        entry = arg;


        textArea.append(entry.getContent());
    }

    public JScrollPane mainPanel() {
        return scroller;
    }
}
