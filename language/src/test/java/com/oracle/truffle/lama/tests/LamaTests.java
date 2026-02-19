package com.oracle.truffle.lama.tests;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

import org.graalvm.polyglot.Context;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public final class LamaTests {
    private final PrintStream standardOut = System.out;
    private final InputStream standardIn = System.in;

    // DEBUG
    /* @Test
    void testOneFile() throws IOException {
        Context context = Context.create();
        String sourceCode = String.join("\n", Files.readAllLines(Paths.get("regression/test100.lama")));
        context.eval("lama", sourceCode);
    } */

    // DEBUG
    /* @Test
    void testOneFileSubInput() throws IOException {
        System.setIn(new ByteArrayInputStream("0".getBytes()));

        Context context = Context.create();
        String sourceCode = String.join("\n", Files.readAllLines(Paths.get("performance/Sort.lama")));
        context.eval("lama", sourceCode);
    } */

    @Test
    void testRegression() throws IOException {
        Path filesDir = Paths.get("regression/");
        try (Stream<Path> paths = Files.list(filesDir)) {
            List<String> pathsList = paths
                .map((path) -> path.toString())
                .sorted()
                .toList();

            for (String lamaFile: pathsList) {
                if (!lamaFile.endsWith(".lama"))
                    continue;

                Path path = Paths.get(lamaFile);
                standardOut.println("=== Executing test " + path.getFileName());
                
                String inputFile = lamaFile.replaceFirst("\\.lama$", ".input");
                String expectedOutputFile = lamaFile.replaceFirst("\\.lama$", ".expected");

                System.setIn(new ByteArrayInputStream(Files.readAllBytes(Paths.get(inputFile))));
                OutputStream outContent = new ByteArrayOutputStream();
                System.setOut(new PrintStream(outContent));
                
                Context context = Context.create();
                String sourceCode = String.join("\n", Files.readAllLines(Paths.get(lamaFile)));
                context.eval("lama", sourceCode);

                String actualOutput = outContent.toString().replace("\r\n", "\n").strip();
                String expectedOutput = String.join("\n", Files.readAllLines(Paths.get(expectedOutputFile)));
                Assertions.assertEquals(expectedOutput, actualOutput);

                standardOut.println("=== Test " + path.getFileName() + " passed successfully");
                standardOut.flush();
            }
        }

        System.setIn(standardIn);
        System.setOut(standardOut);
    }

    @Test
    void testPerformance() throws IOException {
        Path filesDir = Paths.get("performance/");
        try (Stream<Path> paths = Files.list(filesDir)) {
            List<String> pathsList = paths
                .map((path) -> path.toString())
                .sorted()
                .toList();

            for (String lamaFile: pathsList) {
                if (!lamaFile.endsWith(".lama"))
                    continue;

                Path path = Paths.get(lamaFile);
                standardOut.println("=== Executing test " + path.getFileName());
                
                String inputFile = lamaFile.replaceFirst("\\.lama$", ".input");
                String expectedOutputFile = lamaFile.replaceFirst("\\.lama$", ".expected");

                System.setIn(new ByteArrayInputStream(Files.readAllBytes(Paths.get(inputFile))));
                OutputStream outContent = new ByteArrayOutputStream();
                System.setOut(new PrintStream(outContent));
                
                Context context = Context.create();
                String sourceCode = String.join("\n", Files.readAllLines(Paths.get(lamaFile)));
                
                long startTime = System.nanoTime();
                context.eval("lama", sourceCode);
                long endTime = System.nanoTime();

                String actualOutput = outContent.toString().replace("\r\n", "\n").strip();
                String expectedOutput = String.join("\n", Files.readAllLines(Paths.get(expectedOutputFile)));
                Assertions.assertEquals(expectedOutput, actualOutput);

                standardOut.println("=== Test " + path.getFileName() + " passed successfully");
                double time = Double.valueOf(endTime - startTime) / 1_000_000_000;
                standardOut.println("=== Time: " + time + " s");

                standardOut.flush();
            }
        }

        System.setIn(standardIn);
        System.setOut(standardOut);
    }
}
