package solution00068;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int line = 0;
        List<List<String>> lines = new ArrayList<>();

        int wIdx = 0;
        while (wIdx < words.length) {
            if (lines.size() == line) {
                lines.add(new ArrayList<>());
            }

            var word = words[wIdx];
            var currLine = lines.get(line);
            var currLineLen = lineLength(currLine);
            if ((currLineLen + word.length()) <= maxWidth) {
                currLine.add(word);
                wIdx++;
            } else {
                line++;
            }
        }
        return justifyLines(lines, maxWidth).
                stream().
                map(l -> String.join(" ", l)).
                collect(Collectors.toList());
    }

    private List<List<String>> justifyLines(List<List<String>> lines, int maxWidth) {
        List<List<String>> result = new ArrayList<>(lines.size());
        for (int i = 0; i < lines.size(); i++) {
            var line = lines.get(i);
            if ((line.size() == 1) || (i == (lines.size() - 1))) {
                result.add(paddingRight(lines.get(i), maxWidth));
                continue;
            }
            result.add(justifyWords(lines.get(i), maxWidth));
        }
        return result;
    }

    private static List<String> justifyWords(List<String> line, int maxWidth) {
        var lineLen = lineLength(line);
        var spaces = maxWidth - (lineLen - 1); // remove last space

        var idx = 0;
        var maxIdx = line.size() - 1;
        while (spaces > 0) {
            line.set(idx, line.get(idx) + " ");
            idx = ((idx + 1) % maxIdx);
            spaces--;
        }
        return line;
    }

    private static List<String> paddingRight(List<String> line, int width) {
        var idx = line.size() - 1;
        var str = line.get(idx);
        var padding = width;
        for (int i = 0; i < line.size() - 1; i++) {
            padding -= line.get(i).length() + 1;
        }
        line.set(idx, padRight(str, padding));
        return line;
    }

    private static String padRight(String str, int width) {
        return String.format("%-" + width + "s", str);
    }

    private static int lineLength(List<String> line) {
        if (line.isEmpty()) {
            return 0;
        }

        int l = 0;
        for (String word : line) {
            l += word.length();
            l++; // add space
        }
        return l;
    }
}
