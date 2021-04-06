package GenProject.commandTest;

import GenProject.Statique;
import org.junit.jupiter.api.Test;
import picocli.CommandLine;

import java.io.File;
import java.io.IOException;

import static junit.framework.TestCase.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Unit test for simple App.
 */
public class CleanTest
{

    @Test
    void testCleanDeletesBuildDirectory() throws IOException {
        File testDirectory = new File(new File(".").getCanonicalPath() + "/build");
        testDirectory.mkdir();
        assertTrue(testDirectory.exists());
        new CommandLine(new Statique()).execute("clean");
        assertFalse(testDirectory.exists());
    }

    @Test
    void testCleanDeletesFilesInsideDirectoryToo() throws IOException {
        File testDirectory = new File(new File(".").getCanonicalPath() + "/build");
        File testHtmlFile = new File(testDirectory.getPath() + "/index.html");
        testDirectory.mkdir();
        testHtmlFile.createNewFile();
        assertTrue(testDirectory.exists());
        assertTrue(testHtmlFile.exists());
        new CommandLine(new Statique()).execute("clean");
        assertFalse(testDirectory.exists());
        assertFalse(testHtmlFile.exists());
    }

}
