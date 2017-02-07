package org.DerekCo.CaptainsLog;
;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Mastermind on 12/24/16.
 */
@Entity
@Table
public class Log extends Entry {
    @Id
    @GeneratedValue
    private Long id;


    public Log() {
        super();
        title = new SimpleDateFormat("yyyy_MM_dd").format(new Date());
        savePath = "LOGS";
        System.out.println("Log init with savepath: " + savePath);
    }

    public Log(File logFile) {
        super(logFile);
    }

    @Override
    public String toString() {
        return "Log [id=" + id + ", title=" + title + ", contents=" + getContent() + "]";
    }

    @Override
    void save() {
        save("LOGS");
    }
}
