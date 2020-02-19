package crackingTheCodingInterview.Q03_06;

public class Cat extends Animal {


    public Cat(String name) {
        super(name);
    }

    @Override
    public String name() {
        return "This is Cat : " + name;
    }
}
