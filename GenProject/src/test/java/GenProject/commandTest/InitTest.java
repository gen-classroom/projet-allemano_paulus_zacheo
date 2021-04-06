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
        String pathStr = "./monSite";

        new CommandLine(new Statique()).execute("init", pathStr);

        File indexJson = new File(pathStr + "/index.json");
        File configJson = new File(pathStr + "/config.json");
        File indexMd = new File(pathStr + "/index.md");


        if (indexJson.exists() && configJson.exists() && indexMd.exists() ){
            result = true;
        }
        assertTrue(result);

        FileUtils.deleteDirectory(new File("./monSite"));
    }
}
