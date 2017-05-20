/**
 * Created by mvillafuertem on 20/05/2017.
 */
public class Scope {
    private static String s1 = "Hello";
    private String s3;

    public String lambdaScope() {

        Greeting greeting = (s2) -> {

            s1 = s2;
            s3 = s1;

            return s3;
        };

        return greeting.say("World");
    }
}
