package solution00030;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        // length of a single word
        int wordLen = words[0].length();
        // number of words
        int nWords = words.length;
        // substring length
        int ssLen = wordLen * nWords;

        // initialize a reference
        var wordsRef = Arrays.stream(words)
                .collect(Collectors.groupingBy(
                        w -> w,
                        HashMap::new,
                        Collectors.summingInt(w -> 1)
                ));
        List<Integer> result = new ArrayList<>();

        int i = 0;

        while (i < s.length()) {
            int from = i;
            int to = i + ssLen;
            if (to > s.length()) {
                break;
            }

            int n = consecutiveContainsWoRepetition(s.substring(from, to),
                    new HashMap<>(wordsRef),
                    nWords,
                    wordLen);

            if (n == nWords) {
                result.add(from);
            }

            i++;
        }

        return result;
    }

    private int consecutiveContainsWoRepetition(String s, HashMap<String, Integer> words, int nWords, int wordLen) {
        int found = 0;
        int pos = 0;
        while (nWords > 0) {
            String w = s.substring(pos, pos + wordLen);

            var occur = words.get(w);
            if (occur != null && occur > 0) {
                words.put(w, occur - 1);
                ++found;
            } else {
                break;
            }

            --nWords;
            pos = pos + wordLen;
        }

        return found;
    }
}
