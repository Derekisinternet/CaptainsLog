package org.DerekCo.CaptainsLog;

import java.io.BufferedReader;
import java.io.File;
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
            }
        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }
    }

    String getContent(){
        return content;
    }

    void setContent(String string) {
        content = string;
    }

    void setTitle(String arg) {
        title = arg;
    }

    void save() {}

}
