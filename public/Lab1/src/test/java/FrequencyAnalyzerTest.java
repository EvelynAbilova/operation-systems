import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FrequencyAnalyzerTest {
    final long startTime = System.nanoTime();
    @Test
    public void getFrequencyWithThreads() {
        List<String> expected = new ArrayList<>();
        List<String> words = new ArrayList<>();

        expected.add("The");
        expected.add("not");
        expected.add("Are");

        words.add("The");
        words.add("The");
        words.add("The");
        words.add("The");
        words.add("not");
        words.add("not");
        words.add("not");
        words.add("Are");
        words.add("Are");
        words.add("wow");

        FrequencyAnalyzer analyzer = new FrequencyAnalyzer(3, 3, words);
        Collections.sort(expected);
        List<String> actual=analyzer.getFrequentStringsWithThreads();
        final long time = System.nanoTime() - startTime;
        System.out.println("time to execute whole code: " + time);
        Collections.sort(actual);
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void getFrequencyWithStreamAPI(){
        List<String> expected = new ArrayList<>();
        List<String> words = new ArrayList<>();

        expected.add("The");
        expected.add("not");
        expected.add("Are");

        words.add("The");
        words.add("The");
        words.add("The");
        words.add("The");
        words.add("not");
        words.add("not");
        words.add("not");
        words.add("Are");
        words.add("Are");
        words.add("wow");

        FrequencyAnalyzer analyzer = new FrequencyAnalyzer(3, 3, words);
        Collections.sort(expected);
        List<String> actual=analyzer.getFrequentStringsWithStreamAPI();
        final long time = System.nanoTime() - startTime;
        System.out.println("time to execute whole code: " + time);
        Collections.sort(actual);
        Assert.assertEquals(expected,actual );
    }
}
