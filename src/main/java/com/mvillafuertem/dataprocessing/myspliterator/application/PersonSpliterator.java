package com.mvillafuertem.dataprocessing.myspliterator.application;

import com.mvillafuertem.dataprocessing.myspliterator.model.Person;

import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * @author Miguel Villafuerte
 * December, 2017
 */
public class PersonSpliterator implements Spliterator<Person> {

    private final Spliterator<String> lineSpliterator;
    private String name;
    private Integer age;
    private String city;

    public PersonSpliterator(final Spliterator<String> lineSpliterator) {
        this.lineSpliterator = lineSpliterator;
    }

    @Override
    public boolean tryAdvance(final Consumer<? super Person> action) {

        if (this.lineSpliterator.tryAdvance((line -> this.name = line)) &&
                this.lineSpliterator.tryAdvance((line -> this.age = Integer.parseInt(line))) &&
                this.lineSpliterator.tryAdvance((line -> this.city = line))

                ) {

            final Person p = new Person(this.name, this.age, this.city);
            action.accept(p);
            return true;
        }
        return false;
    }

    @Override
    public Spliterator<Person> trySplit() {
        return null;
    }

    @Override
    public long estimateSize() {
        return this.lineSpliterator.estimateSize() / 3;
    }

    @Override
    public int characteristics() {
        return this.lineSpliterator.characteristics();
    }
}
