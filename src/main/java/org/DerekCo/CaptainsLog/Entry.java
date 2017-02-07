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
    String savePath;

    @Id
    @GeneratedValue
    private Long id;

    public Entry() {
        savePath="ENTRIES";
    }

    public Entry(String name) {
        this();
        title = name;
    }

    public Entry(File entryFile) {
        this();
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
        save("ENTRIES");
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

    File getSaveDir() {
        return new File(System.getProperty("user.home") + File.separator + ".captainsLog"
                + File.separator + this.savePath);
    }

}
