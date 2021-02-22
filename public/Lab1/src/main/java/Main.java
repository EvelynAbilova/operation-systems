
public class Main {
    public static void main(String[] args) {
//        FrequencyAnalyzer apiAnalyzer = new FrequencyAnalyzer(50,
//                1000, RandomString.getRandomString(99999));
//        for (String str : apiAnalyzer.getFrequentStringsWithStreamAPI()) {
//            System.out.println(str);
//        }

        FrequencyAnalyzer threadAnalyzer = new FrequencyAnalyzer(50,
                1000, RandomString.getRandomString(999));
//        for (String str : threadAnalyzer.getFrequentStringsWithThreads()) {
//            System.out.println(str);
//        }
    }
}