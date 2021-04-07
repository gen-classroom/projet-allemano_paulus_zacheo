package GenProject.commandTest;

import GenProject.Statique;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import picocli.CommandLine;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;

import static junit.framework.TestCase.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Unit test for simple App.
 */
public class BuildTest
{

    private static final String DIR_NAME = "monSite";


    @BeforeAll
    public static void initSite() {
        new CommandLine(new Statique()).execute("init", "/"+DIR_NAME);
    }

    @Test
    public void directoryBuildCreated() throws IOException {
        new CommandLine(new Statique()).execute( "build", DIR_NAME);
        File dir = new File(DIR_NAME + "/build");
        assertTrue(dir.exists());

    }

    @Test
    public void buildShouldConvertEveryMarkdownInPagesToHtml() throws IOException {

        // Create dir and markdown files

        File dir = new File(DIR_NAME + "/content/");
        dir.mkdir();

        File f = new File(dir+"/test1.md");
        f.createNewFile();
        FileWriter myWriter = new FileWriter(f);
        myWriter.write( "titre: Mon premier article\n");
        myWriter.write( "auteur: Bleuet Renard\n");
        myWriter.write( "date: Aujourd'hui\n");
        myWriter.write( "---\n");
        myWriter.close();
        File f1 = new File(dir+"/test2.md");
        f1.createNewFile();
        myWriter = new FileWriter(f1);
        myWriter.write( "titre: Mon Second article\n");
        myWriter.write( "auteur: Bleuet Renard\n");
        myWriter.write( "date: Aujourd'hui\n");
        myWriter.write( "---\n");
        myWriter.close();
        File f2 = new File(dir+"/test3.md");
        f2.createNewFile();
        myWriter = new FileWriter(f2);
        myWriter.write( "titre: Mon Troisième article\n");
        myWriter.write( "auteur: Bleuet Renard\n");
        myWriter.write( "date: Aujourd'hui\n");
        myWriter.write( "---\n");
        myWriter.close();

        // Exec command
        new CommandLine(new Statique()).execute("build", DIR_NAME);

        // Check test1.html exists
        File file = new File(DIR_NAME + "/build/content/test1.html");
        assertTrue(file.exists());

        // Check test2.html exists
        file = new File(DIR_NAME + "/build/content/test2.html");
        assertTrue(file.exists());

        // Check dir1/test3.html exists
        file = new File(DIR_NAME + "/build/content/test3.html");
        assertTrue(file.exists());
    }




}
