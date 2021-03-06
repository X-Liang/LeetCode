package Basic;

import Tree.LeetCode.LeetCode298;

/**
 * 根据 百度百科 ，生命游戏，简称为生命，是英国数学家约翰·何顿·康威在 1970 年发明的细胞自动机。
 *
 * 给定一个包含 m × n 个格子的面板，每一个格子都可以看成是一个细胞。
 * 每个细胞都具有一个初始状态：1 即为活细胞（live），或 0 即为死细胞（dead）。
 * 每个细胞与其八个相邻位置（水平，垂直，对角线）的细胞都遵循以下四条生存定律：
 *
 * 如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
 * 如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
 * 如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
 * 如果死细胞周围正好有三个活细胞，则该位置死细胞复活；
 * 根据当前状态，写一个函数来计算面板上所有细胞的下一个（一次更新后的）状态。
 * 下一个状态是通过将上述规则同时应用于当前状态下的每个细胞所形成的，其中细胞的出生和死亡是同时发生的。
 *
 * 输入：
 * [
 *   [0,1,0],
 *   [0,0,1],
 *   [1,1,1],
 *   [0,0,0]
 * ]
 *
 * 输出：
 * [
 *   [0,0,0],
 *   [1,0,1],
 *   [0,1,1],
 *   [0,1,0]
 * ]
 *
 */
public class LeetCode289 {
    private int[][] directions = new int[][] {
            {-1, 0},        // 上
            {-1, -1},       // 左上
            {-1, 1},        // 右上
            {1, 0},         // 下
            {1, -1},        // 左下
            {1, 1},         // 右下
            {0, -1},         // 左
            {0, 1}          // 右

    };
    public void gameOfLife(int[][] board) {
        int[][] originBoard = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                originBoard[i][j] = board[i][j];
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int liveCount = 0;
                for (int[] direction: directions) {
                    int x = i + direction[0];
                    int y = j + direction[1];
                    if (x >= 0 && y >= 0 && x < board.length && y < board[0].length) {
                        if (originBoard[x][y] == 1) {
                            liveCount++;
                        }
                    }
                }
                if (board[i][j] == 0 && liveCount == 3) {
                    board[i][j] = 1;
                    continue;
                }
                if (board[i][j] == 1) {
                    if (liveCount == 2 || liveCount == 3) {
                        continue;
                    } else {
                        board[i][j] = 0;
                    }
                }
            }
        }
        return;
    }

    public static void main(String[] args) {
        LeetCode289 leetCode289 = new LeetCode289();
        leetCode289.gameOfLife(new int[][]{
                {0,1,0},
                {0,0,1},
                {1,1,1},
                {0,0,0}
        });
    }
}
