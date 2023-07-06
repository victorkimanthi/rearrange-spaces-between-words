package org.example;

import java.util.Scanner;

public class SpaceRearranger {
    public static String rearrangeSpaces(String text) {
        String[] words = text.trim().split("\\s+"); // Split text into words

        int wordCount = words.length;
        int totalSpaces = text.length() - text.replaceAll(" ", "").length();

        int equalSpaces = wordCount > 1 ? totalSpaces / (wordCount - 1) : totalSpaces;
        int extraSpaces = wordCount > 1 ? totalSpaces % (wordCount - 1) : totalSpaces;

        StringBuilder result = new StringBuilder();

        // Append the words with equal spaces between them
        for (int i = 0; i < wordCount; i++) {
            result.append(words[i]);

            if (i < wordCount - 1) {
                for (int j = 0; j < equalSpaces; j++) {
                    result.append(" ");
                }
            }
        }

        // Append the extra spaces at the end
        for (int i = 0; i < extraSpaces; i++) {
            result.append(" ");
        }

        return result.toString();
    }

    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter a sentence");
            String sentence = scanner.nextLine();
            String rearranged = rearrangeSpaces(sentence);
            System.out.println(rearranged);
        }
    }
}