package java8;
public interface FunctionalInterfaces {
    int myMethod(int a,int b);
    default int myMethod2(int a,int b){
        return a*b;
    }
    
}
