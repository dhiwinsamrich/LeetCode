
public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();

        if (s.length() == 0 || words.length == 0)
            return result;

        int wordLength = words[0].length(); // length of each word in the words array
        int totalWords = words.length; // total number of words in the words array
        int substringLength = wordLength * totalWords; // length of the concatenated substring

        if (s.length() < substringLength)
            return result;

        Map<String, Integer> wordCount = new HashMap<>();

        // count the occurrences of each word in the words array
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        // sliding window approach
        for (int i = 0; i < wordLength; i++) {
            Map<String, Integer> currentWordCount = new HashMap<>(); // track counts of words in the current window
            int wordsFound = 0; // total number of words found in the current window
            int left = i; // left index of the sliding window

            // move the window one word length at a time
            for (int j = i; j <= s.length() - wordLength; j += wordLength) {
                String currentWord = s.substring(j, j + wordLength);

                // if the current word is in the wordCount map, update the counts
                if (wordCount.containsKey(currentWord)) {
                    currentWordCount.put(currentWord, currentWordCount.getOrDefault(currentWord, 0) + 1);
                    wordsFound++;

                    // adjust the left index of the window if any word count exceeds the required count
                    while (currentWordCount.get(currentWord) > wordCount.get(currentWord)) {
                        String leftWord = s.substring(left, left + wordLength);
                        currentWordCount.put(leftWord, currentWordCount.get(leftWord) - 1);
                        wordsFound--;
                        left += wordLength;
                    }

                    // if all words are found, add the left index to the result
                    if (wordsFound == totalWords) {
                        result.add(left);
                        String leftWord = s.substring(left, left + wordLength);
                        currentWordCount.put(leftWord, currentWordCount.get(leftWord) - 1);
                        wordsFound--;
                        left += wordLength;
                    }
                }
                // if the current word is not in the wordCount map, reset the counts and move the left index
                else {
                    currentWordCount.clear();
                    wordsFound = 0;
                    left = j + wordLength;
                }
            }
        }

        return result;
    }
}