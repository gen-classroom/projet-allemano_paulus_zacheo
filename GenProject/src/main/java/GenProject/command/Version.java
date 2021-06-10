/**
 -----------------------------------------------------------------------------------
 @Files     : Version
 @Author   : Luca Zacheo, Enzo Allemano, Yohann Paulus
 @Date        : 10.06.2021
 -----------------------------------------------------------------------------------
 */

package GenProject.command;

import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.Callable;

import picocli.CommandLine;
import picocli.CommandLine.Command;

import org.apache.maven.model.Model;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;

@Command(name = "version", description = "Return the project version")
public class Version implements Callable<Integer> {
    @CommandLine.Spec CommandLine.Model.CommandSpec spec;

    @Override public Integer call() throws Exception {

        try {
            MavenXpp3Reader reader = new MavenXpp3Reader();
            FileReader fr = new FileReader("pom.xml");
            Model model = reader.read(fr);
            spec.commandLine().getOut().println("v." + model.getVersion());
            fr.close();
        }
        catch (IOException e){
            System.out.println(e);
        }
        return 1;
    }
}

