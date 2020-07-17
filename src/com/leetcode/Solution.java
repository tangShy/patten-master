package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 126题：单词接龙
 * 给定两个单词（beginWord 和 endWord）和一个字典 wordList，找出所有从 beginWord 到 endWord 的最短转换序列。转换需遵循如下规则：
 *
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典中的单词。
 * 说明:
 *
 * 如果不存在这样的转换序列，返回一个空列表。
 * 所有单词具有相同的长度。
 * 所有单词只由小写字母组成。
 * 字典中不存在重复的单词。
 * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 *
 * 输入:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 *
 * 输出:
 * [
 *   ["hit","hot","dot","dog","cog"],
 *   ["hit","hot","lot","log","cog"]
 * ]
 *
 */
public class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result = new ArrayList<>();
        List<String> list = new ArrayList<>();
        list.add(beginWord);
        for(int i=0; i<wordList.size(); i++){
            if(wordList.get(i).toCharArray().length != beginWord.toCharArray().length){
                continue;
            }
            char[] ch1 = wordList.get(i).toCharArray();
            char[] ch2 = beginWord.toCharArray();
            int count = 0;
            for (char c1 : ch1){
                for (char c2 : ch2){
                    if (c1 == c2){
                        continue;
                    }else{
                        count++;
                    }
                }
                if(count == 1){
//                    list.add();
                }
            }
        }
        return result;
    }
}
