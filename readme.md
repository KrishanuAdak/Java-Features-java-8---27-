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