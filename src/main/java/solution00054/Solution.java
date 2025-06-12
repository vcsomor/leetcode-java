package solution00054;


import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int leftWall = 0;
        int rightWall = matrix[0].length - 1;
        int topWall = 0;
        int bottomWall = matrix.length - 1;

        int x = -1, y = 0;
        int direction = 0;
        int xSpeed = 1, ySpeed = 0;
        int steps = matrix.length * matrix[0].length;

        List<Integer> result = new ArrayList<>();
        while (steps > 0) {
            x += xSpeed;
            y += ySpeed;
            result.add(matrix[y][x]);

            switch (direction) {
                case 0: // right
                    if (x >= rightWall) {
                        direction += 1;
                        topWall++;

                        xSpeed = 0; // go down
                        ySpeed = 1;
                    }
                    break;

                case 1: // down
                    if (y >= bottomWall) {
                        direction += 1;
                        rightWall--;

                        xSpeed = -1; // go left
                        ySpeed = 0;
                    }
                    break;

                case 2: // left
                    if (x <= leftWall) {
                        direction += 1;
                        bottomWall--;

                        xSpeed = 0; // go up
                        ySpeed = -1;
                    }
                    break;

                case 3: // up
                    if (y <= topWall) {
                        direction = 0;
                        leftWall++;

                        xSpeed = 1; // go right
                        ySpeed = 0;
                    }
                    break;
            }
            steps--;
        }

        return result;
    }
}
