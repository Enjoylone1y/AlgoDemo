package com.ezreal.algo.leetcode;

public class RobotMoveCount {
    public static int movingCount(int threshold, int rows, int cols) {
        // 输入验证
        if (threshold < 0 || rows < 1 || cols < 1) {
            return 0;
        }
        // 创建访问过的格子，因为不能重复计算
        boolean[] visited = new boolean[rows * cols];
        return reMoveCount(threshold, rows, cols, 0, 0, visited);
    }

    private static int reMoveCount(int threshold, int rows, int cols, int row, int col,
                            boolean[] visited) {
        int count = 0;
        // 不越界且未被访问过
        if (row >= 0 && row < rows && col >= 0 && col < cols
                && !visited[row * cols + col]) {
            // 计算行和列的数值之和
            int k = numCount(row) + numCount(col);
            if (k <= threshold) {
                // 记录当前位置被访问过了
                visited[row * cols + col] = true;
                // 当前位置加上从该位置出发去其他方向的所有数目总和
                count = 1 + reMoveCount(threshold, rows, cols, row + 1, col, visited)
                        + reMoveCount(threshold, rows, cols, row - 1, col, visited)
                        + reMoveCount(threshold, rows, cols, row, col + 1, visited)
                        + reMoveCount(threshold, rows, cols, row, col - 1, visited);
            }

        }
        return count;
    }

    private static int numCount(int num) {
        int count = 0;
        while (num > 0) {
            count += num % 10;
            num /= 10;
        }
        return count;
    }
}
