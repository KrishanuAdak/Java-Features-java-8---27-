package java8;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class AdvancedFunctionalInterface {
    public static void main(String[] args) {
        Predicate<Integer> greaterThan10=((n)->{
            return n>10;
        });

        Predicate<Integer> lessThan50=((n)->{
            return n<50;
        });
        Predicate<Integer> result=greaterThan10.and(lessThan50);
        Predicate<Integer> result2=greaterThan10.or(lessThan50);

        System.out.println("Result is "+result.test(130));
        System.out.println("Result is "+result2.test(130));
        // Functional Channing
        Function<Integer,Integer> multiplyBy2=((n)->{
            return n*2;
        });
        Function<Integer,Integer> addBy3=((n)->{
            return n+3;
        });
        Function<Integer,Integer> re=multiplyBy2.andThen(addBy3);

        // Bi Function
        BiFunction<Integer,Integer,Integer> tests=((a,b)->{
            return a+b;
        });
        System.out.println("Result is "+re.apply(10));

        // Consumer Chaining
        Consumer<String> c1=((n)->{
            System.out.println("Hey "+n);
        });

        Consumer<String> c2=((n)->{
            System.out.println("Welcome "+n);
        });

        c1.andThen(c2).accept("Krishanu");

        //Supplier
        Supplier<Employee> add=(()->{
            return new Employee("Krishanu", 12000,"Mecheda");
        });
        Supplier<String> ss= ()-> "kri".toUpperCase();
        

        System.out.println(add.get().getName());
    }
    
}
