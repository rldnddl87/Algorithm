package leetcode;
import java.util.*;
/*
412. Fizz Buzz
Write a program that outputs the string representation of numbers from 1 to n.
But for multiples of three it should output “Fizz” instead of the number and for the multiples of five output “Buzz”.
For numbers which are multiples of both three and five output “FizzBuzz”.
* */
public class n412 {
    public List<String> fizzBuzz(int n) {
        //3의 배수 Fizz
        //5의 배수 Buzz
        //15의 배수 FizzBuzz

        List<String> list = new ArrayList<>();

        for(int i = 1; i <= n; i++) {
            String str = "";

            if( i % 3 == 0) {
                str+="Fizz";
            }

            if( i % 5 == 0) {
                str+="Buzz";
            }

            if( str.equals("")) {
                str += i;
            }

            list.add(str);
        }

        return list;

    }
}
