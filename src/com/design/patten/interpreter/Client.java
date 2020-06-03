package com.design.patten.interpreter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * 解释器模式：实现四则运算
 */
public class Client {
    public static void main(String[] args) throws IOException {
        String expStr = getExpStr();//a+b
        HashMap<String, Integer> var = getValue(expStr);//var={a=10,b=20}
        Calculator calculator = new Calculator(expStr);
        int result = calculator.run(var);
        System.out.println(expStr + "="+result);
    }

    //获得计算结构
    private static HashMap<String, Integer> getValue(String expStr) throws IOException {
        HashMap<String, Integer> map = new HashMap<>();

        for (char ch : expStr.toCharArray()){
            if(ch != '+' && ch != '-' && ch != '*'){
                if(!map.containsKey(String.valueOf(ch))){
                    System.out.println("请输入"+String.valueOf(ch)+"的值：");
                    String in = new BufferedReader(new InputStreamReader(System.in)).readLine();
                    map.put(String.valueOf(ch), Integer.valueOf(in));
                }
            }
        }
        return map;
    }

    //获取表达式
    private static String getExpStr() throws IOException {
        System.out.println("请输入表达式：");
        return new BufferedReader(new InputStreamReader(System.in)).readLine();
    }
}
