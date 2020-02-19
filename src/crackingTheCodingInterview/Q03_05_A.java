package crackingTheCodingInterview;

import java.util.Stack;

/**
 * 가장 작은 값이 위로 오도록 스택을 정렬하는 프로그램을 작성하라.
 * 추가적으로 하나 정도의 스택은 사용해도 괜찮지만, 스택에 보관된 요소를 배열등의 다른 자료구조로 복사할 수는 없다.
 * 스택은 push, pop, peek, isEmpty의 네가지 연산을 제공해야 한다.
 **/

public class Q03_05_A {
    //두 개의 스택을 이용하여 정렬을 한다.
    //정렬 대상의 값을 임시 적으로 저장하고, 정렬된 데이터와 비교하여 적절한 위치에 삽입한다.
    public static Stack sortStack(Stack<Integer> stack) {
        Stack<Integer> orderedStack = new Stack<>();

        while(!stack.isEmpty()) { //모두다 정렬할 때 까지
            int value = stack.pop(); //정렬 대상을 임시 변수에 저장

            while( !orderedStack.isEmpty() && value < orderedStack.peek()) { //비교 대상이 비어있지 않고 , 임시 값보다 더 클경우
                stack.push(orderedStack.pop()); // 다시 기존 스택에 추가
            }
            orderedStack.push(value); // while문을 벗어났으니 (value >= orderdStack.peek()) true
            //따라서 정렬된 스택에 추가해준다.

        }
        return reverse(orderedStack); //위에 코드는 내림차순으로 정렬되어 있기 때문에 내림차순으로 reverse

    }

    public static Stack reverse(Stack stack) {
        Stack resultStack = new Stack();

        while( !stack.isEmpty()) {
            resultStack.push(stack.pop());
        }

        return resultStack;
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(4);
        stack.push(2);
        stack.push(3);
        stack.push(5);

        Stack sorted = sortStack(stack);

        while( !sorted.isEmpty()) {
            System.out.println(sorted.pop());
        }
    }
}
