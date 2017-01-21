package org.DerekCo.CaptainsLog;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

/**
 * Created by Mastermind on 12/24/16.
 */
public class EntryTest extends TestCase {
    Entry entry;

//    @Before
//    entry = new Entry();

    @Test
    public void testStringConstructor() {
        String title = "test title";
        entry = new Entry(title);
        assertEquals(title, entry.title);
    }

    @Test
    public void testFileConstructor() {
        String rootDir = System.getProperty("user.dir" );

        File tester = new File(rootDir + File.separator
                + "src" + File.separator + "test" + File.separator + "java" + File.separator + "org" +
                File.separator + "DerekCo" + File.separator + "CaptainsLog" + File.separator + "test_entries"
                + File.separator + "test_entry_1");
        entry = new Entry(tester);
        assertEquals("This is my first test entry.\n\nThat is all.\n", entry.getContent());
    }

    @Test
    public void testSaveWithoutTitle(){

    }

}
