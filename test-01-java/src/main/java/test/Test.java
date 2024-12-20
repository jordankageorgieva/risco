package test;

import java.util.HashSet;
import java.util.Set;

public class Test {
    public static void main(String[] args) throws Exception {
        Cat c1 = new Cat();
        c1.setColor("black");
        c1.setAge(7);
        c1.setWeight(5.5);

        Cat c2 = new Cat();
        c2.setColor("white");
        c2.setAge(7);
        c2.setWeight(6);

        Cat c3 = new Cat();
        c3.setColor("black");
        c3.setAge(7);
        c3.setWeight(5.5);

        Set<Cat> set = new HashSet<>();
        set.add(c1);
        set.add(c2);
        set.add(c3);
        System.out.println(set.size());

        if (set.size() != 2) {
            throw new Exception("Wrong!");
        }

        System.out.println("Right!");
    }

}
