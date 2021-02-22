import java.util.*;

public class FrequencyAnalyzer {
    private int numberOfThreads;
    private  int numberOfQueries;
    private final List<String> words;
    private static final List<String> answer = new ArrayList<>();

    public FrequencyAnalyzer(int numberOfThreads, int numberOfQueries, List<String> words) {
        this.numberOfThreads = numberOfThreads;
        this.numberOfQueries = numberOfQueries;
        this.words = words;
    }

    public List<String> getFrequentStringsWithThreads() {

        if(numberOfThreads> words.size()){
            numberOfThreads=words.size();
        }
        final long startTime = System.nanoTime();

        for (int i = 0; i < numberOfThreads; i++) {
            FrequencyThread thread = new FrequencyThread();
            thread.setArray(words);
            thread.setThreadNumber(i);
            thread.start();
        }
        final long time = System.nanoTime() - startTime;
        System.out.println("time to execute whole code: " + time);
        return getResult();

    }

    public List<String> getFrequentStringsWithStreamAPI() {
        //STREAM API
        final long startTime = System.nanoTime();
        words.stream()
                .parallel()
                .forEach(FrequencyString::increaseCounter);
        final long time = System.nanoTime() - startTime;
        System.out.println("time to execute whole code: " + time);
        return getResult();
    }

    private List<String> getResult() {
        if(numberOfQueries> FrequencyString.FrequencyMap.keySet().size()){
            numberOfQueries = FrequencyString.FrequencyMap.keySet().size();
        }
        List<String> result=new ArrayList<>();
        FrequencyString.FrequencyMap.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEach(stringIntegerEntry -> getAnswer(stringIntegerEntry.getKey()));
        for (int i=0;i<numberOfQueries;i++){
            result.add(answer.get(i));
        }

        return result;
    }

    private static void getAnswer(String string) {
        answer.add(string);
    }
}
