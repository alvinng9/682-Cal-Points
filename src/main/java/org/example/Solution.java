package org.example;

import java.util.Stack;

public class Solution {
    public int calPoints(String[] operations) {
        //create a stack of integers
        Stack<Integer> stack = new Stack<>();
        //iterate through the given String array
        for (String here : operations) {
            //handle cases when the current String is "+"
            if (here.equals("+")) {
                int one = stack.pop();
                int two = stack.peek();
                stack.push(one);
                stack.push(one + two);
                //handle cases when the current String is "D"
            } else if (here.equals("D")) {
                stack.push(stack.peek() * 2);
                //handle cases when the current String is "C"
            } else if (here.equals("C")) {
                stack.pop();
                //handle cases when the current String is a digit
            } else {
                stack.push(Integer.valueOf(here));
            }
        }
        int sum = 0;
        //add up all the integers in the stack
        while(!stack.empty()) {
            sum += stack.pop();
        }
        return sum;
    }
}
