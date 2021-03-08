import picocli.CommandLine;

@CommandLine.Command(
        name = "new")

public class New implements Runnable{



    @Override
    public void run()  {
        System.out.println("Hello, I'm the new command!");
    }
}
