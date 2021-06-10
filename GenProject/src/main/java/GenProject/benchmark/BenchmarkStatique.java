/**
 -----------------------------------------------------------------------------------
 @Files     : BenchmarkStatique
 @Author   : Luca Zacheo, Enzo Allemano, Yohann Paulus
 @Date        : 10.06.2021
 -----------------------------------------------------------------------------------
 */

package GenProject.benchmark;

import GenProject.Statique;
import org.openjdk.jmh.annotations.*;
import picocli.CommandLine;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Benchmark)

public class BenchmarkStatique {
    @Setup
    public void setUp()  {
        new CommandLine(new Statique()).execute("init", "monSite");
    }

    @Benchmark
    public void building() {
        new CommandLine(new Statique()).execute("build", "monSite");
    }



}