/**
 * Created by mvillafuertem on 20/05/2017.
 */
public interface Saludo {

    default public void sayHello() {
        System.out.println("Hola!");
    }
}