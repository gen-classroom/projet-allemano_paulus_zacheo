import picocli.CommandLine;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@CommandLine.Command(
        name = "hello",
        description = "Says hello",
        subcommands = {
            New.class,
            Clean.class,
            Build.class,
            Serve.class
        }

)

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));

        // Reading data using readLine
        String name = reader.readLine();
        new CommandLine(new Main()).execute(name);
    }

}


