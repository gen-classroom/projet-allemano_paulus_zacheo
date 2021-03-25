package GenProject;

import picocli.CommandLine;
import java.util.concurrent.Callable;
import GenProject.command.Build;

/**
 * Class implémentant la commande principale statique.
 * @author Allemano Enzo
 */
@CommandLine.Command(
        name = "statique",
        description = "A brand new static site generator.",
        subcommands = {Build.class})
public class App implements Callable<Integer>
{
    /**
     * Méthode pour l'appel de la commande de création statique
     */
    @Override
    public Integer call() throws Exception
    {
        CommandLine.usage(this, System.out);
        return 0;
    }


    /**
     * Point d'entrée du programme.
     * @param args Arguments
     */
    public static void main(String[] args)
    {
        int exitCode = new CommandLine(new App()).execute(args);

        System.exit(exitCode);
    }
}
