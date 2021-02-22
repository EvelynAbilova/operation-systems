import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomString {
    public static List<String> getRandomString(int size) {
        ArrayList<String> Words = new ArrayList<>();
        Words.add("The");
        Words.add("Room");
        Words.add("oh");
        Words.add("hi");
        Words.add("Mark");
        Words.add("i");
        Words.add("did");
        Words.add("not");
        Words.add("hit");
        Words.add("her");
        Words.add("You");
        Words.add("Are");
        Words.add("Tearing");
        Words.add("Me");
        Words.add("Apart");
        Words.add("Lisa");
        Words.add("Danny");
        Words.add("Don't");
        Words.add("Worry");
        Words.add("About");
        Words.add("That");



        Random random = new Random();
        List<String> RandomString = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            RandomString.add(Words.get(random.nextInt(Words.size())));
        }
//        System.out.println(RandomString);
        return RandomString;
    }
}
