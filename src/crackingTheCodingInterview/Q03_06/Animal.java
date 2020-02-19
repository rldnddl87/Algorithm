package crackingTheCodingInterview.Q03_06;

public abstract class Animal {
    private int order;
    protected String name; //상속받은경우 접근 가능하도록

    public Animal(String name) {
        this.name = name;
    }

    public abstract String name();

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public boolean isOrderThan(Animal a) {
        return this.order < a.getOrder();
    }



}
