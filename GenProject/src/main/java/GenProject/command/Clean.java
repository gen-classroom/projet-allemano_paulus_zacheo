package GenProject.command;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.Callable;

import org.apache.commons.io.FileUtils;
import picocli.CommandLine.Command;

@Command(name = "clean", description = "Clean a static site")
public class Clean implements Callable<Integer> {

  @Override public Integer call() throws IOException {
    File targetDirectory = new File(new File(".").getCanonicalPath());
    File buildDirectory = new File(targetDirectory.getPath() + "/build");
    if (buildDirectory.exists()) {
      try {
        FileUtils.deleteDirectory(buildDirectory);
      } catch (IOException ioException) {
        System.err.println("Error while deleting the build directory");
      }
    } else {
      System.err.println("Build directory does not exist");
    }
    return 0;
  }

}