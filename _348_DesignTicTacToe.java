package leetcode_1To300;

/**
 * 本代码来自 Cspiration，由 @Cspiration 提供
 * 题目来源：http://leetcode.com
 * - Cspiration 致力于在 CS 领域内帮助中国人找到工作，让更多海外国人受益
 * - 现有课程：Leetcode Java 版本视频讲解（1-900题）（上）（中）（下）三部
 * - 算法基础知识（上）（下）两部；题型技巧讲解（上）（下）两部
 * - 节省刷题时间，效率提高2-3倍，初学者轻松一天10题，入门者轻松一天20题
 * - 讲师：Edward Shi
 * - 官方网站：https://cspiration.com
 * - 版权所有，转发请注明出处
 */
public class _348_DesignTicTacToe {
    /**
     * 348. Design Tic-Tac-Toe
     * Given n = 3, assume that player 1 is "X" and player 2 is "O" in the board.

     TicTacToe toe = new TicTacToe(3);

     toe.move(0, 0, 1); -> Returns 0 (no one wins)
     |X| | |
     | | | |    // Player 1 makes a move at (0, 0).
     | | | |

     toe.move(0, 2, 2); -> Returns 0 (no one wins)
     |X| |O|
     | | | |    // Player 2 makes a move at (0, 2).
     | | | |

     toe.move(2, 2, 1); -> Returns 0 (no one wins)
     |X| |O|
     | | | |    // Player 1 makes a move at (2, 2).
     | | |X|

     toe.move(1, 1, 2); -> Returns 0 (no one wins)
     |X| |O|
     | |O| |    // Player 2 makes a move at (1, 1).
     | | |X|

     toe.move(2, 0, 1); -> Returns 0 (no one wins)
     |X| |O|
     | |O| |    // Player 1 makes a move at (2, 0).
     |X| |X|

     toe.move(1, 0, 2); -> Returns 0 (no one wins)
     |X| |O|
     |O|O| |    // Player 2 makes a move at (1, 0).
     |X| |X|

     toe.move(2, 1, 1); -> Returns 1 (player 1 wins)
     |X| |O|
     |O|O| |    // Player 1 makes a move at (2, 1).
     |X|X|X|


     cols[1,-2,3]

     * @param n
     */

    private int[] rows;
    private int[] cols;
    private int diagonal;
    private int antiDiagonal;
    private int size;

    public _348_DesignTicTacToe(int n) {
        rows = new int[n];
        cols = new int[n];
        this.size = n;
    }

    //time : O(1)
    public int move(int row, int col, int player) {
        int toAdd = player == 1 ? 1 : -1;

        rows[row] += toAdd;
        cols[col] += toAdd;
        if (row == col) {
            diagonal += toAdd;
        }
        if (col == (cols.length - row - 1)) {
            antiDiagonal += toAdd;
        }
        if (Math.abs(rows[row]) == size || Math.abs(cols[col]) == size
                || Math.abs(diagonal) == size || Math.abs(antiDiagonal) == size) {
            return player;
        }
        return 0;
    }
}
