package comaaa.test.jdk8.stream;

import org.apache.el.stream.Stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class test {
    public static void main(String[] args) {
        List<User> list = new ArrayList<>();
        list.add(new User("a", 1));
        list.add(new User("b", 2));
        list.add(new User("c", 3));
        list.add(new User("d", 4));
        List<String> collect = list.stream().map((user) -> {
            return user.getName();
        }).collect(Collectors.toList());
        for (String a : collect) {
            System.out.println(a);
        }

        List<Integer> collect1 = list.stream().map((user) -> {
            return user.getAge();
        }).collect(Collectors.toList());
        for (int a : collect1) {
            System.out.println(a);
        }
    }
}
