import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author David Kostov (david.kostov.cw@gmail.com)
 */
public class WordHandler {

    public Map<String, Integer> wordsQuantity(String sentence){

        String[] words = sentence.split(" ");
        Map<String, Integer> map = new TreeMap<>();

        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        return map;

    }

    public String mostFrequentChar(String sentence){

        sentence = sentence.replace(" ", "");
        Map<Character, Integer> map = new TreeMap<>();

        for(int i = 0; i < sentence.length(); i++) {
            map.put(sentence.charAt(i), map.getOrDefault(sentence.charAt(i), 0) + 1);
        }

        Map.Entry<Character,Integer> maxEntry = null;
        for(Map.Entry<Character,Integer> entry : map.entrySet()) {
            if (maxEntry == null || entry.getValue() > maxEntry.getValue()) {
                maxEntry = entry;
            }
        }

        return maxEntry.getKey().toString();

    }

}
