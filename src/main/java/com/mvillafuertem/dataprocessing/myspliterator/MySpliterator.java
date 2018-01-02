package com.mvillafuertem.dataprocessing.myspliterator;

import com.mvillafuertem.dataprocessing.myspliterator.application.PersonSpliterator;
import com.mvillafuertem.dataprocessing.myspliterator.model.Person;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Spliterator;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class MySpliterator {

    public static void main(String... args) {

        try {
            final Path path = Paths.get(ClassLoader.getSystemResource("personas").toURI());
            final Stream<String> lines = Files.lines(path);
            final Spliterator<String> lineSpliterator = lines.spliterator();

            final Spliterator<Person> peopleSpliterator = new PersonSpliterator(lineSpliterator);
            final Stream<Person> people = StreamSupport.stream(peopleSpliterator, false);

            people.forEach(System.out::println);

        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }


    }
}
