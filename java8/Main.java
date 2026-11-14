package java8;
import java.util.function.Predicate;
public class Main{
    public static void main(String[] args) {
        FunctionalInterfaces fi=(a,b)->{
            return a+b;
        };
        System.out.println(fi.myMethod(10,5));
        Predicate<Integer> check=(n)->{
            return n%2==0;
        };
        System.out.println(check.test(20));
            
    }
}
