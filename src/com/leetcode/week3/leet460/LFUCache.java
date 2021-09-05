package com.leetcode.week3.leet460;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

/**
 * @Author tang
 * @Date 2021/9/4 10:17
 */
// 460.LFU缓存机制（困难）
public class LFUCache {
    // key 到 val 的映射
    Map<Integer, Integer> keyToVal;
    // key 到 freq 的映射
    Map<Integer, Integer> keyToFreq;
    // freq 到 key 列表的映射，一对多
    Map<Integer, LinkedHashSet<Integer>> freqToKeys;
    // 记录最小的频次
    int minFreq;
    // 记录 LFU 缓存容量大小
    int cap;

    public LFUCache(int capacity) {
        // 初始化
        this.keyToVal = new HashMap<>();
        this.keyToFreq = new HashMap<>();
        this.freqToKeys = new HashMap<>();
        this.minFreq = 0;
        this.cap = capacity;
    }

    public int get(int key) {
        if (!keyToVal.containsKey(key)) {
            return -1;
        }
        // 增加 key 对应的 freq
        increaseFreq(key);
        return keyToVal.get(key);
    }

    public void put(int key, int value) {
        if (this.cap <= 0) return;
        // key已经存在，则直接修改value值，并增加key对应的freq
        if (keyToVal.containsKey(key)) {
            keyToVal.put(key, value);
            increaseFreq(key);
            return;
        }
        // key 不存在，需要插入，插入之前需要判断容量是否已满，满了则需要删除freq最小的key
        if (this.cap <= keyToVal.size()) {
            removeMinFreqKey();
        }
        // 插入key 和 value，对应的freq=1
        keyToVal.put(key, value);
        keyToFreq.put(key, 1);
        freqToKeys.putIfAbsent(1, new LinkedHashSet<>());
        freqToKeys.get(1).add(key);
        // 插入新 key 后，minFreq肯定是1
        this.minFreq = 1;
    }

    private void increaseFreq(int key) {
        int freq = keyToFreq.get(key);
        // 更新 KF 表
        keyToFreq.put(key, freq + 1);
        // 更新 FK 表
        // 先将 key 从 freq 对应的列表删除
        freqToKeys.get(freq).remove(key);
        // 将 key 加入 freq+1 对应的列表
        freqToKeys.putIfAbsent(freq+1, new LinkedHashSet<>());
        freqToKeys.get(freq + 1).add(key);

        // 如果 freq 对应的列表空了，需要删除这个freq
        if (freqToKeys.get(freq).isEmpty()) {
            freqToKeys.remove(freq);
            // 如果这个 freq 正好是 minFreq，更新 minFreq
            if (freq == minFreq) {
                this.minFreq++;
            }
        }
    }

    private void removeMinFreqKey() {
        // freq 中最小的 key 列表
        LinkedHashSet<Integer> keyList = freqToKeys.get(this.minFreq);
        // 其中最先被插入进去的那个 key 就应该是需要被淘汰的 key
        int deletedKey = keyList.iterator().next();
        // 更新 FK 表
        keyList.remove(deletedKey);
        if (keyList.isEmpty()) {
            freqToKeys.remove(this.minFreq);
        }
        // 更新 KV 表
        keyToVal.remove(deletedKey);
        // 更新 KF 表
        keyToFreq.remove(deletedKey);
    }
}
