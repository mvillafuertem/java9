import java.util.ArrayList;
import java.util.List;

/**
 * Created by mvillafuertem on 19/05/2017.
 */
public class LambdaApp {

    public static void main( String[] args) {
        List<String> myList = new ArrayList<>();
        myList.add("item");
        myList.add("item");
        myList.add("item");

        // Implementación del método de la interfaz
        Operation operation = mylist -> mylist;

        System.out.println( operation.mySortList(myList) );

    }

}
