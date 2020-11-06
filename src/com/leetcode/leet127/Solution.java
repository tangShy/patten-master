package com.leetcode.leet127;

import java.util.*;

/**
 * 127. 单词接龙    --mid
 * <p>
 * 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
 * <p>
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典中的单词。
 * 说明:
 * <p>
 * 如果不存在这样的转换序列，返回 0。
 * 所有单词具有相同的长度。
 * 所有单词只由小写字母组成。
 * 字典中不存在重复的单词。
 * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 * 示例 1:
 * <p>
 * 输入:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * <p>
 * 输出: 5
 * <p>
 * 解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * 返回它的长度 5。
 * 示例 2:
 * <p>
 * 输入:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * <p>
 * 输出: 0
 * <p>
 * 解释: endWord "cog" 不在字典中，所以无法进行转换。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-ladder
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    private static Map<String, Integer> worldId = new HashMap<>();
    private static List<List<Integer>> edge = new ArrayList<>();
    private static int nodeNum = 0;

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        for (String word : wordList) {
            addEdge(word);
        }
        addEdge(beginWord);
        if (!worldId.containsKey(endWord)) {
            return 0;
        }
        int[] dis = new int[nodeNum];
        Arrays.fill(dis,  Integer.MAX_VALUE);
        int beginId = worldId.get(beginWord), endId = worldId.get(endWord);
        dis[beginId] = 0;

        Queue<Integer> que = new LinkedList<>();
        que.offer(beginId);
        while (!que.isEmpty()){
            int x = que.poll();
            if (x == endId){
                return dis[endId]/2 + 1;
            }
            for (int it : edge.get(x)) {
                if (dis[it] == Integer.MAX_VALUE){
                    dis[it] = dis[x] + 1;
                    que.offer(it);
                }
            }
        }
        return 0;
    }

    private static void addEdge(String word) {
        addWord(word);
        int id1 = worldId.get(word);
        char[] array = word.toCharArray();
        int length = array.length;
        for(int i=0; i<length; i++){
            char temp = array[i];
            array[i] = '*';
            String newWord = new String(array);
            addWord(newWord);
            int id2 = worldId.get(newWord);
            edge.get(id1).add(id2);
            edge.get(id2).add(id1);
            array[i] = temp;
        }
        
    }

    private static void addWord(String word) {
        if (!worldId.containsKey(word)){
            worldId.put(word, nodeNum++);
            edge.add(new ArrayList<>());
        }
    }

    public static void main(String[] args) {
        String beginWord = "hit", endWord = "cog";
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("lot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("cog");
        wordList.add("log");
        int result = ladderLength(beginWord, endWord, wordList);
        System.out.println(result);
    }
}
