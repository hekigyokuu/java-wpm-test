package typingtest;

import java.util.Scanner;
import java.util.Random;

public class TypingTest {
    private static final String[] TEXT_TO_INPUT = {
        "life is really simple but we insist on making it complicated",
        "the only limit to our realization of tomorrow will be our doubts of today",
        "courage is grace under pressure",
        "it does not matter how slowly you go as long as you do not stop",
        "in the middle of difficulty lies opportunity",
        "the trouble is you think you have time"
    };

    private String randomTextGenerator() {
        Random rand = new Random();
        return TEXT_TO_INPUT[rand.nextInt(TEXT_TO_INPUT.length)];
    }

    private void displayTestToInput(String textToInput) {
        System.out.println("Type the text as fast as you can!");
        System.out.println("\n" + textToInput + "\n");
    }

    private void confirmToStart(Scanner sc) {
        System.out.println("Press Enter to start...");
        sc.nextLine();
    }

    private String scanUserInput(Scanner sc) {
        System.out.println("Start typing now...");
        return sc.nextLine();
    }

    private double calcElapsedTime(long timeStart, long timeEnd) {
        return (timeEnd - timeStart);
    }

    private int calcWPM(String userInput, double elapsedTime) {
        int totalCharacters = userInput.length();
        double seconds = elapsedTime / 1000;
        int wpm = (int) ((totalCharacters / 5) / seconds * 60);
        return wpm;
    }

    private double calcAccuracy(String textToInput, String userInput) {
        int correctChar = 0;
        for (int i = 0; i < Math.min(textToInput.length(), userInput.length()); i++) {
            if (textToInput.charAt(i) == userInput.charAt(i)) {
                correctChar++;
            }
        }
        return (correctChar / (double) textToInput.length()) * 100;
    }

    private void results(double elapsedTime, int wpm, double accuracy) {
        System.out.println("\nResults: ");
        System.out.println("Time Taken: " + elapsedTime + " milliseconds (" + (elapsedTime/1000) + " seconds)");
        System.out.println("Word/s per Minute: " + wpm);
        System.out.println("Accuracy: " + accuracy + "%");
    }

    public void startTypingTest() {
        Scanner sc = new Scanner(System.in);

        String textToInput = randomTextGenerator();
        displayTestToInput(textToInput);

        confirmToStart(sc);

        long timeStart = System.currentTimeMillis();
        String userInput = scanUserInput(sc);
        long timeEnd = System.currentTimeMillis();

        double elapsedTime = calcElapsedTime(timeStart, timeEnd);
        int wpm = calcWPM(userInput, elapsedTime);
        double accuracy = calcAccuracy(textToInput, userInput);

        results(elapsedTime, wpm, accuracy);
    }

    public static void main(String[] args) {
        TypingTest type = new TypingTest();
        type.startTypingTest();
    }
}
