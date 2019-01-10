package com.ezreal.algo.search;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * 深度优先搜索算法，解决类华容道问题。
 * 判断如下数据结构
 * 3 4 1
 * 5 6 0
 * 8 2 7
 * 能否通过移动，变成
 * 1 2 3
 * 4 5 6
 * 7 8 0
 * 若可以，打印出走的步骤
 */
public class DeepSearch {
    // 定义方向
    private static final int LEFT = 1;
    private static final int RIGHT = 2;
    private static final int UP = 3;
    private static final int DOWN = 4;

    // 3x3的九宫格
    private int[][] arr;

    // 记录空格的位置
    private int x;
    private int y;

    // 定义移动的数组
    private List<Integer> moveArr = new LinkedList<>();

    // 定义终点状态
    private static final Integer WIN_STATE = 123456780;

    // 保存已经搜索过的状态
    private Set<Integer> statusSet = new HashSet<>();

    // 初始化，数字0代表空格，先遍历，找出空格的位置
    public DeepSearch(int[][] arr) {
        this.arr = arr;
        for(int i=0; i<arr.length; i++) {
            for(int j=0; j<arr.length; j++) {
                if(arr[i][j] == 0) {
                    x = i;
                    y = j;
                }
            }
        }
    }

    // 判断是否可以朝某个方向进行移动
    private boolean canMove(int direction) {
        switch (direction) {
            // y > 0才能左移
            case LEFT:
                return y > 0;
            // y < 2才能右移
            case RIGHT:
                return y < 2;
            // x > 0才能上移
            case UP:
                return x > 0;
            // x < 2才能下移
            case DOWN:
                return x < 2;
        }
        return false;
    }

    // 朝某个方向进行移动，该函数不作判断，直接移动
    // 调用前请自行用canMove先行判断
    private void move(int direction) {
        int temp;
        switch (direction) {
            // 空格和左侧数字交换
            case LEFT:
                temp = arr[x][y - 1];
                arr[x][y - 1] = 0;
                arr[x][y] = temp;
                y = y - 1;
                break;
            // 空格和右侧数字交换
            case RIGHT:
                temp = arr[x][y + 1];
                arr[x][y + 1] = 0;
                arr[x][y] = temp;
                y = y + 1;
                break;
            // 空格和上方数字交换
            case UP:
                temp = arr[x - 1][y];
                arr[x - 1][y] = 0;
                arr[x][y] = temp;
                x = x - 1;
                break;
            // 空格和下方数字交换
            case DOWN:
                temp = arr[x + 1][y];
                arr[x + 1][y] = 0;
                arr[x][y] = temp;
                x = x + 1;
                break;
        }
        // 该方向记录
        moveArr.add(direction);
    }

    // 某个方向的回退，该函数不作判断，直接移动
    // 其操作和move方法正好相反
    private void moveBack(int direction) {
        int temp;
        switch (direction) {
            // 空格和左侧数字交换
            case LEFT:
                temp = arr[x][y + 1];
                arr[x][y + 1] = 0;
                arr[x][y] = temp;
                y = y + 1;
                break;
            // 空格和右侧数字交换
            case RIGHT:
                temp = arr[x][y - 1];
                arr[x][y - 1] = 0;
                arr[x][y] = temp;
                y = y - 1;
                break;
            // 空格和上方数字交换
            case UP:
                temp = arr[x + 1][y];
                arr[x + 1][y] = 0;
                arr[x][y] = temp;
                x = x + 1;
                break;
            // 空格和下方数字交换
            case DOWN:
                temp = arr[x - 1][y];
                arr[x - 1][y] = 0;
                arr[x][y] = temp;
                x = x - 1;
                break;
        }
        // 记录的移动步骤出栈
        moveArr.remove(moveArr.size() - 1);
    }


    // 获取状态，这里把9个数字按顺序组成一个整数来代表状态
    // 方法不唯一，只要能区分九宫格状态就行
    private Integer getStatus() {
        int status = 0;
        for (int[] anArr : arr) {
            for (int j = 0; j < arr.length; j++) {
                status = status * 10 + anArr[j];
            }
        }
        return status;
    }

    // 搜索方法
    private boolean search(int direction) {
        // 如果能够朝该方向行走,且当前步数少于100
        if(canMove(direction) && moveArr.size() < 100) {
            // 往该方向移动
            move(direction);
            // 移动后的状态
            Integer status = getStatus();
            // 如果已经是胜利状态，返回true
            if(WIN_STATE.equals(status)) {
                return true;
            }
            // 如果是之前走过的状态了，返回false
            if(statusSet.contains(status)) {
                // 这一步走错了，回退
                moveBack(direction);
                return false;
            }
            // 将当前状态存入set
            statusSet.add(status);
            // 继续朝四个方向进行搜索
            boolean searchFourOk = search(RIGHT) || search(DOWN) || search(LEFT) || search(UP);
            if(searchFourOk) {
                return true;
            } else {
                // 这一步走错了，把它的记录去除
                moveBack(direction);
                return false;
            }
        }
        return false;
    }

    // 解题入口方法
    public boolean solve() {
        Integer status = getStatus();
        // 如果已经是胜利状态，返回true
        if(WIN_STATE.equals(status)) {
            return true;
        }
        // 初始状态先记录
        statusSet.add(status);
        // 朝4个方向进行搜索
        return search(RIGHT) || search(DOWN) || search(LEFT) || search(UP);
    }

    // 打印路径
    public void printRoute() {
        for (Integer aMoveArr : moveArr) {
            System.out.print(getDirString(aMoveArr));
            System.out.print(" ");
        }
    }

    public int getStep(){
        return moveArr == null ? 0 : moveArr.size();
    }

    // 方向与其对应的字符串
    private String getDirString(int dir) {
        switch (dir) {
            case LEFT:
                return "左";
            case RIGHT:
                return "右";
            case UP:
                return "上";
            case DOWN:
                return "下";
        }
        return null;
    }

    // 打印当前华容道的状态
    public void print() {
        for (int[] anArr : arr) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(anArr[j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
