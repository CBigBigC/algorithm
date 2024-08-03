package com.watson.algorithm.双指针;

import java.util.HashMap;
import java.util.Map;

public class MinWindow {
    public static void main(String[] args) {
        String s = "hello";
        String t = "ooolleoooleh";
        boolean result = checkInclusion(s, t);
        System.out.printf(Boolean.toString(result));

    }

    public static boolean checkInclusion(String s1, String s2) {

        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> possess = new HashMap<>();

        // 需要的每个字符的个数
        for(Character c : s1.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0, match = 0;

        while(right < s2.length()) {
            char newChar = s2.charAt(right);
            // 特殊：如果目标串不包含当前字符，需要重置两个指针
            if(!need.containsKey(newChar)) {
                possess.clear();
                match = 0;
                right ++;
                left = right;
                continue;
            }
            // 否则，更新possess
            possess.put(newChar, possess.getOrDefault(newChar, 0) + 1);
            // 相等，增加match
            if(possess.get(newChar).compareTo(need.get(newChar)) == 0) {
                match ++;
                if(match == need.size()) return true;
                right ++;
                continue;
            }else if (possess.get(newChar).compareTo(need.get(newChar)) < 0) {
                right ++;
                continue;
            } else {
                match --;
            }
            while(right > left) {
                char oldChar = s2.charAt(left);
                // 更新possess
                possess.put(oldChar, possess.getOrDefault(oldChar, 0) - 1);
                if(possess.get(oldChar).compareTo(need.get(oldChar)) == 0) {
                    match ++;
                    if(match == need.size()) return true;
                }
                left ++;
            }
            right ++;
        }
        return false;
    }

    public static String minWindow(String s, String t) {

        // 每个字符需要出现多少次
        Map<Character, Integer> need = new HashMap<>();
        for (int i = 0; i < t.length(); i ++) {
            char temp = t.charAt(i);
            need.put(temp, need.getOrDefault(temp, 0) + 1);
        }

        // 窗口中字符出现次数
        Map<Character, Integer> window = new HashMap<>();
        // 当前满足了多少个字符
        int match = 0;
        // 快慢指针圈定窗口
        int left = 0, right = 0;

        String result = "";
        int minLen = Integer.MAX_VALUE;

        while(right < s.length()) {
            // 扩展窗口，将新字符放入窗口并更新出现次数
            char newChar = s.charAt(right);
            window.put(newChar, window.getOrDefault(newChar, 0) + 1);
            // 判断当前字符数量是否全部满足
            if (window.get(newChar).equals(need.get(newChar))) {
                match ++;
            }
            right ++;
            // 仍有字符未满足，继续移动右指针，纳入更多字符
            if (match < need.size()) {
                continue;
            }
            // 已经全部满足，缩小窗口，移动左指针，移除字符
            while(left < right && match == need.size()) {
                // 此时已经满足包含所有目标字符，先更新当前最短子串
                if (minLen > right - left) {
                    minLen =  right - left;
                    result = s.substring(left, right);
                }
                // 移出左指针对应的字符
                char head = s.charAt(left);
                window.put(head, window.getOrDefault(head, 0) - 1);
                // 移除字符后，不再满足个数，match减一
                if (window.get(head).compareTo(need.getOrDefault(head, 0)) < 0) {
                    match --;
                }
                left ++;
            }
        }
        return  result;
    }

}

