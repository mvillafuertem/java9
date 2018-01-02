package com.mvillafuertem.dataprocessing.mystream;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import static java.util.function.Function.identity;

/**
 * @author Miguel Villafuerte
 * December, 2017
 */
public class MyStream {

    public static void main(String... args) {

        try {
            final Stream<String> stream1 = Files.lines(Paths.get(ClassLoader.getSystemResource("elquijote1").toURI()));
            final Stream<String> stream2 = Files.lines(Paths.get(ClassLoader.getSystemResource("elquijote2").toURI()));
            final Stream<String> stream3 = Files.lines(Paths.get(ClassLoader.getSystemResource("elquijote3").toURI()));
            final Stream<String> stream4 = Files.lines(Paths.get(ClassLoader.getSystemResource("elquijote4").toURI()));

//            System.out.println("Stream 1 : " + stream1.count());
//            System.out.println("Stream 2 : " + stream2.count());
//            System.out.println("Stream 3 : " + stream3.count());
//            System.out.println("Stream 4 : " + stream4.count());

            final Stream<Stream<String>> streamsOfStream = Stream.of(stream1, stream2, stream3, stream4);
//            System.out.println("# Stream : " + streamsOfStream.count());

            final Stream<String> streamOfLines = streamsOfStream.flatMap(identity());
//            System.out.println("# Lines : " + streamOfLines.count());


            final Function<String, Stream<String>> lineSplitter =
                    line -> Pattern.compile(" ").splitAsStream(line);

            final Stream<String> streamOfWords =
                    streamOfLines.flatMap(lineSplitter)
                    .map( String :: toLowerCase )
                    .filter( word -> word.length() == 4 )
                    .distinct();

            System.out.println("# words : " + streamOfWords.count());

        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }


    }
}
