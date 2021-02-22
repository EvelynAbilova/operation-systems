import java.util.HashMap;
import java.util.Map;

public class FrequencyString {
    public static Map<String, Integer> FrequencyMap = new HashMap<>();

    public static synchronized void increaseCounter(String currentString) {
        if (FrequencyMap.containsValue(currentString)) {
            FrequencyMap.put(currentString, FrequencyMap.get(currentString) + 1);
        } else {
            FrequencyMap.put(currentString, 1);
        }
    }
}