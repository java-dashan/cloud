package comaaa.test.jdk8;

public class test {
    public static void main(String[] args) {
        test t = new test();
        c c = t.get();
//        c.q("666");
    }
    public c get() {
        return this::aaa;
    }

    public void aaa(String a) {
        System.out.println(11);
        System.out.println(22);
        say();
        System.out.println(a);
    }

    public void say() {
        System.out.println(123);
    }
}
