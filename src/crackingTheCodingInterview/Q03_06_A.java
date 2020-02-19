package crackingTheCodingInterview;

import crackingTheCodingInterview.Q03_06.Animal;
import crackingTheCodingInterview.Q03_06.AnimalShelter;
import crackingTheCodingInterview.Q03_06.Cat;
import crackingTheCodingInterview.Q03_06.Dog;


/**
 * 먼저 들어온 동물이 먼저 나가는 동물 보호소가 있다고 하자.(Queue)
 * 이 보호소는 개와 고양이만 수용한다.
 * 가장 오래된 동물부터(가장 먼저 들어온 동물부터) 입양할 수 있는데, 개와 고양이 중 어떤 동물을 데려갈지 선택할 수 있다.
 * 하지만 특정 동물을 지정해 데려갈 수는 없다.
 * 이 시스템을 자료구조로 구현하라
 * */
public class Q03_06_A {
    public static void main(String[] args) {
        AnimalShelter animals = new AnimalShelter();
        animals.enqueue(new Cat("Callie"));
        animals.enqueue(new Cat("Kiki"));
        animals.enqueue(new Dog("Fido"));
        animals.enqueue(new Dog("Dora"));
        animals.enqueue(new Cat("Kari"));
        animals.enqueue(new Dog("Dexter"));
        animals.enqueue(new Dog("Dobo"));
        animals.enqueue(new Cat("Copa"));


        System.out.println(animals.dequeueAny().name());
        System.out.println(animals.dequeueAny().name());
        System.out.println(animals.dequeueAny().name());

        animals.enqueue(new Dog("Dapa"));
        animals.enqueue(new Cat("Kilo"));

        while (animals.size() != 0) {
            System.out.println(animals.dequeueAny().name());
        }
    }
}
