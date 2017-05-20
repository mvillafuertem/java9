/**
 * Created by mvillafuertem on 20/05/2017.
 */
public class DefaultMethodApp implements Greeting, Saludo {

    @Override
    public void sayHello() {
        Saludo.super.sayHello();
    }

    public static void main ( String[] args ) {
        DefaultMethodApp app = new DefaultMethodApp();
        app.sayHello();

    }
}
