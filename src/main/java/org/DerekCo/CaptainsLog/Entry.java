package org.DerekCo.CaptainsLog;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import javax.persistence.*;

/**
 * Created by Mastermind on 12/24/16.
 */
public class Entry {
    String title = "";
    private String content = "";
    String savePath = "ENTRIES";

    @Id
    @GeneratedValue
    private Long id;

    public Entry() {

    }

    public Entry(String name) {
        title = name;
    }

    public Entry(File entryFile) {
        title = entryFile.getName();


        //populate content:
        Charset charset = Charset.forName("US-ASCII");
        try (BufferedReader reader = Files.newBufferedReader(entryFile.toPath(), charset)) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                content += line;
                content += "\n";
            }
        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }
    }

    String getContent() {
        return content;
    }

    void setContent(String string) {
        content = string;
    }

    void save() {
        File saveDir = new File(System.getProperty("user.home") + File.separator + ".captainsLog"
                + File.separator + savePath);
        if (!saveDir.exists()) {
            saveDir.mkdir();
        }

        String content = getContent() + "\n";

        File filename = new File(saveDir.getAbsolutePath() + File.separator + this.title);
        try {
            FileWriter writer = new FileWriter(filename, false);
            writer.write(content);
            writer.close();
        } catch(IOException except) {
            except.printStackTrace();
        }
    }


    void save(String directory) {
        String content = this.getContent();
        content += "\n";
        File saveDir = new File(System.getProperty("user.home") + File.separator + ".captainsLog"
                + File.separator + directory);
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

}
