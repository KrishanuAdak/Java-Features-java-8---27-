package java8;
import java.util.*;
public class Optionals {

    public static void main(String[] args) {
        String name="Bhaijan";
        Optional<String> isCheck=Optional.of(name);
       // name=null;
        Optional<String> isNull=Optional.ofNullable(name);
        Optional<String> ifPresent=Optional.empty();
        System.out.println(isCheck.isEmpty());
        System.out.println(isNull.isPresent());
        // System.out.println(isCheck.ifPresent(name))
        // ;
        String res="eee";
        Optional<String> r=Optional.of(res);
        String gg=r.orElse("Test");
        System.out.println(gg);

    }
    
}
