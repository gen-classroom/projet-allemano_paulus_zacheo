package GenProject.commandTest;

import GenProject.Statique;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import picocli.CommandLine;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

/**
 * Unit test for simple App.
 */


public class ServeTest
{

    private static final String DIR_NAME = "monSite";
    /**
     * Rigorous Test :-)
     */
    @Test
    public void ShouldSignalWhenWatch() throws IOException {

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        new CommandLine(new Statique()).execute( "serve","--watch",DIR_NAME);

        String expectedOutput  = "Watch parameter is ON\r\n";

        // Do the actual assertion.
        Assertions.assertEquals(expectedOutput, out.toString());

    }
}
