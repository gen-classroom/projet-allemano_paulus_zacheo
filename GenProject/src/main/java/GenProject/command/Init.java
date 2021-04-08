package GenProject.command;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.Callable;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import org.commonmark.node.*;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;



@Command(name = "init", description = "Initialize a static site directory with the wanted sub-files")

public class Init implements Callable<Integer> {
  @CommandLine.Parameters(index = "0", description = "the root pathname")
  private String rootPathname;

  @Override
  public Integer call() throws IOException {

    if (!(rootPathname.charAt(0) == '/')){
      System.out.println("The parameters must begin with /");
      return 0;
    }

    StringBuilder path = new StringBuilder(System.getProperty("user.dir") + rootPathname);

    new File(path.toString()).mkdirs();
    Writer indexWriter = new BufferedWriter(
            new OutputStreamWriter(
                    new FileOutputStream(path.toString() + "/index.md"),
                    StandardCharsets.UTF_8
            )
    );

    String contenuIndex = "" +
            "titre: Mon premier article\n" +
            "auteur: Bleuet Renard\n" +
            "date: Aujourd'hui\n" +
            "---\n" +
            "# Titre 1\n" +
            "## titre 2\n" +
            "Ceci est un site *internet*";


    indexWriter.write(contenuIndex);
    indexWriter.close();



    Writer configWriter = new BufferedWriter(
            new OutputStreamWriter(
                    new FileOutputStream(path.toString() + "/config.json"),
                    StandardCharsets.UTF_8
            )
    );

    configWriter.write("{\"title\": \"BleuetRenard\",\n\"Data\": \"config\"}");

    configWriter.close();



    return 0;
  }
}