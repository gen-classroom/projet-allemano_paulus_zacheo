package GenProject.commandTest;

import GenProject.Statique;
import org.junit.Test;
import picocli.CommandLine;

import java.io.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Unit test for simple App.
 */
public class VersionTest
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldReturnTheVersion()
    {
       ByteArrayOutputStream out = new ByteArrayOutputStream();
       PrintStream oldOut = System.out;
       System.setOut(new PrintStream(out));
       new CommandLine(new Statique()).execute("version");     
       assertEquals("v.0.2.0\n", out.toString());
    }
}
