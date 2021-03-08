import picocli.CommandLine;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@CommandLine.Command(
        subcommands = {
                New.class,
                Clean.class,
                Build.class,
                Serve.class
        }

)

public class Main {

        public static void main(String[] args) throws IOException {
            System.out.println("Add command name :");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            // Reading data using readLine
            String name = reader.readLine();
            int exitCode = new CommandLine(new Main()).execute(name);
            System.exit(exitCode);
        }


}




