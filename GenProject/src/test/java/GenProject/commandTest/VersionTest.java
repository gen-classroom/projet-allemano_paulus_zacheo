package GenProject.commandTest;

import org.junit.Test;

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
        String version = "0.0.1";
        String result = ""; //return of the function getVersion
        boolean IsEqual = version.equals(result);
        assertTrue(IsEqual);
    }
}
