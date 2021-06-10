/**
 -----------------------------------------------------------------------------------
 @Files     : BenchmarkRunner
 @Author   : Luca Zacheo, Enzo Allemano, Yohann Paulus
 @Date        : 10.06.2021
 -----------------------------------------------------------------------------------
 */

package GenProject.benchmark;

import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

public class BenchmarkRunner {
    public static void main(String[] args) throws RunnerException {
        Options options = new OptionsBuilder()
                .forks(1)
                .warmupIterations(3)
                .measurementIterations(5)
                .build();

        new Runner(options).run();


    }
}