package solution00006;


class Solution {
    enum Mode {
        DOWN(0, 1),

        CROSS(1, -1);

        final int x, y;

        Mode(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        var len = s.length();
        var stride = numRows + numRows - 2;
        var nStrides = len / stride;
        if (len % stride != 0) {
            nStrides++;
        }
        var width = 1 + (stride - numRows);
        var col = nStrides * width;
        var matrix = new char[numRows][col];

        Mode mode = Mode.DOWN;
        int x = 0, y = 0;

        for (var c : s.toCharArray()) {
            matrix[y][x] = c;
            if ((y + mode.y) >= numRows) {
                mode = Mode.CROSS;
            } else if ((y + mode.y) < 0) {
                mode = Mode.DOWN;
            }
            x += mode.x;
            y += mode.y;
        }

        StringBuilder sb = new StringBuilder();
        for (var row : matrix) {
            for (var c : row) {
                if (c == 0) {
                    continue;
                }
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
