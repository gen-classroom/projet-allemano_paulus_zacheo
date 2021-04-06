package GenProject.command;

import java.io.FileReader;
import java.util.concurrent.Callable;

import picocli.CommandLine;
import picocli.CommandLine.Command;


@Command(name = "version", description = "Return the project version")
public class Version implements Callable<Integer> {
    @CommandLine.Spec CommandLine.Model.CommandSpec spec;

    @Override public Integer call() throws Exception {


        return 1;
    }
}

