package com.mvillafuertem.dataprocessing.myspliterator.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author Miguel Villafuerte
 * December, 2017
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Person {

    private String name;
    private Integer age;
    private String city;
}
