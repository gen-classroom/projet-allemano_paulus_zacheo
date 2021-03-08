import picocli.CommandLine;

@CommandLine.Command(
        name = "new",
        description = "Says New")

public class New implements Runnable{



    @Override
    public void run() {
        System.out.println("Hello, i'm the new command!");
    }
}
