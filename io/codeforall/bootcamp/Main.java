package io.codeforall.bootcamp;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

public class Main {

        public static void main(String[] args) throws IOException {

            String file1 = "resources/file1.txt";
            String file2 = "resources/file2.txt";

            long UniqueWordCounterFile1 = getWords(file1)
                    .distinct()
                    .count();
            System.out.println("file 1 has: " + UniqueWordCounterFile1 + " unique words");


            long UniqueWordCounterFile2 = getWords(file2)
                    .distinct()
                    .count();
            System.out.println("file 2 has: " + UniqueWordCounterFile2 + " unique words");

        }

        private static Stream<String> getWords(String filename) throws IOException {
            return Files.lines(Paths.get(filename))
                    .map(line -> line.split("\\W+"))
                    .flatMap(a -> Arrays.stream(a));
        }
    }
