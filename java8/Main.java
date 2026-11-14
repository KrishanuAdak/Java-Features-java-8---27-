package java8;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
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
        

        // Predicate<T> is a functional interface that takes a single argument of type T and returns a boolean value. It is used to test whether a given input satisfies a certain condition or not.
        Predicate<Integer> checkLength=((s)->{
            return s.toString().length()<5;
        });
        System.out.println(checkLength.test(1234));

        Predicate<Integer> checkEligible=((salary)->{
            return salary>50000;
        });
        // System.out.println(checkEligible.test(100000));
        Predicate<Integer> checkBonus=((salary)->{
            return salary>100000;
        });
        Predicate<Integer> res=checkEligible.and(checkBonus);
        System.out.println("Result " +res.test(200000));

        // Function is a functional interface that takes a single argument of type T and returns a value of type R. It is used to transform an input of type T into an output of type R.
        Function<Integer,Integer> square=(n)->{
            return n*n;
        };
        Function<String,Integer> len=((s)->{
            return s.length();
        });

        System.out.println(square.apply(5));
        System.out.println("Length of string is"+len.apply("Hello World"));

        Function<Employee,Integer> getSalary=((e)->{
            return e.getSalary();
        });
        Employee emp=new Employee("krishanu", 12000);
        System.out.println("Salary of employee is "+getSalary.apply(emp));
        

        //Consumer is a functional interface that takes a single argument of type T and performs some operation on it without returning any value. It is used to represent an action that can be performed on an input of type T.
        Consumer<Employee> printEmployeeName=((e)->{
            System.out.println("Employee name is "+e.getName());
        });
        printEmployeeName.accept(emp);
        printEmployeeName.andThen(printEmployeeName).accept(emp);

       //Supplier is a functional interface that does not take any arguments and returns a value. It is used to generate or supply values on demand.
        Supplier<Integer> random=()->{
            return (int)(Math.random()*100);
        };
        System.out.println("Random number is "+random.get());

        Supplier<String> result=()->{
            return "Hello world";

        };
        System.out.println(result.get());
    }
}
