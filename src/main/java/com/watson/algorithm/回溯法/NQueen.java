package com.watson.algorithm.回溯法;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。
 * <p>
 * n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * <p>
 * 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
 * <p>
 * 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 */
public class NQueen {

    public static void main(String[] args) {
        System.out.println(solveNQueens(4));
    }

    static List<List<String>> result = new ArrayList<>();

    public static List<List<String>> solveNQueens(int n) {
        // 标记：每行皇后的位置
        int[] mark = new int[n];
        Arrays.fill(mark, -1);
        List<String> tempResult = new ArrayList<>();
        realSolve(0, mark, tempResult);
        return result;
    }

    private static void realSolve(int i, int[] mark, List<String> tempResult) {
        if (tempResult.size() == mark.length) {
            result.add(new ArrayList<>(tempResult));
            return;
        }

        for (int j = 0; j < mark.length; j++) {
            // 当前位置（i，j）是否可用
            boolean avail = judgeAvail(mark, i, j);
            if (avail) {
                mark[i] = j;
                String tempStr = constructStr(j, mark.length);
                tempResult.add(tempStr);
                // 进入下一层
                realSolve(i + 1, mark, tempResult);
                // 回溯
                tempResult.removeLast();
                mark[i] = -1;
            }
        }

    }

    private static String constructStr(int j, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (i == j) {
                sb.append("Q");
            } else {
                sb.append(".");
            }
        }
        return sb.toString();
    }

    private static boolean judgeAvail(int[] mark, int i, int j) {

        // 同列可否攻击
        boolean colReachable = colReachable(mark, i, j);
        // 斜向有没有可攻击的Q
        boolean diagonalReachable = diagonalReachable(mark, i, j);

        // 存在任意方向的可攻击Q，则不可用
        return !(colReachable || diagonalReachable);

    }

    private static boolean diagonalReachable(int[] mark, int i, int j) {
        int a = 1;
        while(i - a >= 0) {
            if (j - a >= 0 && mark[i - a] == j - a) return true;
            if (j + a < mark.length && mark[i - a] == j + a) return true;
            a ++;
        }
        return false;
    }

    private static boolean colReachable(int[] mark, int i, int j) {
        for (Integer col : mark) {
            if (col == j) {
                return true;
            }
        }
        return false;
    }
}
