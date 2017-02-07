package org.DerekCo.CaptainsLog;

import javax.swing.*;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Mastermind on 12/24/16.
 */
public class MainLogPanel extends EntryPanel {

    public MainLogPanel(){
        super();
        setEntry(getTodayLog());
    }


    Log getTodayLog() {
        Log todaysLog;
        String todayString = new SimpleDateFormat("yyyy_MM_dd").format(new Date());
        File todaysFile = new File(System.getProperty("user.home") + File.separator
                + ".captainsLog" + File.separator + "LOGS" + File.separator + todayString);
        if (todaysFile.exists()) {
            todaysLog = new Log(todaysFile);
        } else {
            todaysLog = new Log();
        }
        return todaysLog;
    }

}
