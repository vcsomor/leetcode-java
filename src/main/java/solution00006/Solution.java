package solution00006;


import java.util.ArrayList;
import java.util.List;

class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }

        // 1 means up, -1 means down
        int atRow = 0;
        int direction = 1;
        for (char c : s.toCharArray()) {
            rows.get(atRow).append(c);
            if ((atRow + direction) >= numRows) {
                direction = -1;
            } else if ((atRow + direction) < 0) {
                direction = 1;
            }
            atRow += direction;
        }

        StringBuilder sb = new StringBuilder();
        for (StringBuilder row : rows) {
            sb.append(row.toString());
        }
        return sb.toString();
    }
}
