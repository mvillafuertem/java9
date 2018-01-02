package com.mvillafuertem.method;

/**
 * Created by mvillafuertem on 20/05/2017.
 */
public interface Greeting {

    default public void sayHello() {
        System.out.println("Hello!");
    }
}
