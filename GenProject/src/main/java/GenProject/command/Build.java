package GenProject.command;

import picocli.CommandLine.Command;

import java.util.concurrent.Callable;

/**
 * Class implémentant la sous commande build.
 * @author Allemano Enzo
 */

@Command(name = "build", description = "Build a static site")
public class Build implements Callable<Integer>
{

    /**
     * Méthode pour l'appel de la commande build.
     */
    @Override public Integer call()
    {
        System.out.printf("build");
        return 0;
    }

}
