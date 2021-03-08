import picocli.CommandLine;

@CommandLine.Command(
        name = "hello",
        description = "Says hello"
)

public class Main implements Runnable{

        public static void main(String[] args) {
            CommandLine.run(new Main(), args);
        }

        @Override
        public void run() {
            System.out.println("Hello World!");
        }
    }


