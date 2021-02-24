
public class Main {
    public static void main(String[] args) {

        FrequencyAnalyzer apiAnalyzer = new FrequencyAnalyzer(2,
                3, RandomString.getRandomString(5));
        for (String apiStr : apiAnalyzer.getFrequentStringsWithStreamAPI()) {
            System.out.println(apiStr);
        }

        FrequencyAnalyzer threadAnalyzer = new FrequencyAnalyzer(2,
                3, RandomString.getRandomString(5));
        for (String threadStr : threadAnalyzer.getFrequentStringsWithThreads()) {
            System.out.println(threadStr);
        }
    }
}

