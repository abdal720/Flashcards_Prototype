import components.Flashcard;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import components.FlashcardBuilder;
import components.Question;
import components.Question.*;

public class Main {
    public static void main(String[] args) {
        testMultipleChoiceCard(1);
        testTrueOrFalse(2);
    }

    public static void testMultipleChoiceCard(int questionNum) {
        List<String> choiceOptions = new ArrayList<>();
        String subject = "computer science",
               question = "What are four aspects of algorithm complexity?",
               a = "input size, runtime, output size, rate of growth",
               b = "rate of growth, input size, CPU speed, runtime",
               c = "runtime, RAM space, output size, input size",
               d = "input size, CPU speed, RAM space, output size";
        choiceOptions.add(a);
        choiceOptions.add(b);
        choiceOptions.add(c);
        choiceOptions.add(d);
        String correctAnswer = choiceOptions.get(1);
        Flashcard multChoiceCard = FlashcardBuilder.buildMultipleChoice(
                subject, question, correctAnswer, choiceOptions
        );
        while (!multChoiceCard.isAnswerCorrect()) {
            System.out.println("Question "+questionNum+".");
            System.out.println("Subject: "+subject+".");
            System.out.println(multChoiceCard.getQuestion().toString() + "\n");
            printOptions(multChoiceCard.getQuestion());
            String input = new Scanner(System.in).nextLine().toUpperCase();
            multChoiceCard.setResponse(input);
            System.out.println(multChoiceCard.isAnswerCorrect() ? "Correct!\n" : "Incorrect\n");
        }
    }

    public static void testTrueOrFalse(int questionNum) {
        String subject = "Astronomy";
        String question = "Low thermal pressure can prevent interstellar clouds from " +
                          "gravitationally contracting.";
        // TODO: hint- cool enough to be a star
        Flashcard trueFalseCard = FlashcardBuilder.buildTrueOrFalse(subject, question, false);
        while (!trueFalseCard.isAnswerCorrect()) {
            System.out.println("Question "+questionNum+".");
            System.out.println("Subject "+subject+".");
            System.out.println(trueFalseCard.getQuestion().toString());
            printOptions(trueFalseCard.getQuestion());
            String input = new Scanner(System.in).nextLine();
            trueFalseCard.setResponse(input);
        }
    }

    public static void printOptions(Question question) {
        switch (question.getQuestionType()) {
            case MULTIPLE_CHOICE : printMultChoiceOpts(question.getAnswerOptions()); break;
            case MULTIPLE_SELECT : printMultSelectOpts(question.getAnswerOptions()); break;
            case TRUE_OR_FALSE   : printTrueFalseOpts(question.getAnswerOptions()); break;
            default : break;
        }
    }

    public static void printTrueFalseOpts(List<Answer> options) {
        System.out.println(options.get(1).toString()+"(t) or (f)"+options.get(0));
    }

    public static void printMultChoiceOpts(List<Answer> options) {
        char key = 'A';
        for (Object ansOpt : options) {
            System.out.println(key+". "+ansOpt.toString());
            key++;
        }
    }

    public static void printMultSelectOpts(List<Answer> options) {
        int opt = 1;
        for (Object ansOpt : options) {
            System.out.println(opt+". "+ansOpt);
            opt++;
        }
    }
}
