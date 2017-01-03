package org.DerekCo.CaptainsLog;

import javax.swing.*;

/**
 * Created by Mastermind on 12/24/16.
 */
public class MainLogPanel extends EntryPanel {
    Log mainLog = getTodayLog();
    public MainLogPanel(){
        super(mainLog);
    }

    Log getTodayLog() {
        //TODO: populate method
    }
}
