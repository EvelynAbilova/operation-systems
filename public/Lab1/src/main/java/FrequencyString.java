import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class FrequencyString {
    public static ConcurrentMap<String, Integer> FrequencyMap = new ConcurrentHashMap<>();

    public static void increaseCounter(String currentString) {
        if (FrequencyMap.containsValue(currentString)) {
            FrequencyMap.put(currentString, FrequencyMap.get(currentString) + 1);
        } else {
            FrequencyMap.put(currentString, 1);
        }
    }
}