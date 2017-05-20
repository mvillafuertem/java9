import java.util.ArrayList;
import java.util.List;

/**
 * Created by mvillafuertem on 19/05/2017.
 */
public class LambdaApp {

    public String scopeLocal() {

        // Variable Local, no podrás redefinirla dentro de la expresión lambda, declararla como final es opcional
        final String s1 = "Hello";

        Greeting greeting = ( s2 ) -> s1 + s2 ;

        return greeting.say("World");
    }

    public static void main( String[] args) {
        List<String> myList = new ArrayList<>();
        myList.add("item");
        myList.add("item");
        myList.add("item");

        // Implementación del método de la interfaz
        Operation operation = mylist -> mylist;

        System.out.println( operation.mySortList(myList) );

        Scope scope = new Scope();
        System.out.println(scope.lambdaScope());

    }

}
