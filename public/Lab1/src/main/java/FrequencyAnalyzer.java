import java.util.*;

public class FrequencyAnalyzer {
    private int numberOfThreads;
    private int numberOfQueries;
    private final List<String> words;
    private static final List<String> answer = new ArrayList<>();

    public FrequencyAnalyzer(int numberOfThreads, int numberOfQueries, List<String> words) {
        this.numberOfThreads = numberOfThreads;
        this.numberOfQueries = numberOfQueries;
        this.words = words;
    }

    public List<String> getFrequentStringsWithThreads() {

        if (numberOfThreads > words.size()) {
            numberOfThreads = words.size();
        }
        List<FrequencyThread> threads = new ArrayList<>();
        for (int i = 0; i < numberOfThreads; i++) {
            FrequencyThread thread = new FrequencyThread();
            thread.setArray(words);
            thread.setThreadNumber(i);
            threads.add(thread);
            thread.start();
        }
        for (FrequencyThread thread : threads
        ) {
            thread.interrupt();
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        return getResult();

    }

    public List<String> getFrequentStringsWithStreamAPI() {
        //STREAM API
        words.stream()
                .parallel()
                .forEach(FrequencyString::increaseCounter);
        return getResult();

    }

    private List<String> getResult() {
        if (numberOfQueries > FrequencyString.FrequencyMap.keySet().size()) {
            numberOfQueries = FrequencyString.FrequencyMap.keySet().size();
        }
        FrequencyString.FrequencyMap.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEach(stringIntegerEntry -> getAnswer(stringIntegerEntry.getKey()));

        return answer.subList(0, numberOfQueries);
    }

    private static void getAnswer(String string) {
        answer.add(string);
    }
}
