package GenProject.command;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.Callable;

import picocli.CommandLine;
import picocli.CommandLine.Command;




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


    indexWriter.write( "titre: Mon premier article\n");
    indexWriter.write( "auteur: Bleuet Renard\n");
    indexWriter.write( "date: Aujourd'hui\n");
    indexWriter.write( "---\n");


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