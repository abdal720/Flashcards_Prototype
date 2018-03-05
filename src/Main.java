import components.Flashcard;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

import components.FlashcardBuilder;

public class Main {
    public static void main(String[] args) {
        String subject = "computer science";
        String question = "What are four aspects of the complexity of an algorithm?";
        List<String> multipleChoices = new ArrayList<>();
        multipleChoices.add("input size, runtime, output size, rate of growth");
        multipleChoices.add("rate of growth, input size, CPU speed, runtime");
        multipleChoices.add("runtime, RAM space, output size, input size");
        multipleChoices.add("input size, CPU speed, RAM space, output size");
        String correctAnswer = multipleChoices.get(1);
        Flashcard multChoiceCard = FlashcardBuilder.buildMultipleChoice(
                subject, question, correctAnswer, multipleChoices
        );
        startGame(multChoiceCard);
    }

    public static void startGame(Flashcard flashcard) {
        while (!flashcard.isAnswerCorrect()) {
            System.out.println("Question 1: ");
            System.out.println(flashcard.getQuestion().toString() + "\n");
            char opt = 'A';
            for (Object ans : flashcard.getAnswerOptions()) {
                System.out.println(opt+". "+ans.toString());
                opt++;
            }
            String input = new Scanner(System.in).nextLine().toUpperCase();
            flashcard.setResponse(input);
            System.out.println(flashcard.isAnswerCorrect() ? "Correct!\n" : "Incorrect\n");
        }
    }
}
