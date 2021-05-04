package GenProject.commandTest;

import GenProject.Statique;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import picocli.CommandLine;

import java.io.*;

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
        String contenuIndex = "" +
                "titre: Mon premier article\n" +
                "auteur: Bleuet Renard\n" +
                "date: Aujourd'hui\n" +
                "---\n" +
                "# Titre 1\n" +
                "## titre 2\n" +
                "Ceci est un site *internet*";

        myWriter.write(contenuIndex);
        myWriter.close();
        File f1 = new File(dir+"/test2.md");
        f1.createNewFile();
        myWriter = new FileWriter(f1);
        contenuIndex = "" +
                "titre: Mon premier article\n" +
                "auteur: Bleuet Renard\n" +
                "date: Aujourd'hui\n" +
                "---\n" +
                "# Titre 1\n" +
                "## titre 2\n" +
                "Ceci est un autre  site *internet*";

        myWriter.write(contenuIndex);
        myWriter.close();
        File f2 = new File(dir+"/test3.md");
        f2.createNewFile();
        myWriter = new FileWriter(f2);
        contenuIndex = "" +
                "titre: Mon premier article\n" +
                "auteur: Bleuet Renard\n" +
                "date: Aujourd'hui\n" +
                "---\n" +
                "# Titre 1\n" +
                "## titre 2\n" +
                "Ceci est encore un autre site *internet*";

        myWriter.write(contenuIndex);
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

    @Test
    public void buildShouldWriteTheCorrectContentToHtmlFile() throws IOException {
        boolean success =false;
        FileReader input = new FileReader(DIR_NAME + "/build/content/test1.html");
        BufferedReader in = new BufferedReader(input);
        String content = "";
        String msg = "";
        while((content = in.readLine()) != null)  {
            msg += content+"\n";
        }
        String result = "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "<meta charset=\"utf-8\">\n" +
                "<title>BleuetRenard</title>\n" +
                "<meta name=\"Data\" content=\"config\">\n" +
                "<meta name=\"title\" content=\" Mon premier article\">\n" +
                "<meta name=\"author\" content=\" Bleuet Renard\">\n" +
                "<meta name=\"date\" content=\" Aujourd'hui\">\n" +
                "</head>\n" +
                "<body>\n" +
                "<ul>\n<li><a href=\"/index.html\">home</a></li>\n" +
                "<li><a href=\"/content/page.html\">page</a></li>\n</ul>\n"+
                "<h1>Titre 1</h1>\n" +
                "<h2>titre 2</h2>\n" +
                "<p>Ceci est un site <em>internet</em></p>\n" +
                "</body>\n" +
                "</html>\n";
        if(msg.equals(result)) {
            success = true;
        }
        input = new FileReader(DIR_NAME + "/build/content/test2.html");
        in = new BufferedReader(input);
        content = "";
        msg = "";
        while((content = in.readLine()) != null)  {
            msg += content+"\n";
        }
        result = "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "<meta charset=\"utf-8\">\n" +
                "<title>BleuetRenard</title>\n" +
                "<meta name=\"Data\" content=\"config\">\n" +
                "<meta name=\"title\" content=\" Mon premier article\">\n" +
                "<meta name=\"author\" content=\" Bleuet Renard\">\n" +
                "<meta name=\"date\" content=\" Aujourd'hui\">\n" +
                "</head>\n" +
                "<body>\n" +
                "<ul>\n<li><a href=\"/index.html\">home</a></li>\n" +
                "<li><a href=\"/content/page.html\">page</a></li>\n</ul>\n"+
                "<h1>Titre 1</h1>\n" +
                "<h2>titre 2</h2>\n" +
                "<p>Ceci est un autre  site <em>internet</em></p>\n" +
                "</body>\n" +
                "</html>\n";
        if(msg.equals(result)) {
            success = true;
        }
        input = new FileReader(DIR_NAME + "/build/content/test3.html");
        in = new BufferedReader(input);
        content = "";
        msg = "";
        while((content = in.readLine()) != null)  {
            msg += content+"\n";
        }
        result = "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "<meta charset=\"utf-8\">\n" +
                "<title>BleuetRenard</title>\n" +
                "<meta name=\"Data\" content=\"config\">\n" +
                "<meta name=\"title\" content=\" Mon premier article\">\n" +
                "<meta name=\"author\" content=\" Bleuet Renard\">\n" +
                "<meta name=\"date\" content=\" Aujourd'hui\">\n" +
                "</head>\n" +
                "<body>\n" +
                "<ul>\n<li><a href=\"/index.html\">home</a></li>\n" +
                "<li><a href=\"/content/page.html\">page</a></li>\n</ul>\n"+
                "<h1>Titre 1</h1>\n" +
                "<h2>titre 2</h2>\n" +
                "<p>Ceci est encore un autre site <em>internet</em></p>\n" +
                "</body>\n" +
                "</html>§\n";
        if(msg.equals(result)) {
            success = true;
        }

        assertTrue(success);

    }



}
