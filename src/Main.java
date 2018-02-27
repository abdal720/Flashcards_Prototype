import components.Flashcard;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Enter question subject: ");
        String subject = new Scanner(System.in).nextLine();
        System.out.println("How many questions? ");
        int numQuestions = new Scanner(System.in).nextInt();
        Flashcard[] cards = createFlashcards(subject, numQuestions);
    }

    public static Flashcard[] createFlashcards(String subject, int numQuestions) {
        Flashcard[] flashcards = new Flashcard[numQuestions];

        for (int i = 0 ; i < flashcards.length ; i++) {
            System.out.println("Select question type: ");
            System.out.println("Enter question "+(i+1));
        }

        return flashcards;
    }
}
