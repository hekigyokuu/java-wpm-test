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

    public static void main(String[] args) {
        TypingTest type = new TypingTest();
        System.out.println(type.randomTextGenerator());
    }
}
