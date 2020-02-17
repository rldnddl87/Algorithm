package crackingTheCodingInterview;

import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * 배열 한 개로 스택 세 개를 어떻게 구현할지 설명하라
 * */
public class Q03_01_A {

    public static void printStacks(ArrayStack arrayStack) {
        System.out.println(Arrays.toString(arrayStack.getValue()));
    }
    public static void main( String[] args) throws Exception{
        ArrayStack stacks = new ArrayStack(4);
        printStacks(stacks);
        stacks.push(0, 10);
        printStacks(stacks);
        stacks.push(1, 20);
        printStacks(stacks);
        stacks.push(2, 30);
        printStacks(stacks);

        stacks.push(1, 21);
        printStacks(stacks);
        stacks.push(0, 11);
        printStacks(stacks);
        stacks.push(0, 12);
        printStacks(stacks);

        stacks.pop(0);
        printStacks(stacks);

        stacks.push(2, 31);
        printStacks(stacks);

        stacks.push(0, 13);
        printStacks(stacks);
        stacks.push(1, 22);
        printStacks(stacks);

        stacks.push(2, 31);
        printStacks(stacks);
        stacks.push(2, 32);
        printStacks(stacks);

        /* printed..
        *   [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
            [10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
            [10, 0, 0, 0, 20, 0, 0, 0, 0, 0, 0, 0]
            [10, 0, 0, 0, 20, 0, 0, 0, 30, 0, 0, 0]
            [10, 0, 0, 0, 20, 21, 0, 0, 30, 0, 0, 0]
            [10, 11, 0, 0, 20, 21, 0, 0, 30, 0, 0, 0]
            [10, 11, 12, 0, 20, 21, 0, 0, 30, 0, 0, 0]
            [10, 0, 12, 0, 20, 21, 0, 0, 30, 0, 0, 0]
            [10, 0, 12, 0, 20, 21, 0, 0, 30, 31, 0, 0]
            [10, 0, 13, 0, 20, 21, 0, 0, 30, 31, 0, 0]
            [10, 0, 13, 0, 20, 21, 22, 0, 30, 31, 0, 0]
            [10, 0, 13, 0, 20, 21, 22, 0, 30, 31, 31, 0]
            [10, 0, 13, 0, 20, 21, 22, 0, 30, 31, 31, 32]
        * */
    }

}
//고정된 최대 크기를 가지는 스택 3개를 1개의 배열로 구현
class ArrayStack{
    private int numberOfStacks = 3; //3개의 스택을 구현
    private int stackCapacity; //개별 스택의 크기
    private int[] values; //스택이 저장될 배열
    private int[] size; //각 스택의 사이즈를 저장

    public ArrayStack(int stackSize) {
        stackCapacity = stackSize;
        values = new int[stackCapacity * numberOfStacks]; //배열 초기화
        size = new int[numberOfStacks];
    }

    //pop 데이터를 제거
    public int pop(int stackNumber){
        if(isEmpty(stackNumber)) throw new NoSuchElementException();
        size[stackNumber]--;
        int idx = getTopIndex(stackNumber);
        int value = values[idx];
        values[idx] = 0;

        return value;
    }

    //peek 데이터를 반환만
    public int peek(int stackNumber) {
        if(isEmpty(stackNumber)) throw new NoSuchElementException();
        return values[getTopIndex(stackNumber)];
    }

    //isEmpty
    public boolean isEmpty(int stackNumber){

        return size[stackNumber] == 0;
    }

    //push
    public void push(int stackNumber , int data) throws Exception {
        if(isFull(stackNumber)) throw new Exception("stack is full");
        size[stackNumber]++;
        int insertIdx = getTopIndex(stackNumber);
        values[insertIdx] = data;

    }


    public int getTopIndex(int stackNumber) {
        int start = stackNumber * stackCapacity;
        int currentSize = size[stackNumber]; //스택의 몇개의 데이터가 있는지
        return start + currentSize - 1;
    }

    public boolean isFull(int stackNumber) {
        if(size[stackNumber] >= stackCapacity) return true;

        return false;
    }

    public int[] getValues(int stackNumber) {
        int[] data = new int[size[stackNumber]];

        for(int i = 0; i < data.length; i++) {
            data[i] = values[getTopIndex(stackNumber) + i];
        }

        return data;
    }

    public int[] getValue() {
        return values;
    }

}
