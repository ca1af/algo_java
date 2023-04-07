import java.util.LinkedHashSet;

public class Person {
    String name;
    private int age;

    public void speak() {
        System.out.println("저는 " + name + "입니다.");
    }
}

class Dancer extends Person {
    public void dance() {
        System.out.println(name + ": 춤을 춥니다.");
    }

    public static void main(String[] args) {
        Dancer dancer = new Dancer();
        dancer.speak();
        dancer.dance();
    }
}