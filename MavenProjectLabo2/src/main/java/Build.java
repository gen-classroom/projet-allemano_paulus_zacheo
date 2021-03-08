import picocli.CommandLine;
@CommandLine.Command(
        name = "build",
        description = "Says build")


public class Build implements Runnable{


    @Override
    public void run() {
        System.out.println("Hello, i'm the build command!");
    }
}
