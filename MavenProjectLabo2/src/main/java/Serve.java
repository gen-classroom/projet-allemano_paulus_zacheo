import picocli.CommandLine;

@CommandLine.Command(
        name = "serve",
        description = "Says serve")

public class Serve implements Runnable{


    @Override
    public void run() {
        System.out.println("Hello, i'm the serve command!");
    }
}
