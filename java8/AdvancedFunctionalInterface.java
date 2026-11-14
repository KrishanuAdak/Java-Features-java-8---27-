package java8;

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

        Supplier<Employee> add=(()->{
            return new Employee("Krishanu", 12000);
        });
        System.out.println(add.get().getName());
    }
    
}
