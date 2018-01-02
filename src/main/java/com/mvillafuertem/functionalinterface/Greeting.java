package com.mvillafuertem.functionalinterface;

/**
 * Created by mvillafuertem on 21/05/2017.
 *
 * Caracteristicas de las Interfaces Funcionales
 *  · No puedes tener mas de un metodo declarado
 *  · No puedes definir metodos por defecto (Default Method)
 */
@FunctionalInterface
public interface Greeting {
    void sayHello();
}
