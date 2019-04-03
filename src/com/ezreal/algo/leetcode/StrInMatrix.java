package com.ezreal.algo.leetcode;

public class StrInMatrix {
    // 采用穷举回溯法
    public static boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        // 输入合法性判断
        if (matrix == null || str == null || rows < 1 || cols < 1) {
            return false;
        }
        // 使用一个同样大小的数组用于记录访问过的路径
        boolean[] visited = new boolean[rows * cols];
        // 从矩阵的每一个位置出发，逐个位置检索
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (realCheck(matrix, rows, cols, str, i, j, 0, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    // 参数分别是，原参数集， 当前行列，当前查找到的字符串的步长，已经访问过的字符
    private static boolean realCheck(char[] matrix, int rows, int cols, char[] str, int row, int col,
                              int pathLength, boolean[] visited) {
        // 已经搜索到的了
        if (pathLength == str.length) {
            return true;
        }
        boolean hasPath = false;
        // 选取下一个位置,首先不能越界，其次是未访问过的，且要和目标字符串对应位置的的字符相等
        if (row >= 0 && row < rows && col >= 0 && col < cols
                && matrix[row * cols + col] == str[pathLength]
                && !visited[row * cols + col]) {
            // 找到下一个位置，步长+1，且标记位置被访问过了
            ++pathLength;
            visited[row * cols + col] = true;

            // 递归访问下一个位置,上下左右各检查
            hasPath = realCheck(matrix, rows, cols, str, row - 1, col, pathLength, visited)
                    || realCheck(matrix, rows, cols, str, row + 1, col, pathLength, visited)
                    || realCheck(matrix, rows, cols, str, row, col - 1, pathLength, visited)
                    || realCheck(matrix, rows, cols, str, row, col + 1, pathLength, visited);

            // 如果此条路线找不到，则回溯一步
            if (!hasPath) {
                --pathLength;
                visited[row * cols + col] = false;
            }
        }
        return hasPath;
    }
}
