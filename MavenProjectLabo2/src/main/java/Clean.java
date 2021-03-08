import picocli.CommandLine;

@CommandLine.Command(
        name = "clean")

public class Clean implements Runnable{


    @Override
    public void run() {
        System.out.println("Hello, I'm the clean command!");
    }
}
