package com.mvillafuertem.dataprocessing.myscrabble;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;
import java.util.function.ToIntFunction;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toSet;

/**
 * @author Miguel Villafuerte
 * December, 2017
 */
public class MyScrabble {

    public static void main(String... args) throws URISyntaxException, IOException {

        final Set<String> wordsOfScrabble = Files.lines(Paths.get(ClassLoader.getSystemResource("scrabble").toURI()))
                .map(String :: toLowerCase)
                .collect(toSet());

        System.out.println("# words : " + wordsOfScrabble.size());

        final List<Integer> scoreOfLetter = Arrays.asList(
//      a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p,  q, r, s, t, u, v, w, x, y, z
        1, 3, 3, 2, 1, 4, 2, 4, 1, 8, 5, 1, 3, 1, 1, 3, 10, 1, 1, 1, 1, 4, 4, 8, 4, 10);


        final Function<String, Integer> score =
                word -> word.chars().map(letter -> scoreOfLetter.get(letter - 'a')).sum();


        final ToIntFunction<String> intScore =
                word -> word.chars().map(letter -> scoreOfLetter.get(letter - 'a')).sum();

        System.out.println("Score of your word : " + intScore.applyAsInt("hello"));

        System.out.print("Best word: ");
        wordsOfScrabble.stream()
                .max(comparing(score))
                .ifPresent(System.out::println);


        final IntSummaryStatistics summaryStatistics = wordsOfScrabble.stream()
                .parallel()
                .mapToInt(intScore)
                .summaryStatistics();

        System.out.println(summaryStatistics);
    }
}
