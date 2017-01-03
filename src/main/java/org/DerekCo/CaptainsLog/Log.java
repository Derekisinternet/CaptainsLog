package org.DerekCo.CaptainsLog;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Mastermind on 12/24/16.
 */
public class Log extends Entry {

    public Log() {
        super();
        this.title = new SimpleDateFormat("yyyy_MM_dd").format(new Date());
    }
}
