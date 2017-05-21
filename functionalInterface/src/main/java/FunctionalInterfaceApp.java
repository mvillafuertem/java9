/**
 * Created by mvillafuertem on 21/05/2017.
 */
public class FunctionalInterfaceApp implements Greeting  {

    public void sayHello() {
        // Defino el método de la interface
        Greeting greeting = () ->  System.out.println("Hello");
        // Llamo al metodo de la interface
        greeting.sayHello();
    }

    public static void main (String[] args) {
        FunctionalInterfaceApp app = new FunctionalInterfaceApp();
        app.sayHello();
    }

}
