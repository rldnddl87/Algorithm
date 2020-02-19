package crackingTheCodingInterview.Q03_06;

public class Dog extends Animal {

    public Dog(String name) {
        super(name);
    }

    @Override
    public String name() {
        return "This is Dog : " + name;
    }
}
