package java8;

import java.util.*;
import java.util.stream.Collectors;

public class StreamApi {
    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        //Filteres only even numbers
        list.stream().filter((n) -> {
            return n % 2 == 0;
        }).collect(Collectors.toList()).forEach(System.out::println);

        list.forEach(System.out::println);
        
        // Print Square of every numbers
        list.stream().map((n) -> {
            return Math.pow(n, 2);
        }).forEach(System.out::println);

        List<EmployeeTest> emp = List.of(new EmployeeTest("Krish", 1000000), new EmployeeTest("Rohit", 15000),
                new EmployeeTest("Sourav", 20000), new EmployeeTest("Krishanu", 12000));

        // emp.stream().filter((e)->e.getName().startsWith("K")).forEach((e)->System.out.print(e.getName()+"
        // "+e.getSalary()));
        //emp.stream().distinct().collect(Collectors.toList()).forEach((e) -> System.out.println(e.getName()));

        emp.stream().map((e)->e.getName()).collect(Collectors.toList()).forEach(System.out::println);

        //Sort using two variables
        emp.stream().sorted((a,b)->a.getSalary()-b.getSalary()).forEach((e)->{
            System.out.println(e.getName());
        });
        
        //Sort using comparator
        emp.stream().sorted(Comparator.comparingInt(EmployeeTest::getSalary).reversed())
        .map((e)-> e.getName()).forEach(System.out::println);

        // Find Highest Paid Employee
        emp.stream().sorted(Comparator.comparingInt(EmployeeTest::getSalary).reversed()).limit(1).forEach((e)->{
            System.out.println(e.getName()+" "+e.getSalary());
        });
        
        //2nd Highest Paid Employee
        emp.stream().sorted((a,b)-> b.salary-a.salary).skip(1).limit(1).
        forEach((e)-> System.out.println(e.getName()+ " Salary -> "+e.salary));


        //Total Salary
        int total=emp.stream().mapToInt((e)-> e.getSalary()).reduce(0,(a,b)->a+b);
        System.out.println("Total -> "+total);

        List<EmployeeTest> e=emp.stream().collect(Collectors.toList());
        for(EmployeeTest x:e){
            System.out.println(x.getName()+" "+x.getSalary());
        }


        





    }
}

class EmployeeTest {
    public String name;
    public int salary;

    public EmployeeTest(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null || getClass() != obj.getClass())
            return false;

        EmployeeTest e = (EmployeeTest) obj;

        return salary == e.salary &&
                Objects.equals(name, e.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, salary);
    }
}