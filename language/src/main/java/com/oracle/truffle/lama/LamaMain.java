package com.oracle.truffle.lama;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.graalvm.polyglot.Context;

public class LamaMain {
    private static final String SOURCE_FILE = "performance/Sort.lama";

    public static void main(String[] args) throws IOException {
        Context context = Context.create();
        String sourceCode;
        sourceCode = String.join("\n", Files.readAllLines(Paths.get(SOURCE_FILE)));
        context.eval("lama", sourceCode);
    }
}