import picocli.CommandLine;

@CommandLine.Command(
        name = "serve")



public class Serve implements Runnable{


    @Override
    public void run() {
        System.out.println("Hello, I'm the serve command!");
    }
}
