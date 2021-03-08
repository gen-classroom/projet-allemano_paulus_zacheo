import picocli.CommandLine;

@CommandLine.Command(
        name = "build")


public class Build implements Runnable{


    @Override
    public void run() {
        System.out.println("Hello, I'm the build command!");
    }
}
