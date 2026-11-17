Java 8 features
---------------

1.Lambda ( Allows us to write concise code )
List<Integer> li=Arrays.asList(1,3,2,3,4);
li.forEach((n)->{
    System.out.println(n);
});
2.Functional Interface 
An interface which has only one abstract method but others methods should be default or static 
Annotation @FunctionalInterface is optional but better to mention this

@FunctionalInterface
public interface Test{
    public int valCheck(int a,int b);
    default void check(){
        System.out.println("Checked);
    }
}

Predicate<Integer> => It takes input and process it then returns boolean result
Function<Integer,Integer> / Function<Object,Integer> => It takes the input and returns the modified result
[Only one Input and returns only one output]

BiFunction => [Takes two inputs]
Consumer<Integer> => It only takes input but doesn't return the result
Supplier<String> => It only returns result


Advanced Functional Interface
1.Predicate<Integer> and, or function [returs True / False]
2.Function Chaining [ Executes one by one statement]


Stream API
----------

The Java Stream API (introduced in Java 8 under java.util.stream) provides a functional, declarative way to process sequences of elements—such as collections, arrays, or I/O channels—without modifying the original data source.

A stream acts like a data pipeline. Instead of writing verbose for loops and if statements to manipulate data, you chain together high-level operations.

It has three layers.
1.Source
2.Intermediate
3.Termination

Source => Stream()
Intermediate =>

Operation Type	 Method	            Purpose
Intermediate	filter(Predicate)	Keeps only elements that match a boolean condition.
Intermediate	map(Function)	Transforms each element into another form or type.
Intermediate	flatMap(Function)	Flattens nested structures (e.g., List<List<T>>) into a single stream.
Intermediate	distinct()	Removes duplicate elements.
Intermediate	sorted()	Sorts elements naturally or using a custom Comparator.
Intermediate	limit(n) / skip(n)	Truncates the stream to n elements or discards the first n elements.

Terminal=>

Terminal	collect() / toList()	Gathers the stream elements into a List, Set, or Map.
Terminal	forEach(Consumer)	Performs an action (like printing) on each element.
Terminal	reduce(...)	Combines all elements into a single summary value (e.g., sum or max).
Terminal	count()	Returns the total number of elements in the stream.
Terminal	anyMatch() / allMatch()	Returns true or false based on whether elements match a condition.
Terminal	findFirst() / findAny()	Returns an Optional containing the first or any matching element.

Collect(),Collectors(),GroupingBy(similar to SQL group by)


 
