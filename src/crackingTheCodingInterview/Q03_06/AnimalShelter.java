package crackingTheCodingInterview.Q03_06;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

public class AnimalShelter {
    Queue<Cat> catQueue;
    Queue<Dog> dogQueue;
    private int order = 0;

    public AnimalShelter() {
        catQueue = new LinkedList<>();
        dogQueue = new LinkedList<>();
    }

    //enqueue
    public void enqueue(Animal a) {
        order++;
        a.setOrder(order);

        if( a instanceof Dog) {
            dogQueue.add((Dog)a);
        }

        if( a instanceof Cat) {
            catQueue.add((Cat) a);
        }
    }

    //dequeueAny
    public Animal dequeueAny() {
        if(catQueue.size() == 0) {
            return dequeueDog();
        } else if(dogQueue.size() == 0) {
            return dequeueCat();
        }

        Cat cat = catQueue.peek();
        Dog dog = dogQueue.peek();

        if( cat.getOrder() < dog.getOrder()) {
            //return cat
            return catQueue.poll();
        } else {
            //return dog
            return dogQueue.poll();
        }
    }

    //값 제거하기 않고 반환
    public Animal peekAny(){
        if(catQueue.size() == 0) {
            return peekDog();
        } else if( dogQueue.size() == 0) {
            return peekCat();
        }
        Cat cat = catQueue.peek();
        Dog dog = dogQueue.peek();

        if( cat.isOrderThan(dog)) {
            //return cat
            return cat;
        } else {
            //return dog
            return dog;
        }
    }

    //dequeueDog
    public Dog dequeueDog() {
        return dogQueue.poll();
    }

    //값 제거하지 않고 반환
    public Dog peekDog() {
        return dogQueue.peek();
    }

    //dequeueCat
    public Cat dequeueCat() {
        return catQueue.poll();
    }

    //값 제거하지 않고 반환
    public Cat peekCat() {
        return catQueue.peek();
    }

    public int size(){
        return catQueue.size() + dogQueue.size();
    }


}
