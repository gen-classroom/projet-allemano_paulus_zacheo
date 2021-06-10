package GenProject.command;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.Callable;

import picocli.CommandLine;
import picocli.CommandLine.Command;

@Command(name = "serve", description = "Serve a static site")
public class Serve implements Callable<Integer> {


  @CommandLine.Option(names = "--watch", description = "Watch option")
  Boolean watch = false;

  @CommandLine.Parameters(index = "0", description = "Path of the build directory for the website")
  String userPath;

  @Override public Integer call()
  {

    if (watch){
      System.out.println("Watch parameter is ON");
    }

    do {
      try {
        File fileToOpen = new File("GenProject" + "/" + userPath + "/" + "build" + "/" + "index.html");
        Desktop.getDesktop().open(fileToOpen);
      } catch (IOException e) {
        e.printStackTrace();
      }
      try {
        Thread.sleep(5000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

    }while(watch);

    return 0;
  }

}