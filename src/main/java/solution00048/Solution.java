package solution00048;


class Solution {
    public void rotate(int[][] matrix) {
        int size = matrix.length;
        int[] buf = new int[(size - 1) * 4];
        int startXY = 0;
        while (size > 1) {
            readToBuf(matrix, buf, startXY, size);
            writeRot(matrix, buf, startXY, size);
            startXY += 1;
            size -= 2;
        }
    }

    private void writeRot(int[][] matrix, int[] buf, int startXY, int size) {
        int stride = (size - 1);
        int bufPtrMax = stride * 4;
        int bufPtr = stride * 3; // rotate 90 degrees
        int iterMax = size - 1;

        // write first row
        int firsRow = startXY + 0;
        for (int i = 0; i < iterMax; i++) {
            matrix[firsRow][startXY + i] = buf[bufPtr];
            bufPtr = (bufPtr + 1) % bufPtrMax;
        }

        // read last col
        int lastCol = startXY + (size - 1);
        for (int i = 0; i < iterMax; i++) {
            matrix[startXY + i][lastCol] = buf[bufPtr];
            bufPtr = (bufPtr + 1) % bufPtrMax;
        }

        // write last row - reverse
        int lastRow = startXY + (size - 1);
        for (int i = iterMax; i > 0; i--) {
            matrix[lastRow][startXY + i] = buf[bufPtr];
            bufPtr = (bufPtr + 1) % bufPtrMax;
        }

        // write first col - reverse
        int firstCol = startXY + 0;
        for (int i = iterMax; i > 0; i--) {
            matrix[startXY + i][firstCol] = buf[bufPtr];
            bufPtr = (bufPtr + 1) % bufPtrMax;
        }
    }

    static void readToBuf(int[][] matrix, int[] buf, int startXY, int size) {
        int bufPtr = 0;

        int iterMax = size - 1;

        // read first row
        int firsRow = startXY + 0;
        for (int i = 0; i < iterMax; i++) {
            buf[bufPtr++] = matrix[firsRow][startXY + i];
        }

        // read last col
        int lastCol = startXY + (size - 1);
        for (int i = 0; i < iterMax; i++) {
            buf[bufPtr++] = matrix[startXY + i][lastCol];
        }

        // read last row - reverse
        int lastRow = startXY + (size - 1);
        for (int i = iterMax; i > 0; i--) {
            buf[bufPtr++] = matrix[lastRow][startXY + i];
        }

        // read first col - reverse
        int firstCol = startXY + 0;
        for (int i = iterMax; i > 0; i--) {
            buf[bufPtr++] = matrix[startXY + i][firstCol];
        }
    }
}
