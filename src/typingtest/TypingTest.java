package typingtest;

import java.util.Scanner;
import java.util.Random;

public class TypingTest {
    private static final String[] TEXT_TO_INPUT = {
        "Life is really simple, but we insist on making it complicated.",
        "The only limit to our realization of tomorrow will be our doubts of today.",
        "Courage is grace under pressure."
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

    public void startTypingTest() {
        Scanner sc = new Scanner(System.in);

        String textToInput = randomTextGenerator();
        displayTestToInput(textToInput);

        confirmToStart(sc);

        long timeStart = System.currentTimeMillis();
        String userInput = scanUserInput(sc);
        long timeEnd = System.currentTimeMillis();
    }

    public static void main(String[] args) {
        TypingTest type = new TypingTest();
        System.out.println(type.randomTextGenerator());
    }
}
