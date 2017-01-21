package org.DerekCo.CaptainsLog;

import java.io.File;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        File appDir = new File(System.getProperty("user.home") + File.separator + ".captainsLog");
        if (!appDir.exists()) {
            appDir.mkdir();
        }
        GuiMain gui = new GuiMain();
    }
}
