package solution00036;


class Solution {
    public boolean isValidSudoku(char[][] board) {
        // check rows
        for (int idx = 0; idx < 9; idx++) {
            if (!isValid(toRow(board, idx))) {
                return false;
            }
        }

        // check cols
        for (int col = 0; col < 9; col++) {
            if (!isValid(toColumn(board, col))) {
                return false;
            }
        }

        // check 3x3 sections
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (!isValid(to3x3board(board, row, col))) {
                    return false;
                }
            }
        }

        return true;
    }

    static boolean isValid(char[] data) {
        int flags = 0x0;
        for (char ch : data) {
            if (ch == '.') {
                continue;
            }

            byte shift = (byte) (ch - '0');
            if ((flags & (1 << shift)) != 0x0) {
                return false;
            }
            flags |= 1 << shift;
        }
        return true;
    }

    static char[] toRow(char[][] board, int row) {
        return board[row];
    }

    static char[] toColumn(char[][] board, int col) {
        char[] column = new char[9];
        for (int i = 0; i < 9; i++) {
            column[i] = board[i][col];
        }
        return column;
    }

    static char[] to3x3board(char[][] board, int row, int col) {
        char[] b = new char[9];

        int baseRow = row * 3;
        int baseCol = col * 3;
        int i = 0;
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                b[i] = board[baseRow + r][baseCol + c];
                i++;
            }
        }
        return b;
    }
}
