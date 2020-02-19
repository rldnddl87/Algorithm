package making;

import java.util.*;

public class SetOfStacks {
    private List<Stack<Integer>> stacks = new ArrayList<>();
    private int capacity;

    public SetOfStacks(int capacity) {
        this.capacity = capacity;
    }

    public Stack getLastStack(){
        if( stacks == null) {
            return null;
        }

        return stacks.get(stacks.size() - 1);
    }

    //pop()
    public int pop() {
        Stack<Integer> stack = getLastStack();
        if (stack == null) throw new EmptyStackException();
        int value =  stack.pop();

        if(stack.size() == 0) {
            stacks.remove(stacks.size() - 1);
        }
        return value;
    }

    //push()
    public void push(int data) {
        Stack<Integer> lastStack = getLastStack();
        if( lastStack != null && lastStack.size() < capacity) {
            lastStack.push(data);
        } else {
            Stack<Integer> stack = new Stack<>();
            stack.push(data);
            stacks.add(stack);
        }

    }


}
