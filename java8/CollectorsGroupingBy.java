package java8;

import java.util.*;
import java.util.stream.Collectors;

public class CollectorsGroupingBy {
    public static void main(String[] args) {
        List<Employee> list = new ArrayList<>();
        list.add((new Employee("Kri", 10000, "Mecheda")));
        list.add(new Employee("Soga", 20000, "Kolaghat"));
        list.add(new Employee("King", 30000, "Mecheda"));
        list.add(new Employee("Bobi", 250000, "Kolkata"));
        list.add(new Employee("Stifen", 100000, "Kolaghat"));
        list.add((new Employee("Kri", 11000, "Mecheda")));
        list.stream().forEach((e) -> System.out.println(e.name));
        list.stream().collect(Collectors.toSet()).forEach(System.out::println);
        ;
        // System.out.println(t);
        long count = list.stream().collect(Collectors.counting());
        System.out.println("count - " + count);

        List<Employee> l = list.stream().filter((e) -> e.location.startsWith("Mecheda")).collect(Collectors.toList());
        // for(Employee e:l){
        // System.out.println(e.name+" "+e.salary);

        // }
        Set<Employee> set = list.stream().collect(Collectors.toSet());

        for (Employee s : set) {
            System.out.println(s.name + " " + s.salary);
        }
        list.stream().map((e) -> e.salary).distinct().forEach(System.out::println);

        // Joining Method
        List<String> strs = Arrays.asList("kri", "bob", "aja");

        String str = list.stream().map(Employee::getName).collect(Collectors.joining(" "));
        System.out.println("Joining Method - " + str);

        Map<String, Long> ress = list.stream()
                .collect(Collectors.groupingBy(Employee::getLocation, Collectors.counting()));
        System.out.println("Count " + ress);

        Map<String, List<String>> lists = list.stream()
                .collect(Collectors.groupingBy(Employee::getLocation,
                        Collectors.mapping(Employee::getName, Collectors.toList())));

        lists.forEach((location, name) -> {
            System.out.println(location + " " + name);
        });

        Map<String, List<Integer>> e = list.stream().collect(Collectors.groupingBy(Employee::getLocation,
                Collectors.mapping(Employee::getSalary, Collectors.toList())));
        e.forEach((location, salary) -> {
            System.out.println("Location - " + location + " Salary " + salary);
        });

        Map<String, Double> xx = list.stream().collect(
                Collectors.groupingBy(Employee::getLocation,
                        Collectors.averagingDouble(Employee::getSalary)));
        xx.forEach((location, avg) -> {
            System.out.println("Location " + location + "Average " + avg);
        });

        Map<String,Integer> sal=list.stream().collect(Collectors.groupingBy(Employee::getLocation,Collectors.summingInt(Employee::getSalary)));
        long s=list.stream().collect(Collectors.summingInt(Employee::getSalary));
        System.out.println("Total Salary - "+s);
    }
}
