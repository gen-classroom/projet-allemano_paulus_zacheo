package GenProject.benchmark;

import GenProject.Statique;
import org.openjdk.jmh.annotations.*;
import picocli.CommandLine;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Benchmark)
public class BenchmarkStatique {
    @Setup
    public void setup()
    {
        new CommandLine(new Statique()).execute("init", "monSite");
    }

    @Benchmark
    public void benchmarkBuild()
    {
        new CommandLine(new Statique()).execute("build", "monSite");
    }
}