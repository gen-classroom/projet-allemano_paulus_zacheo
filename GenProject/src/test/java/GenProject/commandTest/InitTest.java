/**
 -----------------------------------------------------------------------------------
 @Files     : InitTest
 @Author   : Luca Zacheo, Enzo Allemano, Yohann Paulus
 @Date        : 10.06.2021
 -----------------------------------------------------------------------------------
 */

package GenProject.commandTest;

import GenProject.Statique;
import org.junit.jupiter.api.Test;
import org.apache.commons.io.FileUtils;
import picocli.CommandLine;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
/**
 * Unit test for simple App.
 */
public class InitTest
{
    @Test
    public void initShouldWork() throws IOException {
        boolean result = false;
        String dir = "/monSite";
        String pathStr = System.getProperty("user.dir") + dir;

        new CommandLine(new Statique()).execute("init", dir);

        File configJson = new File(pathStr + "/config.json");
        File indexMd = new File(pathStr + "/index.md");


        if (configJson.exists() && indexMd.exists() ){
            result = true;
        }
        assertTrue(result);

    }
}
