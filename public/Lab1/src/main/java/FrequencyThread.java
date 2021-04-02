import java.util.List;

public class FrequencyThread extends Thread {
    private List<String> strings;
    private int threadNumber;

    public void setThreadNumber(int threadNumber) {
        this.threadNumber = threadNumber;
    }

    public void setArray(List<String> strings) {
        this.strings = strings;
    }

    @Override
    public void run() {
        if(!currentThread().isInterrupted()) {
            for (int i = threadNumber; i < strings.size(); i += threadNumber) {
                FrequencyString.increaseCounter(strings.get(i));
            }
        }
    }
}
