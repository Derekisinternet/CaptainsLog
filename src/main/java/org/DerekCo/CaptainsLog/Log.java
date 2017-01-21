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
        this.title = new SimpleDateFormat("yyyy_MM_dd").format(new Date());
    }

    public Log(File logFile) {
        super(logFile);
    }

    void save() {
        String content = this.getContent();
        content += "\n";
        File saveDir = new File(System.getProperty("user.home") + File.separator + ".captainsLog"
            + File.separator + "LOGS");
        if (!saveDir.exists()) {
            saveDir.mkdir();
        }

        File filename = new File(saveDir.getAbsolutePath() + File.separator + this.title);

        try {
            FileWriter writer = new FileWriter(filename, false);
            writer.write(content);
            writer.close();
        } catch(IOException except) {
            except.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Log [id=" + id + ", title=" + title + ", contents=" + getContent() + "]";
    }
}
