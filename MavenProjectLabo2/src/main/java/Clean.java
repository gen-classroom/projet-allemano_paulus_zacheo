import picocli.CommandLine;

@CommandLine.Command(
        name = "clean",
        description = "Says clean")


public class Clean implements Runnable{



    @Override
    public void run() {
        System.out.println("Hello, i'm the clean command");
    }
}
