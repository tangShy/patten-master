package com.leetcode.test;

import java.util.Stack;

class Solution {
    public static boolean isPalindrome(int x) {
        if(x<0) return false;
        String s = String.valueOf(x);
        char[] ch = s.toCharArray();
        for(int i=0; i<ch.length/2; i++){
            if(ch[i] != ch[ch.length-i-1]) {
                return false;
            }
        }
        return true;
    }

    //739. 每日温度
/*    public static int[] dailyTemperatures(int[] T) {
        int[] result = new int[T.length];
        for(int i=0; i<T.length; i++) {
            int count = 0;
            for (int j=i+1; j<T.length; j++){
                if(T[j] > T[i]){
                    count ++;
                    result[i] = count;
                    break;
                }else{
                    count ++;
                }
            }
        }
        return result;
    }*/
    public static int[] dailyTemperatures(int[] T){
        int[] result = new int[T.length];
//        Deque<Integer> stack = new LinkedList<>();
        Stack stack = new Stack();
        for (int i=0; i<T.length; i++){
            while(!stack.isEmpty() && T[i]>T[(int) stack.peek()]){
                int prevIndex = (int) stack.pop();
                result[prevIndex] =i - prevIndex;
            }
            stack.push(i);
        }
        return result;
    }

    public static void main(String[] args) {
//        boolean palindrome = isPalindrome(12321);
//        System.out.println(palindrome);
        int[] T = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] result = dailyTemperatures(T);
        for (int i : result){
            System.out.print(i+",");
        }
    }
}
