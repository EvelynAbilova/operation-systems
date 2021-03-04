import java.util.*;

import org.junit.Test;

import java.util.stream.IntStream;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertNull;

public class LFStackTest {
    @Test
    public void pushPopEmptyMethodsTest() throws InterruptedException {

        List<String> stackElements = new ArrayList<>();

        stackElements.add("elem1");
        stackElements.add("elem2");

        LFStack<String> stack = new LFStack<>();

        Thread[] testingThreads = new Thread[5];
        for (int i = 0; i < 5; i++) {
            final int index = i;
            testingThreads[i] = new Thread(() -> {
                stack.push(stackElements.get(index));
            });
        }

        for (int i = 0; i < 5; i++) {
            testingThreads[i] = new Thread(() -> {
                for (int j = 0; j < 2; j++) {
                    stack.pop();
                }
            });
        }

        IntStream.range(0, 5).forEach(i -> testingThreads[i].start());
        for (Thread t : testingThreads) {
            t.join();
        }
        assertTrue(stack.isEmpty());
    }

    @Test
    public void popOnEmptyStackTest() {
        LFStack<String> stack = new LFStack<>();
        assertNull(stack.pop());
    }

    @Test
    public void peekTest() {
        LFStack<Integer> stack = new LFStack<>();
        stack.push(99);
        assertEquals(Integer.valueOf(99), stack.peek());
    }

    @Test
    public void containsTest() throws InterruptedException {
        LFStack<String> stack = new LFStack<>();
        Thread thread1 = new Thread(() -> stack.push("elem1"));
        Thread thread2 = new Thread(() -> stack.push("elem2"));

        thread1.start();
        thread2.start();

        thread1.join();
        boolean check = stack.contains("elem2");
        thread2.join();

        assertTrue(check);
    }

}
