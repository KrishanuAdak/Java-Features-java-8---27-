package java8;

import java.util.*;

public class Lambdas {
    public static void main(String[] args) {
        System.out.println("hello world");
        Thread th = new Thread(() -> {
            System.out.println("Thread is running");
            try {
                Thread.sleep(5000);
                System.out.println("Thread is running after 5 seconds" + Thread.currentThread().getName());

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        th.start();

        List<String> list = Arrays.asList("acc", "berr", "c", "d", "bcc", "adv");
        list.sort((a, b) -> {
            return a.compareTo(b);
        });
        list.forEach((names) -> {
            System.out.println(names);
        });
        list.stream().filter((n) -> {
            return n.length() > 1;
        }).forEach(System.out::println);

        Pairs[] pairs = new Pairs[4];
        for (int i = 0; i < pairs.length; i++) {
            pairs[i] = new Pairs((char) ('a' + i), i);
        }
        Arrays.sort(pairs, (a, b) -> {
            if (a.num == b.num) {
                return b.val - a.val;
            }
            return a.num - b.num;
        });
        for (Pairs pair : pairs) {
            System.out.println(pair.val + " -> " + pair.num);
        }

        List<Integer> li2 = Arrays.asList(8, 11, 9, 123, 90, 36, 23, 111);
        li2.forEach((nee) -> {
            if (nee % 2 == 0) {
                System.out.println(nee);
            }
        });
        li2.sort((a,b)->{
            return b-a;
        });
        li2.forEach(System.out::println);

    }

    public boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

}

class Pairs {
    public char val;
    public int num;

    public Pairs(char val, int num) {
        this.val = val;
        this.num = num;
    }
}
